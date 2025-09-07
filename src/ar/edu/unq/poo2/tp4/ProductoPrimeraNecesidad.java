package ar.edu.unq.poo2.tp4;

public class ProductoPrimeraNecesidad extends Producto{

	public ProductoPrimeraNecesidad(String nombre, double precio) {
		super(nombre, precio);
		this.esPrecioCuidado=false;
		// TODO Auto-generated constructor stub
	}
	public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado) {
		super(nombre, precio, esPrecioCuidado);
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio() * this.descuento();
	}
	
	private double descuento() {
		// TODO Auto-generated method stub
		return 0.9;
	}

}
