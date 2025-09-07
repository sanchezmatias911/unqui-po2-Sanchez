package ar.edu.unq.poo2.tp4;

public class Producto {
	
	private double precio;
	private String nombre;
	protected boolean esPrecioCuidado = false;
	
	public boolean esPrecioCuidado() {
		return esPrecioCuidado;
	}

	public Producto(String nombre, double precio, boolean esPrecioCuidado) {
		this.nombre = nombre;
		this.precio = precio;
		this.esPrecioCuidado=esPrecioCuidado;
	}
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}

	public void aumentarPrecio(double d) {
		this.precio = precio + d;
		
	}
}
