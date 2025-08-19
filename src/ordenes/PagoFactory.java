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
            case "efectivo":
                return new PagoEfectivo();
            case "tarjeta":
                // Valores de prueba, en la UI real vendrían del usuario
                return new PagoTarjeta("123456789012", "Cliente Demo", "12/28", "123");
            case "transferencia":
                return new PagoTransferencia("REF-987654", "Banco Nacional");
            default:
                throw new Exception("Tipo de pago no soportado: " + tipo);
        }
    }
}