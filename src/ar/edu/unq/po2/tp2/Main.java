package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpleadoPermanente matias =
				new EmpleadoPermanente("Matias",
						               "Calle 117 3081",
						               "Soltero",
						               LocalDate.of(1996, 11, 15),
						               (float) 12313.32,
						               0,
						               2);
		//String reciboMatias = matias.generarReciboDeSueldo();
		System.out.println(matias.sueldoNeto());
	}

}
