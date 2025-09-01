package ar.edu.unq.poo2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.DesarmadorNumeros;

class DesarmadorNumerosTestCase {
	
	private DesarmadorNumeros desarmador;

	@Test
	public void funcionamientoDesarmador() {
		int[] pruebas = {53492293,32222,9842};
		int[] pruebas2 = {222,3124222,2,542,8,6,222222222,1345454,};
		int[] pruebas3 = {53492293,32222,9842,422222,666666,222};
		desarmador = new DesarmadorNumeros();
		
		
		assertEquals(32222,desarmador.elDeMayorDigitos(pruebas));
		assertEquals(222222222,desarmador.elDeMayorDigitos(pruebas2));
		assertEquals(666666,desarmador.elDeMayorDigitos(pruebas3));
	}

}
