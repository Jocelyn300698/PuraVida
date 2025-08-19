package interfaz;

import conexion.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanelOrdenes extends JPanel {

    private JTable tablaOrdenes;
    private DefaultTableModel modeloTabla;

    public PanelOrdenes() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        String[] columnas = {"ID", "Cliente", "Fecha", "Total Neto", "Tipo de Pago"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tablaOrdenes = new JTable(modeloTabla);
        tablaOrdenes.setFillsViewportHeight(true);
        tablaOrdenes.setRowHeight(25);
        tablaOrdenes.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tablaOrdenes.setSelectionBackground(new Color(173, 216, 230));
        tablaOrdenes.setGridColor(new Color(200, 200, 200));

        add(new JScrollPane(tablaOrdenes), BorderLayout.CENTER);

        cargarDatosDesdeDB();
    }

    private void cargarDatosDesdeDB() {
        String sql = "SELECT o.id, c.nombre AS cliente, o.fecha, o.total_neto, tp.descripcion AS tipo_pago " +
                     "FROM puravida.orden o " +
                     "JOIN puravida.cliente c ON o.cliente_id = c.id_interno " +
                     "JOIN puravida.tipo_pago tp ON o.tipo_pago_id = tp.id " +
                     "ORDER BY o.fecha DESC";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            modeloTabla.setRowCount(0);
            while (rs.next()) {
                Object[] fila = {
                        rs.getLong("id"),
                        rs.getString("cliente"),
                        rs.getTimestamp("fecha"),
                        rs.getDouble("total_neto"),
                        rs.getString("tipo_pago")
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar órdenes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
