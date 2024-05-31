/**
 * CajeraThreadProductoPrincipal.java
 */
package com.iudigital.concurrency.activity.withthread;

import com.iudigital.concurrency.activity.domain.ClienteProducto;
import com.iudigital.concurrency.activity.domain.Producto;

import java.util.ArrayList;
import java.util.List;

public class CajeraThreadProductoPrincipal {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        setProductos(productos);

        ClienteProducto cliente1 = new ClienteProducto("Tony Stark" , productos);
        ClienteProducto cliente2 = new ClienteProducto("Superman" , productos);
        ClienteProducto cliente3 = new ClienteProducto("Aquaman" , productos);

        long tiempoInicial = System.currentTimeMillis();
        CajeraThreadProducto cajeraUno = new CajeraThreadProducto(" ValentinaCaj", cliente3, tiempoInicial);
        CajeraThreadProducto cajeraDos = new CajeraThreadProducto(" PaolaCaj", cliente1, tiempoInicial);
        CajeraThreadProducto cajeraTres = new CajeraThreadProducto(" FranchescaCaj", cliente2, tiempoInicial);

        cajeraUno.start();
        cajeraDos.start();
        cajeraTres.start();
    }

    private static void setProductos(List<Producto> productos) {
        Producto productoUno = new Producto("Zapatos" , 500, 6);
        Producto productoDos = new Producto("Pantalones" , 800, 18);
        Producto productoTres = new Producto("Camisas" , 500, 46);

        productos.add(productoUno);
        productos.add(productoDos);
        productos.add(productoTres);
    }
}
