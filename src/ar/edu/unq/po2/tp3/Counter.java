package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Counter {
	
   ArrayList<Integer> numerosCont = new ArrayList<Integer>();
   
   public ArrayList<Integer> numerosCont(){
	   return numerosCont;
   }
   
   public int getEvenOcurrences() {
	   	   
	   return this.sumarPorCondicion(num -> this.esPar(num));
   }
   
   public int getOddOcurrences() {
	  
	   return this.sumarPorCondicion(num -> !this.esPar(num));
   }
   
   public int sumarPorCondicion(Predicate<Integer> condicion ) {
	   return (int) numerosCont.stream()
				    .filter(condicion)
				    .count();
				  
   }
   
   public int getMultiplesOf(int num) {
	   return 0;
   }

   public void addNumber(int i) {
	// TODO Auto-generated method stub
	 numerosCont.add(i);
   }
   
   public boolean esPar(int n) {
	   return n % 2 == 0;
   }
   
  

   
}
