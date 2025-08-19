package vista;

import javax.swing.*;

/**
 * VentanaPrincipal
 * ----------------
 * Nuestro menú base estilo escritorio.
 * Aquí el usuario podrá navegar entre los módulos:
 * Inventario, Clientes, Órdenes y Dashboard.
 */
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("PuraVida MiPyME Suite");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCatalogo = new JMenu("Catálogo & Inventario");
        JMenu menuClientes = new JMenu("Clientes");
        JMenu menuOrdenes = new JMenu("Órdenes & Facturación");
        JMenu menuDashboard = new JMenu("Operaciones & Análisis");

        menuBar.add(menuCatalogo);
        menuBar.add(menuClientes);
        menuBar.add(menuOrdenes);
        menuBar.add(menuDashboard);

        setJMenuBar(menuBar);

        // Panel de bienvenida simple
        add(new JLabel("Bienvenido a PuraVida MiPyME Suite", SwingConstants.CENTER));
    }
}
