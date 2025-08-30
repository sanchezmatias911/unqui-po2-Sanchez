package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {

		private String nombre;
		private String direccion;
		private String estadoCivil;
		private LocalDate fechaNac;
		private float sueldoBasico;
		
		public String nombre() {
			return nombre;
		}
		public String direccion() {
			return direccion;
		}
		public float sueldoBasico() {
			return sueldoBasico;
		}
		
		public String estadoCivil(){
			return estadoCivil;
		}
		public int edad() {
			return this.diferenciaEnAños(this.fechaNac(),this.fechaDeHoy());
		}
		
		private int diferenciaEnAños(LocalDate fechaInicio, LocalDate fechaFin) {
			return Period.between(fechaInicio,fechaFin).getYears();
		}
		
		private LocalDate fechaDeHoy() {
			return LocalDate.now();
		}
		
		
	
		private LocalDate fechaNac() {
			return fechaNac;
		}
		
		
		
		//SUELDO BRUTO 
		public float sueldoBruto() {
			return this.sueldoBasico() ;
		}
		//RETENCIONES
		public float retenciones(){
			return this.retencionesPorObraSocial() + this.retencionesPorAportesJubilatorios();
		}
		
		public float retencionesPorObraSocial() {
			return (float) (this.porcentajePorObraSocial()+
							 this.asignacionExtraObraSocial());
		}
		 
		public float asignacionExtraObraSocial() {
			return (float) 0.0;
		}
		
		public float porcentajePorObraSocial() {
			return (float) (this.sueldoBruto() *  0.1);
		}
       
       
       //Aportes jubilatorios
       public float retencionesPorAportesJubilatorios() {
   		return (float) (this.sueldoBruto() * this.porcentajeRetencionJubilacion());
   	   }
       
       public float porcentajeRetencionJubilacion() {
    	   return (float) 1;
       }
       
       // SUELDO NETO
		
		public float sueldoNeto() {
			return this.sueldoBruto() - this.retenciones();
		}
		
		/*Debido a que cada clase de empleado tendra 
		 * conceptos diferentes en su recibo tome la
		 * decicion de que el propio empleado cree su recibo
		 * para el momento en que la empresa genere el recibo
		 */
		public abstract String generarReciboDeSueldo();
		
		// para generar el recibo
		public float calcular (float montoACalcular[]) {
			float totalMontos = 0;
			  for (float monto : montoACalcular) {
		            totalMontos += monto;
		        }
			  return totalMontos;
		}
			
		
		
		
		
}
