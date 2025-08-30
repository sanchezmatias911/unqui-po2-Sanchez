package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class ReciboHaberes {
	
	 private String desgloceActual;
     private String nombreEmpleado;
     private String direccionEmpleado;
 
  	 private LocalDate fechaEmision;
    
     
     public ReciboHaberes( // quizas deberia recibir un empleado y que el recibo se encargue 
    		 String desgloceActual,
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
    	 System.out.println(desgloceActual);
     }
}   
     
  
     
     

