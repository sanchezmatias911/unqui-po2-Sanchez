package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado{
	
	

	public EmpleadoPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNac,
			float sueldoBasico, int cantidadHijos, int antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.cantidadHijos = cantidadHijos;
		this.antiguedad = antiguedad;
	}

	private int cantidadHijos;
	
	private int antiguedad;
	
	private int cantidadHijos() {
		return cantidadHijos;
	}
	
	private int antiguedad() {
		return antiguedad;
	}
	//SALARIO FAMILIAR
	public float salarioFamiliar() {
		return this.asignacionPorHijo() + 
			   this.asignacionPorConyuge() ;
			   
	}
	
	public float asignacionPorConyuge() {
		
		if (this.tieneConyuge()) {
			return 100;
		}
		else return 0;
	}
	
	public boolean tieneConyuge() {
		return this.estadoCivil().equalsIgnoreCase("Casado/a");
	}
	public float asignacionPorHijo() {
		return this.cantidadHijos() * this.extraPorHijo();
	}
	
	public float asignacionPorAntiguedad() {
		return this.antiguedad() * this.extraPorAntiguedad(); 
	}
	
	public int extraPorAntiguedad() {
		return 50;
	}
	
	
	public float extraPorHijo() {
		return 150;
	}
	
	//SUELDO BRUTO
	public float sueldoBruto() {
		return super.sueldoBruto() + 
				this.salarioFamiliar() + 
				this.asignacionPorAntiguedad();}
	
	@Override
	public float asignacionExtraObraSocial(){
		return (float) (this.cantidadHijos() * 20);
	}
	@Override 
	public float porcentajeRetencionJubilacion() {
		return (float) 0.15;
	}
	
	// Desgloce de conceptos 
	
	
	@Override
	public String generarReciboDeSueldo() {
		
        // Conceptos, montos y deducciones por columnas 
		// si los conceptos son montos se pide el monto, si no el valor es 0 
		// Los valores estan indexados en los 3 Arrays
        String[] conceptos  = {"Sueldo Básico", "Salario Familiar", "Antiguedad", "Obra Social", "Aportes Jubilatorios" };
        float[] montos      = {this.sueldoBasico(), this.salarioFamiliar(), this.asignacionPorAntiguedad(), 0 , 0   };
        float[] deducciones = {0 , 0  , 0   , this.retencionesPorObraSocial(), this.retencionesPorAportesJubilatorios()};

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
