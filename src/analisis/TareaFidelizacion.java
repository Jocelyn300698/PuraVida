/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisis;

import javax.swing.SwingWorker;

/**
 * TareaFidelizacion
 * -----------------
 * Representa una tarea pesada que recalcula la fidelización de clientes.
 * Usamos SwingWorker para no congelar la interfaz y poder mostrar progreso.
 */
public class TareaFidelizacion extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {
        // Simulación de trabajo pesado
        for (int i = 0; i <= 100; i++) {
            Thread.sleep(50); // Simulamos cálculo costoso
            setProgress(i);
        }
        return null;
    }

    @Override
    protected void done() {
        System.out.println("Recalculo de fidelización completado.");
    }
}
