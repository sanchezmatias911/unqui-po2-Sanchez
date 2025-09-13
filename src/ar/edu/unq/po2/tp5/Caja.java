package ar.edu.unq.po2.tp5;


import java.util.HashMap;


public class Caja implements CajaInterface{
	
	

	HashMap<Producto,Integer> stockProductos;
	
	private double montoAPagar = 0;

	@Override
	public void registrarProducto(Producto p) throws Exception{
		this.validarStock(p);
		this.montoAPagar = montoAPagar + p.precio();
		this.decrementarStock(p);
		
	}

	private void validarStock(Producto p) throws Exception {
		if (!this.hayStock(p)) {
			throw new Exception("error"); 
		}
		
	}

	@Override
	public double totalAPagar() {
		// TODO Auto-generated method stub
		return this.montoAPagar;
	}

	@Override
	public void decrementarStock(Producto p) {
		// TODO Auto-generated method stub
		int cantidadActual = stockProductos.get(p);
		stockProductos.put(p, cantidadActual -1 );
		
	}
	
	public boolean hayStock(Producto p) {
		return  this.stockDeUnProducto(p) > 0;
	}
	
	public int stockDeUnProducto(Producto p) {
		return stockProductos.get(p);
	}

}
