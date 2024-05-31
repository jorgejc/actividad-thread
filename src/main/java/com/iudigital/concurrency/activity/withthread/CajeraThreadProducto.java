/**
 * CajeraThreadProducto.java
 */
package com.iudigital.concurrency.activity.withthread;

import com.iudigital.concurrency.activity.domain.ClienteProducto;
import com.iudigital.concurrency.activity.domain.Producto;

public class CajeraThreadProducto extends Thread{

    private String nombre;
    private ClienteProducto cliente;
    private long tiempoInicial;

    public CajeraThreadProducto(String nombre, ClienteProducto cliente, long tiempoInicial) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoInicial = tiempoInicial;
    }

    @Override
    public void run() {
        System.out.println(" La cajera " + this.nombre + " comienza a procesar la compra del cliente "
            + this.cliente.getNombre() + " en el tiempo "
            + (System.currentTimeMillis() - this.tiempoInicial) / 1000
            + " segundos \n");
        System.out.println("==================================================================================================================== ");

        int contadorCliente = 1;
        for (Producto producto : cliente.getProductos()) {
            this.esperarXSegundos();
            System.out.println(" Procesando el producto " + contadorCliente
                + " nombre producto " + producto.getNombre()
                + " precio producto " + producto.getPrecio()
                + " cantidad de productos " + producto.getCantidad()
                + " costo total de cada producto " + producto.getCantidad() * producto.getPrecio()
                + " del cliente " + this.cliente.getNombre()
                + " -> Tiempo " + (System.currentTimeMillis() - this.tiempoInicial) / 1000 + " segundos ");
            contadorCliente++;
            System.out.println("==================================================================================================================== ");
            System.out.println("==================================================================================================================== ");
        }
        System.out.println(" ====================================================================================================================== ");
        System.out.println(" La cajera " + this.nombre + " ha terminado de procesar "
            + this.cliente.getNombre() + " en el tiempo "
                + (System.currentTimeMillis() - this.tiempoInicial) / 1000 + " segundos " );
    }

    private void esperarXSegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
