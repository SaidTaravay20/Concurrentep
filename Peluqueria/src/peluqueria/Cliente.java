
package peluqueria;


public class Cliente {
   
private final String name;


   public Cliente(String name){

   this.name=name;

   }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name; 
    } 

}
