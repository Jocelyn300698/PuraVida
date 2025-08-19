package interfaz;

import conexion.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanelDashboard extends JPanel {

    private JTable tablaTopProductos;
    private JTable tablaTopClientes;
    private JTable tablaCriticos;

    public PanelDashboard() {
        setLayout(new GridLayout(3, 1, 10, 10));
        setBackground(Color.WHITE);

        tablaTopProductos = crearTabla("Top 5 Productos por Ingresos", 
                "SELECT codigo, nombre, ingresos FROM puravida.vw_top5_productos_ingresos");
        tablaTopClientes = crearTabla("Top 5 Clientes por Monto Total", 
                "SELECT id_interno, nombre, monto_total FROM puravida.vw_top5_clientes_monto");
        tablaCriticos = crearTabla("Existencias Críticas", 
                "SELECT codigo, nombre, stock_actual, stock_min FROM puravida.vw_existencias_criticas");

        add(new JScrollPane(tablaTopProductos));
        add(new JScrollPane(tablaTopClientes));
        add(new JScrollPane(tablaCriticos));
    }

    private JTable crearTabla(String titulo, String sql) {
        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);
        tabla.setFillsViewportHeight(true);
        tabla.setRowHeight(25);
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tabla.setSelectionBackground(new Color(173, 216, 230));
        tabla.setGridColor(new Color(200, 200, 200));

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int colCount = rs.getMetaData().getColumnCount();
            String[] columnas = new String[colCount];
            for (int i = 0; i < colCount; i++) {
                columnas[i] = rs.getMetaData().getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(columnas);

            while (rs.next()) {
                Object[] fila = new Object[colCount];
                for (int i = 0; i < colCount; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar " + titulo + ": " + e.getMessage());
            e.printStackTrace();
        }
        return tabla;
    }
}
