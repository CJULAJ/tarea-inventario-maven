package edu.umg.programacion2.clase06.inventario.modelo;

public class Producto {

    private final int id;
    private final String nombre;
    private final String categoria;
    private final double precio;
    private final int stock;

    public Producto(int id, String nombre, String categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', categoria='" + categoria
                + "', precio=" + precio + ", stock=" + stock + "}";
    }
}
