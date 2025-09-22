package ar.edu.unq.poo2.tp5;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import ar.edu.unq.po2.tp5.Caja;
import ar.edu.unq.po2.tp5.Producto;
import ar.edu.unq.po2.tp5.ProductoCooperativa;



class CajaTestCase {
    
	Caja cajaSuper;
	Producto p1;
	Producto p2;
	Producto p3;
	
	@BeforeEach
	void setUp()  {
		cajaSuper = new Caja();
		p1 = new Producto(10.4);
		p2 = new ProductoCooperativa(12.4);
		p3 = new ProductoCooperativa(14.2);	
		cajaSuper.registrar(p1);
	    cajaSuper.registrar(p2);
	    cajaSuper.registrar(p3);
	       
		
	}

	@Test
	void funcionamientoMontoAPagar()  {
		  assertEquals(10.4d,p1.precio());
		  assertEquals(11.16d,p2.precio());
		  assertEquals(12.78d,p3.precio());
		  assertEquals(34.34d,cajaSuper.totalAPagar());
	    
	}

}
