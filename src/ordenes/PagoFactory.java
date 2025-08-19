/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenes;

/**
 *
 * @author Tatiana y Jocelyn
 */
public class PagoFactory {
    public static Pago crearPago(String tipo) throws Exception {
        switch (tipo.toLowerCase()) {
            case "efectivo": return new PagoEfectivo();
            case "tarjeta":  return new PagoTarjeta();
            case "transferencia": return new PagoTransferencia();
            default: throw new Exception("Tipo de pago no soportado: " + tipo);
        } //
    }
}