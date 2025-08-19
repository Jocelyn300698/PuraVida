package modelo;

/**
 * Producto
 * --------
 * Entidad que representa un producto en el inventario.
 * Incluye validaciones básicas y soporte para detección de duplicados.
 */
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters simples (podemos evitar setters en exceso para mantener control)
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void reducirStock(int cantidad) throws Exception {
        if (cantidad > stock) {
            throw new Exception("Stock insuficiente para el producto: " + nombre);
        }
        stock -= cantidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - ₡" + precio + " | Stock: " + stock;
    }
}
