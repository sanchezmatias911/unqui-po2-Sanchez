package tpUML;

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
	private float salarioFamiliar() {
		return this.asignacionPorHijo() + 
			   this.asignacionPorConyuge() ;
			   
	}
	
	private float asignacionPorConyuge() {
		
		if (this.tieneConyuge()) {
			return 100;
		}
		else return 0;
	}
	
	private boolean tieneConyuge() {
		return this.estadoCivil().equalsIgnoreCase("Casado/a");
	}
	private float asignacionPorHijo() {
		return this.cantidadHijos() * this.extraPorHijo();
	}
	
	private float asignacionPorAntiguedad() {
		return this.antiguedad() * this.extraPorAntiguedad(); 
	}
	
	private int extraPorAntiguedad() {
		return 50;
	}
	
	
	private float extraPorHijo() {
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
