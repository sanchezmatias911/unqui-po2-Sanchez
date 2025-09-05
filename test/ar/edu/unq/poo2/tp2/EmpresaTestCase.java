package ar.edu.unq.poo2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp2.Empleado;
import ar.edu.unq.po2.tp2.EmpleadoContratado;
import ar.edu.unq.po2.tp2.EmpleadoPermanente;
import ar.edu.unq.po2.tp2.EmpleadoTemporario;
import ar.edu.unq.po2.tp2.Empresa;

class EmpresaTestCase {

	private Empresa empresa;
	private Empleado matias;
	private Empleado julian;
	private Empleado raul;
	
	@BeforeEach
	void setUp() {

		empresa = new Empresa("Empresa de Matias","42-12345976-4");
				
	    matias = new EmpleadoPermanente(
	    		          "Matias",
	                      "Calle 117 3081",
		                  "Soltero",
			              LocalDate.of(1996, 11, 15),
			              (float) 200000,
			              2,
			              2);
	    
	    julian = new EmpleadoTemporario(
		          "Julian",
                "Calle 22 421",
                "Casado",
	              LocalDate.of(1992, 9, 1),
	              (float) 200000,
	              LocalDate.of(2025, 11, 10),
	              2);
	    
	    raul = new EmpleadoContratado(
		          "Matias",
                "Calle 117 3081",
                "Soltero",
	              LocalDate.of(1996, 11, 15),
	              (float) 200000,
	              "Efectivo",
	              "1122751845");
		
	    empresa.agregarEmpleado(matias);
	    empresa.agregarEmpleado(julian);
	    empresa.agregarEmpleado(raul);
		
	}
	
	@Test
	void testCalculoTotalSueldosNetos() {
		assertEquals(510264f,empresa.montoTotalSueldosNetos());
	}
	@Test
	void testLiquidacionDeSueldos() {
		// TODO : Si bien el test pasa, no genera el recibo de sueldo con los montos y deducciones. 
		//        Lo arreglare estos dias
		
		assertDoesNotThrow(() -> empresa.liquidarSueldos());
	}
	

}
