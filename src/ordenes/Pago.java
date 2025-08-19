package ordenes;

/**
 * Pago
 * ----
 * Estrategia base para pagos.
 * Se implementarán subclases concretas: PagoEfectivo, PagoTarjeta, PagoTransferencia.
 */
public interface Pago {
    boolean procesar(double monto);
}
