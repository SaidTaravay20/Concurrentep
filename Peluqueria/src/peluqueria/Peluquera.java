
package peluqueria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Peluquera implements Runnable {

private final Peluqueria peluqueria;
private final String nombre;

    public Peluquera(Peluqueria peluqueria, String nombre) {
        this.peluqueria = peluqueria;
        this.nombre = nombre;
    }



@Override
public void run(){

    Random random = new Random();
    
    try{
        
      while(true){
      
      Cliente cliente = peluqueria.obtenerCliente();
      System.out.println(nombre + " Comienza a atender a " + cliente);
      int tiempoAtencion= random.nextInt(10)+1;
      Thread.sleep(tiempoAtencion*1000);
      System.out.println(nombre + " termino de atender a "+ cliente.getName() + " en " + tiempoAtencion + " Segundos");
      
      }
   
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }

  }

   
}
