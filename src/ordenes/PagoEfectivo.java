/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenes;

/**
 *
 * @author Jocelyn y Tatiana
 */
public class PagoEfectivo implements Pago {
    @Override
    public boolean procesar(double monto) {
        // Lógica trivial: el efectivo siempre se acepta
        System.out.println("Pago en efectivo realizado por ₡" + monto);
        return true;
    }
}