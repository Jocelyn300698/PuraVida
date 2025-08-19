package puravida;

import javax.swing.SwingUtilities;
import vista.VentanaPrincipal;

/**
 * PuraVida MiPyME Suite
 * ----------------------
 * Punto de entrada de la aplicación. 
 * Lanzamos la interfaz Swing de manera segura con SwingUtilities.
 */
public class PuraVida {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
