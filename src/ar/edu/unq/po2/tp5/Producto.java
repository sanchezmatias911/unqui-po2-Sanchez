package ar.edu.unq.po2.tp5;

public  class Producto implements Registrable{
	
	
    double precioBasico;
	
	public Producto(double precioBasico) {
	            this.precioBasico = precioBasico;
	           
	}
		
	@Override
	public double precio() {
		return this.precioBasico;// TODO Auto-generated method stub

	}


	public void registrarse(Caja caja) {
		caja.registrarProducto(this);
		
	}
}
