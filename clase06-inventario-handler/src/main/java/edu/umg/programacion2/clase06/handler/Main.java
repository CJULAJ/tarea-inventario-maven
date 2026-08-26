package edu.umg.programacion2.clase06.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.umg.programacion2.clase06.inventario.InventarioService;
import edu.umg.programacion2.clase06.inventario.modelo.Producto;

public class Main {

    public static void main(String[] args) {

        // 1. Preparamos un inventario de ejemplo usando la dependencia
        //    (clase06.inventario.dependencia, version definida en el pom.xml).
        InventarioService inventario = new InventarioService();
        inventario.agregarProducto(new Producto(1, "Laptop", "Electronica", 4500.00, 8));
        inventario.agregarProducto(new Producto(2, "Mouse inalambrico", "Electronica", 85.50, 40));
        inventario.agregarProducto(new Producto(3, "Teclado mecanico", "Electronica", 320.00, 3));
        inventario.agregarProducto(new Producto(4, "Monitor 24\"", "Electronica", 1150.00, 5));
        inventario.agregarProducto(new Producto(5, "Arroz 1lb", "Alimentos", 6.50, 120));
        inventario.agregarProducto(new Producto(6, "Aceite 1L", "Alimentos", 18.00, 60));
        inventario.agregarProducto(new Producto(7, "Cafe 500g", "Alimentos", 45.00, 2));
        inventario.agregarProducto(new Producto(8, "Camisa formal", "Ropa", 175.00, 15));
        inventario.agregarProducto(new Producto(9, "Pantalon", "Ropa", 210.00, 4));
        inventario.agregarProducto(new Producto(10, "Silla de oficina", "Hogar", 650.00, 6));
        inventario.agregarProducto(new Producto(11, "Lampara de escritorio", "Hogar", 95.00, 1));
        inventario.agregarProducto(new Producto(12, "Escritorio", "Hogar", 980.00, 3));

        // 2. El handler es quien resuelve "pedidos" (preguntas de negocio)
        //    combinando lo que trae la dependencia con colecciones de Java.
        PedidoHandler handler = new PedidoHandler(inventario);

        System.out.println("=== 1. Productos por categoria ===");
        Map<String, Integer> conteo = handler.contarPorCategoria();
        System.out.println(conteo);

        System.out.println("\n=== 2. Productos con stock bajo (< 5) ===");
        List<Producto> stockBajo = handler.productosConStockBajo(5);
        for (Producto producto : stockBajo) {
            System.out.println(producto);
        }

        System.out.println("\n=== 3. Categorias disponibles ===");
        Set<String> categorias = handler.categoriasDisponibles();
        System.out.println(categorias);

        System.out.println("\n=== 4. Producto mas caro ===");
        System.out.println(handler.productoMasCaro());

        System.out.println("\n=== 5. Indice por id (buscar el id 7) ===");
        Map<Integer, Producto> indice = handler.indexarPorId();
        System.out.println(indice.get(7));

        System.out.println("\n=== 6. Valor total del inventario ===");
        System.out.println("Q " + handler.valorTotalInventario());
    }
}
