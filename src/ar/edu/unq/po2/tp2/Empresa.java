package ar.edu.unq.po2.tp2;


import java.time.LocalDate;
import java.util.Set;

public class Empresa {

	private String nombre;
	private String cuit;
	private  static Set<Empleado> empleados;
	private  static Set <ReciboHaberes> reciboHaberesEmpleados;
	
	public  void liquidarSueldos() {
		for (Empleado emp : empleados) {
			this.generarReciboHaberes(emp);
			
		}
		
	}
	public static float montoTotalSueldosBrutos() {
	    return (float) empleados.stream()
	                   .mapToDouble(Empleado::sueldoBruto) 
	                   .sum();    
	}
	
	public static float montoTotalSueldosNetos() {
		return (float) empleados.stream()
                       .mapToDouble(Empleado::sueldoNeto) 
                       .sum();    
	}
	
	public static float montoTotalRetenciones() {
		return (float) empleados.stream()
                       .mapToDouble(Empleado::retenciones) 
                       .sum();
	}
	
	public void generarReciboHaberes(Empleado emp) {
		ReciboHaberes nuevoRecibo = new ReciboHaberes(
				emp.generarReciboDeSueldo(),
				emp.nombre(),
				emp.direccion(),
				LocalDate.now());
		
		reciboHaberesEmpleados.add(nuevoRecibo);
		
	}
}
