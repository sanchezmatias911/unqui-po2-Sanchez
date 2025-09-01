package ar.edu.unq.po2.tp3;


public class DesarmadorNumeros {
	
	public int elDeMayorDigitos(int[] nums) {
		/*transformar cada numero en un array, contar la cantidad de 
		 * pares de ese array, y de volver el que mayor numero
		 * de pares tenga 
		 * 
		 * 
		 */
		int numCandidato = nums[0];
		int paresMaximos = this.cantidadDigitosPares(nums[0]);
		
		for (int i=1; i< nums.length;i++) {
			
			int paresNumActual = this.cantidadDigitosPares(nums[i]);
			
			if(paresNumActual > paresMaximos) {
				numCandidato = nums[i];
			}
		}
		
		return numCandidato;
	}
	
	/*
	 * Use IA para el siguiente metodo porque no logre resolverlo
	 * */
	 public int cantidadDigitosPares(int n) {
		     
	        long val = Math.abs((long) n);
	        if (val == 0) return 1;

	        int cuenta = 0;
	        while (val > 0) {
	            if ((val % 10) % 2 == 0) cuenta++;
	            val /= 10;
	        }
	        return cuenta;
	    }
}
