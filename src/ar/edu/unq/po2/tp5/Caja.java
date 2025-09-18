package ar.edu.unq.po2.tp5;

public class Caja {
	
	
	double totalAPagar = 0;
	
 
	public void registrar(Registrable p){
		
		p.accionesRegistro();
		totalAPagar+= p.precio();
	}
	
	
	public double totalAPagar() {
		// TODO Auto-generated method stub
		return totalAPagar;
	}


}
