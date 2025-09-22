package ar.edu.unq.po2.tp5;

public class Servicio extends Factura  {
     
	private double costoUnidad;
	private int cantUnidades; 
	
	@Override
	public double precio() {
		return  (double) (costoUnidad * cantUnidades);
	}
}
