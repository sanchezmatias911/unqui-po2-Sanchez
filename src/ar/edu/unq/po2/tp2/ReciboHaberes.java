package tpUML;

import java.time.LocalDate;

public class ReciboHaberes {
	
	 private DesgloceConceptos desgloceActual;
     private String nombreEmpleado;
     private String direccionEmpleado;
 
  	 private LocalDate fechaEmision;
    
     
     public ReciboHaberes(
    		 DesgloceConceptos desgloceActual,
    		 String nombreEmpleado, 
    	     String direccionEmpleado,
             LocalDate fechaEmision)
     {
    	 this.desgloceActual=desgloceActual;
    	 this.nombreEmpleado=nombreEmpleado;
    	 this.direccionEmpleado=direccionEmpleado;
    	 this.fechaEmision=fechaEmision;
    	
     } 
     public String nombreEmpleado() {
    	 return nombreEmpleado;
     }
     
     public String direccionEmpleado(){
    	 return direccionEmpleado;
     }
     public LocalDate fechaEmision() {
    	 return fechaEmision;
     }
     
     public void desgloceDeConceptos() {
    	 desgloceActual.darInformacion();
     }
     
     
}
