package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto {
    
	public ProductoCooperativa(double precioBasico) {
		super(precioBasico);
		// TODO Auto-generated constructor stub
	}
   
		
	@Override
	public double precio() {
	
        return this.precioBasico * this.conceptoIVA();
	}
	
	
	private double conceptoIVA() {
		return 0.9d;
	}

}
