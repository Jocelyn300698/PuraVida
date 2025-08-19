/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenes;

/**
 *
 * @author Tatiana y Jocelyn
 */
public class PagoTransferencia implements Pago {
    private String numeroReferencia;
    private String banco;

    public PagoTransferencia(String numeroReferencia, String banco) {
        this.numeroReferencia = numeroReferencia;
        this.banco = banco;
    }

    @Override
    public boolean procesar(double monto) {
        if (numeroReferencia == null || numeroReferencia.isEmpty()) {
            System.out.println("Error: número de referencia inválido.");
            return false;
        }
        System.out.println("Pago por transferencia desde " + banco 
                + " confirmado por ₡" + monto 
                + " (Ref: " + numeroReferencia + ")");
         return true; 
    }
}
