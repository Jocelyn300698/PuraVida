/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenes;

/**
 *
 * @author tatia
 */
public class PagoTarjeta  implements Pago {
    private String numeroTarjeta;
    private String titular;
    private String vencimiento;
    private String cvv;

    public PagoTarjeta(String numeroTarjeta, String titular, String vencimiento, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.vencimiento = vencimiento;
        this.cvv = cvv;
    }

    @Override
    public boolean procesar(double monto) {
        // Simulación de validación
        if (numeroTarjeta == null || numeroTarjeta.length() < 12) {
            System.out.println("Error: número de tarjeta inválido.");
            return false;
        }
        System.out.println("Pago con tarjeta aprobado por ₡" + monto 
                + " para " + titular);
        return true;
    }
}