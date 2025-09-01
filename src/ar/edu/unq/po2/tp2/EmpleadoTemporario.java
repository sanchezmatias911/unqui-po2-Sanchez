package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.Date;

public class EmpleadoTemporario extends Empleado{
	
	

	public EmpleadoTemporario(String nombre, String direccion, String estadoCivil, LocalDate fechaNac,
			float sueldoBasico, Date fechaFinDesignacion, int cantidadHorasExtra) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.fechaFinDesignacion = fechaFinDesignacion;
		this.cantidadHorasExtra = cantidadHorasExtra;
	}

	private Date fechaFinDesignacion;
	private int cantidadHorasExtra;
	
	
	
	private int cantidadHorasExtra() {
		return cantidadHorasExtra;
	}
	@Override
	public float sueldoBruto() {
		return super.sueldoBruto() + this.asignacionPorHorasExtras();
	}
	
	public float asignacionPorHorasExtras() {
		return (float) (this.cantidadHorasExtra()* this.bonoPorHoraExtra());
	}
	public float bonoPorHoraExtra() {
		return 40;
	}
	
	//RETENCIONES
	
	@Override
	public float retenciones() {return super.retenciones() ;}
	
	@Override
	public float asignacionExtraObraSocial() {
		if (this.cumpleRequisitoParaExtraPorEdad()) {
			return (float) (25);
		}
		return (float) (0);
	}
	
	public float retencionesPorAportesJubilatorios() {
		return super.retencionesPorAportesJubilatorios() + this.retencionPorHorasExtra();
	}
	
	public float retencionPorHorasExtra() {
		return (float) this.cantidadHorasExtra() * 5;
	}
	
	@Override 
	public float porcentajeRetencionJubilacion() {
		return (float) 0.10;
	}
	
	
	public boolean cumpleRequisitoParaExtraPorEdad() {
		return this.edad() >50;
	}
	
	@Override
	public String generarReciboDeSueldo() {
		
        // Conceptos, montos y deducciones por columnas 
		// si los conceptos son montos se pide el monto, si no el valor es 0 
		// Los valores estan indexados en los 3 Arrays
        String[] conceptos  = {"Sueldo Básico", "Horas Extra",  "Obra Social", "Aportes Jubilatorios" };
        float[] montos      = {this.sueldoBasico(), this.asignacionPorHorasExtras(), 0 , 0   };
        float[] deducciones = {0 , 0   , this.retencionesPorObraSocial(), this.retencionesPorAportesJubilatorios()};

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
