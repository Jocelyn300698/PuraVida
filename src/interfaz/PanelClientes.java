package interfaz;

import conexion.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanelClientes extends JPanel {

    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;

    public PanelClientes() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Tabla de clientes
        String[] columnas = {"ID", "Nombre", "Correo", "Teléfono"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setFillsViewportHeight(true);
        tablaClientes.setRowHeight(25);
        tablaClientes.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tablaClientes.setSelectionBackground(new Color(173, 216, 230));
        tablaClientes.setGridColor(new Color(200, 200, 200));

        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);

        cargarDatosDesdeDB();
    }

    private void cargarDatosDesdeDB() {
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id_interno, nombre, correo, telefono FROM puravida.cliente ORDER BY id_interno")) {

            modeloTabla.setRowCount(0);
            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id_interno"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
