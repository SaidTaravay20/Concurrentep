
package poo.concurrente;

//Hacer que extienda de la clase Threadimport 
//La diferencia principal es que Java no deja hacer herencia multiple por lo tanto es exclusivo de una clase y mas directo

//Hacer un bucle que se ejecute 2 veces de manera simultanea
public class HiloThread extends Thread {
    
  public void run(){
  
 for(int i=0; i<=5 ; i++) {
     //Usar el metodo current Thread que usa el hilo actual
     System.out.println("Hilo"+ Thread.currentThread().getId() + ": " + i);
     //Hacer un thread sleep que hara que con cada iteracion se detenga el proceso un segundo.
     try{
     
     Thread.sleep(1000);
     
        } catch (InterruptedException ex) {
         System.out.println("Hilo interrumpido ");
     }
     
 }
      
  }  
 public static void main(String[] args){
 
 //Instanciar hilo thread
 
 HiloThread hilo1= new HiloThread();
 HiloThread hilo2= new HiloThread();
 
//Ahora en vez de usar el run seria secuencial vamos a hacerlo de manera concurrente
//La velocidad sera diferente
//El bucle for se inicializa en 2 hilos

hilo1.start();
hilo2.start();

 }   
    
}
