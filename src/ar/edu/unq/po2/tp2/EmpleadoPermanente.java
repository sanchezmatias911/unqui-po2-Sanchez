package ar.edu.unq.po2.tp2;

public class EmpleadoPermanente extends Empleado{
	
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
	
	
	
	
}
