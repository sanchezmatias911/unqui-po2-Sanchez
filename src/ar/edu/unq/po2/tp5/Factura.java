package ar.edu.unq.po2.tp5;

public class Factura {
	
	Agencia miAgencia; 
	
    public void accionesRegistro() {
    	  miAgencia.registrarPago(this);
    }
}
