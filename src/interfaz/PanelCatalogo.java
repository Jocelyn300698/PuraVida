package interfaz;

import conexion.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanelCatalogo extends JPanel {

    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    public PanelCatalogo() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Tabla de productos
        String[] columnas = {"Código", "Nombre", "Categoría", "Precio", "Stock Actual"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setFillsViewportHeight(true);
        tablaProductos.setRowHeight(25);
        tablaProductos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tablaProductos.setSelectionBackground(new Color(173, 216, 230));
        tablaProductos.setGridColor(new Color(200, 200, 200));

        add(new JScrollPane(tablaProductos), BorderLayout.CENTER);

        cargarDatosDesdeDB();
    }

    private void cargarDatosDesdeDB() {
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT p.codigo, p.nombre, c.nombre AS categoria, p.precio, p.stock_actual " +
                     "FROM puravida.producto p " +
                     "JOIN puravida.categoria c ON p.categoria_id = c.id " +
                     "ORDER BY p.codigo")) {

            modeloTabla.setRowCount(0); // limpiar tabla
            while (rs.next()) {
                Object[] fila = {
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock_actual")
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
