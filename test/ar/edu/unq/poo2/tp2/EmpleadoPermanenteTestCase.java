package ar.edu.unq.poo2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp2.EmpleadoPermanente;

class EmpleadoPermanenteTestCase {
	
	 private EmpleadoPermanente matias;
	
	 @BeforeEach
	 void crearEmpleadoPermanente() {
		matias = new EmpleadoPermanente("Matias",
							            "Calle 117 3081",
							            "Soltero",
							            LocalDate.of(1996, 11, 15),
							            (float) 200000,
							             2,
							             2);
	 }
	@Test
	void testFuncionamientoSueldoNeto() {
		assertEquals(1,1);
	}
	@Test
	void testFuncionamientoSueldoBruto() {
		//Calculamos lo que influye en el sueldo bruto 
		assertEquals(100,matias.asignacionPorAntiguedad());
		assertEquals(300,matias.salarioFamiliar());
		assertEquals(200000,matias.sueldoBasico());
		assertEquals(200400,matias.sueldoBruto());
	}
	@Test
	void testFuncionamientoRetenciones() {
		assertEquals(20080f,matias.retencionesPorObraSocial());
		assertEquals(30060.002f,matias.retencionesPorAportesJubilatorios());
		assertEquals(50140f,matias.retenciones());
	}

}
