
package poo.concurrente;

public class HiloRunnable implements Runnable {
 //Run es el metodo que se implementa de la interfaz runnable
   public void run(){
  
 for(int i=0; i<=5 ; i++) {
     //Usar el metodo current Thread que usa el hilo actual
     System.out.println("Hilo"+ Thread.currentThread().getId() + ": " + i);
     //Hacer un thread sleep que hara que con cada iteracion se duerma un segundo.
     try{
     
     Thread.sleep(1000);
     
        } catch (InterruptedException ex) {
         System.out.println("Hilo interrumpido ");
     }
     
 }
      
  }    
 //Diferencia entre extension de thread y la implementacion de runnable
   
 public static void main(String[] args){
 
 HiloRunnable Runnable1= new HiloRunnable();
 HiloRunnable Runnable2= new HiloRunnable();
 
  //Creacion de hilos
  
 //Instanciar Thread 
  
 Thread Hilo1 = new Thread(Runnable1);
 Thread Hilo2 = new Thread(Runnable2);
 
 
 Hilo1.start();
 Hilo2.start();
 
  
  
 }
 
}
