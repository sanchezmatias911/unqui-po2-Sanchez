package ar.edu.unq.po2.tp5;



public interface CajaInterface {
	
	
   
	public void registrarProducto(Producto p) throws Exception;
	
	public double totalAPagar();
	
	public void decrementarStock(Producto p);
}
