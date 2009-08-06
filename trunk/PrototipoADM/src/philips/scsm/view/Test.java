package philips.scsm.view;

import java.io.File;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pablo.sierralta
 */
public class Test extends javax.swing.JFrame {

    /** Creates new form Ocurrencia_Listar */
    public Test() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        boton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        editor = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        boton.setText("jButton1");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(arbol);

        jScrollPane3.setViewportView(editor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(boton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed

        processList("G:\\Development Support\\Projects\\System Maintenance\\Products\\XIRIS\\Maintenance");
        processBugList("G:\\Development Support\\Projects\\System Maintenance\\Products\\XIRIS\\Maintenance");
        processBugListTest("G:\\Development Support\\Projects\\System Maintenance\\Products\\XIRIS\\Maintenance");
}//GEN-LAST:event_botonActionPerformed

    private String processList(String path) {
        System.out.println("ProcessList Method");
        String data = "Report images by center number: \n";

        File base = new File(path);
        File[] listadoArchivos = base.listFiles();
        //System.out.println("\t " + listadoArchivos.length);
        if (listadoArchivos != null) {
            int num = listadoArchivos.length;
            if (num > 0) {
                data += "\t " + listadoArchivos.length + " images\n";
            } else {
                data += "\t 0 images\n";
            }
        } else {
            data += "\t 0 images\n";
        }
        System.out.println(data);
        return data;
    }

    private String processBugList(String path) {
        System.out.println("ProcessList Method");
        String data = "Report images by center number: \n";

        File base = new File(path);
        File[] listadoArchivos = base.listFiles();
        //System.out.println("\t " + listadoArchivos.length);
        if (listadoArchivos != null) {
            int num = listadoArchivos.length;
            if (num > 0) {
                data += "\t " + listadoArchivos.length + " images\n";

                for (int i = 0; i < listadoArchivos.length; i++) {
                    data += "\t " + listadoArchivos[i] + " \n";
                }

            } else {
                data += "\t 0 images\n";
            }
        } else {
            data += "\t 0 images\n";
        }
        System.out.println(data);
        return data;
    }

    private String processBugListTest(String path) {
        System.out.println("ProcessList Method");
        String data = "Report images by center number: \n";

        File base = new File(path);
        File[] listadoArchivos = base.listFiles();
        //System.out.println("\t " + listadoArchivos.length);
        if (listadoArchivos != null) {
            int num = listadoArchivos.length;
            data += "\t " + num + " images\n";

            for (int i = 0; i < num; i++) {
                data += "\t " + listadoArchivos[i] + " \n";
            }

        } else {
            data += "\t 0 images\n";
        }
        System.out.println(data);
        return data;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbol;
    private javax.swing.JButton boton;
    private javax.swing.JEditorPane editor;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
