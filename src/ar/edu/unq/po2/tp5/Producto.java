package ar.edu.unq.po2.tp5;

public class Producto implements Registrable{
	
	int stock;
    double precioBasico;
	
	public Producto(double precioBasico, int stock) {
	            this.precioBasico = precioBasico;
	            this.stock = stock;
	}
		
	@Override	
	public double precio() {
		return this.precioBasico;// TODO Auto-generated method stub

	}


	@Override
	public void accionesRegistro() {
		stock-=1;
		
	}
}
