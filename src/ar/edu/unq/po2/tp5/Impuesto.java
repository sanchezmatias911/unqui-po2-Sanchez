package ar.edu.unq.po2.tp5;

public class Impuesto extends Factura implements Registrable {
	
	private double tasaServicio;

	@Override
	public double precio() {
		// TODO Auto-generated method stub
		return tasaServicio;
	}

}
