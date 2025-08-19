package interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JPanel panelCentral;
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        setTitle("PuraVida MiPyME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Panel lateral
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setBackground(new Color(240, 240, 240));

        JButton btnCatalogo = new JButton("Catálogo");
        JButton btnClientes = new JButton("Clientes");
        JButton btnOrdenes = new JButton("Órdenes");
        JButton btnDashboard = new JButton("Dashboard");

        panelLateral.add(btnCatalogo);
        panelLateral.add(btnClientes);
        panelLateral.add(btnOrdenes);
        panelLateral.add(btnDashboard);

        // Panel central con CardLayout
        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);

        panelCentral.add(new PanelCatalogo(), "Catalogo");
        panelCentral.add(new PanelClientes(), "Clientes");
        panelCentral.add(new PanelOrdenes(), "Ordenes");
        panelCentral.add(new PanelDashboard(), "Dashboard");

        // Eventos de botones
        btnCatalogo.addActionListener(e -> cardLayout.show(panelCentral, "Catalogo"));
        btnClientes.addActionListener(e -> cardLayout.show(panelCentral, "Clientes"));
        btnOrdenes.addActionListener(e -> cardLayout.show(panelCentral, "Ordenes"));
        btnDashboard.addActionListener(e -> cardLayout.show(panelCentral, "Dashboard"));

        add(panelLateral, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
