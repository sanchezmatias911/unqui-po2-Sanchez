package ar.edu.unq.po2.tp5;

public abstract class Factura implements Registrable{
	
	
	public abstract double precio();
    public void registrarse(Caja caja) {
    	  caja.registrarFactura(this);
    }
}
