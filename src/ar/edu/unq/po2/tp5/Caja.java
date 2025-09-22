package ar.edu.unq.po2.tp5;

public class Caja {
	
	Agencia miAgencia = new AgenciaC();
	Mercado miMercado = new MercadoC();
	
	double totalAPagar = 0;
	
 
	public void registrar(Registrable p){
		
		p.registrarse(this);
		totalAPagar+= p.precio();
	}
	
	public void registrarFactura(Factura factura) {
		miAgencia.registrarPago(factura);
	}
	
	public void registrarProducto(Producto producto) {
		miMercado.decrementarStock(producto);
	}  
	
	
	public double totalAPagar() {
		// TODO Auto-generated method stub
		return totalAPagar;
	}
	
	
	
	


}
