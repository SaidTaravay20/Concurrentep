
package peluqueria;

import java.util.LinkedList;
import java.util.Queue;

public class Peluqueria {

    public static final int NUM_PELUQUERAS = 3;
    private static final int NUM_CLIENTES = 10;

    // Una cola, similar a una fila; salen los primeros que han llegado
    private Queue<Cliente> colaClientes = new LinkedList<>();

    // Objeto de bloqueo para la sincronización
    private final Object lock = new Object();

    // Hilos para las peluqueras
    private Thread[] peluqueras;

    // Constructor de Peluqueria
    public Peluqueria() {
        peluqueras = new Thread[NUM_PELUQUERAS];

        // Crear hilos de peluqueras
        for (int i = 0; i < NUM_PELUQUERAS; i++) {
            peluqueras[i] = new Thread(new Peluquera(this, "Peluquera " + (i + 1)));
        }
    }

    // Iniciar peluqueras y agregar clientes
    public void iniciar() {
        // Iniciar cada hilo de peluquera
        for (Thread peluqueraThread : peluqueras) {
            peluqueraThread.start();
        }

        // Crear y agregar clientes a la cola
        for (int i = 1; i <= NUM_CLIENTES; i++) {
            Cliente cliente = new Cliente("Cliente " + i);
            agregarCliente(cliente);
        }
    }

    // Método para agregar clientes a la cola de espera
    public void agregarCliente(Cliente cliente) {
        synchronized (lock) {
            colaClientes.offer(cliente);  // Añadir cliente a la cola
            lock.notify();  // Notificar a una peluquera que un cliente está disponible
        }
    }

    // Método para que una peluquera obtenga un cliente
    public Cliente obtenerCliente() throws InterruptedException {
        synchronized (lock) {
            while (colaClientes.isEmpty()) {
                lock.wait();  // Esperar si no hay clientes en la cola
            }
            return colaClientes.poll();  // Obtener y quitar el cliente de la cola
        }
    }
}
