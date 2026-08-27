package edu.umg.programacion2.clase06.inventario;

import java.util.ArrayList;
import java.util.List;

import edu.umg.programacion2.clase06.inventario.modelo.Producto;

/**
 * Version 1.0.0 de la API del inventario.
 *
 * Esta es la clase que clase06-inventario-handler va a usar como
 * dependencia (grupo/artefacto: umg.edu.gt.progra2 / clase06.inventario.dependencia).
 *
 * IMPORTANTE - regla de oro al evolucionar una dependencia:
 *   - Agregar un metodo nuevo   -> cambio COMPATIBLE (version MINOR, ej. 1.1.0)
 *   - Cambiar la firma de uno que ya existe (nombre, parametros, tipo de
 *     retorno) o borrarlo       -> cambio INCOMPATIBLE / breaking change
 *                                  (version MAJOR, ej. 2.0.0)
 * Este archivo es el punto de partida (1.0.0). El "Paso 2" del taller
 * (ver README.md del handler) pide agregar UN metodo nuevo aqui sin tocar
 * los tres que ya existen, y publicar la libreria como 1.1.0.
 */
public class InventarioService {

    private final List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Devuelve una COPIA de la lista interna (no la lista original).
     *
     * Cuidado: si devolvieramos "productos" directamente, quien reciba el
     * resultado podria hacer .add()/.remove() sobre el inventario interno
     * sin pasar por agregarProducto(). Devolver una copia evita ese efecto
     * secundario inesperado.
     */
    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos);
    }

    /**
     * Busca un producto por id.
     *
     * Cuidado: devuelve null si no lo encuentra (todavia no vimos Optional,
     * eso es tema de Programacion 3). Quien llame a este metodo SIEMPRE
     * debe validar el resultado antes de usarlo, o va a terminar con un
     * NullPointerException.
     */
    public Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
    /**
     * Devuelve los productos pertenecientes a una categoria especifica.
     */
    public List<Producto> obtenerPorCategoria(String categoria) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(producto);
            }
        }
        return resultado;
    }
}
