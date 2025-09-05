package ar.edu.unq.po2.tp2;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Empresa {


	private String nombre;
	private String cuit;
	private  static Set<Empleado> empleados;
	private  static Set <ReciboHaberes> reciboHaberesEmpleados;
	
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		empleados = new HashSet<Empleado>();
		reciboHaberesEmpleados = new HashSet<ReciboHaberes>();
	}
	
	
	public void agregarEmpleado(Empleado emp) {
		this.validarEmpleado(emp);
		empleados.add(emp);
	}
	
	private void validarEmpleado(Empleado emp) {
		if(this.estaEnMiNomina(emp)) {
			throw new Error("El empleado esta en mi nomina"); 
		}
	}
	private boolean estaEnMiNomina(Empleado emp) {
		return empleados.contains(emp);
	}
	
	public  void liquidarSueldos() {
		for (Empleado emp : empleados) {
			this.generarReciboHaberes(emp);
			
		}
		
	}
	public  float montoTotalSueldosBrutos() {
	    return (float) empleados.stream()
	                   .mapToDouble(Empleado::sueldoBruto) 
	                   .sum();    
	}
	
	public  float montoTotalSueldosNetos() {
		return (float) empleados.stream()
                       .mapToDouble(Empleado::sueldoNeto) 
                       .sum();    
	}
	
	public  float montoTotalRetenciones() {
		return (float) empleados.stream()
                       .mapToDouble(Empleado::retenciones) 
                       .sum();
	}
	
	public void generarReciboHaberes(Empleado emp) {
		// TODO El metodo generarReciboDeSueldo de empleado falla al darme el texto del recibo
		ReciboHaberes nuevoRecibo = new ReciboHaberes(
				//emp.generarReciboDeSueldo(),
				"",
				emp.nombre(),
				emp.direccion(),
				LocalDate.now());
		
		reciboHaberesEmpleados.add(nuevoRecibo);
		
	}
}
