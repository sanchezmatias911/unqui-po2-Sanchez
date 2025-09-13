package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto {
    
	double precioBasico; 
	
	public ProductoCooperativa(double precioBasico) {
			this.precioBasico = precioBasico;
	}
	@Override
	public double precio() {
		// TODO Auto-generated method stub
        return this.precioBasico * this.conceptoIVA();
	}
	
	public double conceptoIVA() {
		return 0.9;
	}

}
