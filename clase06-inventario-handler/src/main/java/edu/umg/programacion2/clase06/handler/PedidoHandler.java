package edu.umg.programacion2.clase06.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.umg.programacion2.clase06.inventario.InventarioService;
import edu.umg.programacion2.clase06.inventario.modelo.Producto;

/**
 * Ejercicio de la clase: completar los metodos marcados con TODO.
 * Cada uno explica QUE tiene que hacer, un ejemplo de entrada/salida y una
 * pista de que coleccion conviene usar. 
 */
public class PedidoHandler {

    private final InventarioService inventario;

    public PedidoHandler(InventarioService inventario) {
        this.inventario = inventario;
    }

    /**
     * TODO 1: contar cuantos productos hay por categoria.
     *
     * Entrada: el inventario de ejemplo de Main (4 "Electronica", 3 "Alimentos", ...)
     * Salida esperada: {Electronica=4, Alimentos=3, Ropa=2, Hogar=3}
     *
     * Pista: usa un HashMap<String, Integer> como "contador". Por cada
     * producto, revisa si su categoria ya esta en el mapa:
     *   - si SI esta, suma 1 al valor que ya tenia.
     *   - si NO esta, agregala con valor 1.
     *
     * Cuidado: mapa.get("categoriaQueNoExiste") devuelve null, no 0. Si
     * intentas hacer null + 1 te explota con NullPointerException. Por eso
     * hay que preguntar primero con containsKey (o comparar contra null).
     */
    public Map<String, Integer> contarPorCategoria() {
        Map<String, Integer> conteo = new HashMap<>();
        // TODO: recorrer inventario.obtenerTodos() y llenar "conteo".
        for (Producto p : inventario.obtenerTodos()) {
            String cat = p.getCategoria();
            conteo.put(cat, conteo.getOrDefault(cat, 0) + 1);
        }
        return conteo;
    }

    /**
     * TODO 2: filtrar los productos cuyo stock sea MENOR al umbral dado.
     *
     * Entrada: productosConStockBajo(5)
     * Salida esperada: los productos con id 3 (stock 3), 7 (stock 2) y
     * 11 (stock 1).
     *
     * Pista: crea un ArrayList<Producto> vacio, recorre
     * inventario.obtenerTodos() y agrega al resultado solo los que
     * cumplan producto.getStock() < umbral.
     */
    public List<Producto> productosConStockBajo(int umbral) {
        List<Producto> resultado = new ArrayList<>();
        // TODO: llenar "resultado" filtrando por stock.
        for (Producto p : inventario.obtenerTodos()) {
            if (p.getStock() < umbral) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    /**
     * TODO 3: devolver las categorias que existen en el inventario, SIN
     * repetidas.
     *
     * Entrada: el inventario de ejemplo de Main.
     * Salida esperada (sin importar el orden): [Electronica, Alimentos, Ropa, Hogar]
     *
     * Pista: un HashSet<String> nunca permite duplicados, asi que solo hay
     * que agregar la categoria de cada producto — no hace falta revisar
     * "si ya existe" a mano, el Set se encarga.
     */
    public Set<String> categoriasDisponibles() {
        Set<String> categorias = new HashSet<>();
        // TODO: agregar la categoria de cada producto a "categorias".
        for (Producto p : inventario.obtenerTodos()) {
            categorias.add(p.getCategoria());
        }
        return categorias;
    }

    /**
     * TODO 4: encontrar el producto mas caro del inventario.
     *
     * Entrada: el inventario de ejemplo de Main.
     * Salida esperada: Laptop (precio 4500.00).
     *
     * Pista: recorre la lista guardando en una variable el "mas caro
     * visto hasta ahora" (empieza en null) y compara cada precio contra
     * el de esa variable.
     *
     * Cuidado: si el inventario estuviera vacio, el resultado debe ser
     * null — no debe lanzar una excepcion.
     */
    public Producto productoMasCaro() {
        Producto masCaro = null;
        // TODO: recorrer inventario.obtenerTodos() y actualizar "masCaro".

        return masCaro;
    }

    /**
     * TODO 5: armar un indice id -> Producto para buscar sin recorrer toda
     * la lista cada vez.
     *
     * Entrada: el inventario de ejemplo de Main.
     * Salida esperada: indice.get(7) devuelve el producto "Cafe 500g".
     *
     * Pista: HashMap<Integer, Producto>. Es la misma idea que
     * InventarioService.buscarPorId(int), pero en vez de recorrer la
     * lista cada vez, aca se arma el mapa UNA vez y despues las busquedas
     * son O(1) en vez de O(n).
     */
    public Map<Integer, Producto> indexarPorId() {
        Map<Integer, Producto> indice = new HashMap<>();
        // TODO: llenar "indice" usando producto.getId() como llave.

        return indice;
    }

    /**
     * TODO 6: calcular el valor total del inventario (precio * stock de
     * cada producto, sumado).
     *
     * Entrada: el inventario de ejemplo de Main.
     * Salida esperada: 55279.5
     *
     * Pista: no necesitas ninguna coleccion nueva, solo recorrer la lista
     * y acumular en un double.
     */
    public double valorTotalInventario() {
        double total = 0.0;
        // TODO: sumar precio * stock de cada producto a "total".

        return total;
    }

    // ------------------------------------------------------------------
    // PASO 2 del taller — versionar la dependencia sin romper el handler
    // ------------------------------------------------------------------
    //
    // Cuando terminen los 6 TODOs de arriba:
    //
    // 1. Vayan a clase06-inventario-dependencia/InventarioService.java y
    //    agreguen UN metodo nuevo, por ejemplo:
    //
    //      public List<Producto> obtenerPorCategoria(String categoria) { ... }
    //
    //    IMPORTANTE: no toquen ni borren agregarProducto, obtenerTodos ni
    //    buscarPorId — esos ya los usa este handler y CUALQUIER cambio en
    //    su firma lo rompe.
    //
    // 2. En el pom.xml de la dependencia, cambien <version>1.0.0</version>
    //    por <version>1.1.0</version>. Corran "mvn install" ahi adentro.
    //
    // 3. En el pom.xml de ESTE proyecto (el handler), cambien la propiedad
    //    <inventario.version>1.0.0</inventario.version> a 1.1.0. Es la
    //    UNICA linea que deberian tocar en este pom.
    //
    // 4. Corran "mvn clean compile exec:java" del handler: debe seguir
    //    compilando y funcionando igual que antes, SIN cambiar nada del
    //    codigo de los TODOs 1-6. Eso es lo que significa "una nueva
    //    version que no rompe al que ya la usa".
    //
    // 5. Descomenten el metodo de abajo y usen el nuevo metodo de la
    //    dependencia en vez de repetir el filtro a mano:
    //
    // public List<Producto> productosPorCategoria(String categoria) {
    //     return inventario.obtenerPorCategoria(categoria);
    // }
    //
    // 6. Completen la seccion [1.1.0] de CHANGELOG.md en la dependencia.
}
