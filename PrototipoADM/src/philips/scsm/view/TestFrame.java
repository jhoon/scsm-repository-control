/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 13/08/2009, 03:54:59 PM
 */
package philips.scsm.view;

import philips.scsm.view.TableModel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo.sierralta
 */
public class TestFrame extends javax.swing.JFrame {

    DefaultTableModel model;
    TableModel model2;

    /** Creates new form NewJFrame */
    public TestFrame() {

        final String[] columnNames = {"Nombre",
            "Apellido",
            "webeo",
            "Años de Practica",
            "Soltero(a)"};
        final Object[][] data = {

            {"Lhucas", "Huml",
                "Patinar", new Integer(3), new Boolean(true)},
            {"Kathya", "Walrath",
                "Escalar", new Integer(2), new Boolean(false)},
            {"Marcus", "Andrews",
                "Correr", new Integer(7), new Boolean(true)},
            {"Angela", "Lalth",
                "Nadar", new Integer(4), new Boolean(false)}
        };
        //model = new ModeloDatosTabla(data, true);
        model = new DefaultTableModel();
        model2 = new TableModel(columnNames, data);

        initComponents();


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(model2);
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new JTable(model2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    class MyTableModel extends AbstractTableModel {

        String[] columnNames = {"Nombre",
            "Apellido",
            "Pasatiempo",
            "Años de Practica",
            "Soltero(a)"};
        Object[][] data = {
            {"Mary", "Campione",
                "Esquiar", new Integer(5), new Boolean(false)},
            {"Lhucas", "Huml",
                "Patinar", new Integer(3), new Boolean(true)},
            {"Kathya", "Walrath",
                "Escalar", new Integer(2), new Boolean(false)},
            {"Marcus", "Andrews",
                "Correr", new Integer(7), new Boolean(true)},
            {"Angela", "Lalth",
                "Nadar", new Integer(4), new Boolean(false)}
        };

        public MyTableModel(String[] columnNames, Object[][] data) {
            this.columnNames = columnNames;
            this.data = data;
        }


        //únicamente retornamos el numero de elementos del
        //array de los nombres de las columnas
        public int getColumnCount() {
            return columnNames.length;
        }

        //retormanos el numero de elementos
        //del array de datos
        public int getRowCount() {
            return data.length;
        }

        //retornamos el elemento indicado
        public String getColumnName(int col) {
            return columnNames[col];
        }

        //y lo mismo para las celdas
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * Este metodo sirve para determinar el editor predeterminado
         * para cada columna de celdas
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * No tienes que implementar este método a menos que
         * las celdas de tu tabla sean Editables
         */
        public boolean isCellEditable(int row, int col) {
            return true;
        }

        /*
         * No tienes que implementar este método a menos que
         * los datos de tu tabla cambien
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}
