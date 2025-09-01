package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoContratado extends Empleado {

	
	
	public EmpleadoContratado(String nombre, String direccion, String estadoCivil, LocalDate fechaNac,
			float sueldoBasico, String medioDePago, String numeroDeContacto) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.medioDePago = medioDePago;
		this.numeroDeContacto = numeroDeContacto;
	}

	String medioDePago;
	String numeroDeContacto;
	
	@Override
	public float retenciones(){
		return this.gastosAdministrativosContractuales();
	}
	
	public float gastosAdministrativosContractuales() {
		return (float) 50;
	}
	
	@Override
	public String generarReciboDeSueldo() {
		
        // Conceptos, montos y deducciones por columnas 
		// si los conceptos son montos se pide el monto, si no el valor es 0 
		// Los valores estan indexados en los 3 Arrays
        String[] conceptos  = {"Sueldo Básico", "Gastos Administrativos" };
        float[] montos      = {this.sueldoBasico(),  0   };
        float[] deducciones = {0 , this.gastosAdministrativosContractuales()};

        // Calcular sueldoNeto
       
        float totalMontos = this.calcular(montos);
        float totalDeducciones = this.calcular(deducciones);
        float sueldoNeto = totalMontos - totalDeducciones;

        // Construimos el recibo de haberes
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================================\n");
        sb.append(String.format("%30s%n", "RECIBO DE HABERES"));
        sb.append("=====================================================\n");
        sb.append(String.format("Empleado: %-20s", this.nombre()));
        sb.append("-----------------------------------------------------\n");
        sb.append(String.format("%-20s %15s %15s%n", "Concepto", "Monto", "Deducción"));
        sb.append("-----------------------------------------------------\n");

        for (int i = 0; i < conceptos.length; i++) {
            sb.append(String.format("%-20s %15d %15d%n", conceptos[i], montos[i], deducciones[i]));
        }

        sb.append("-----------------------------------------------------\n");
        sb.append(String.format("%-20s %15d %15d%n", "Totales:", totalMontos, totalDeducciones));
        sb.append("-----------------------------------------------------\n");
        sb.append(String.format("%-20s %15d%n", "SUELDO NETO:", sueldoNeto));
        sb.append("=====================================================\n");

        //Devolvemos el recibo
        return sb.toString();
	}

}
