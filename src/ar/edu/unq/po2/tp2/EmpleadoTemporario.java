package ar.edu.unq.po2.tp2;

import java.util.Date;

public class EmpleadoTemporario extends Empleado{
	
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
}
