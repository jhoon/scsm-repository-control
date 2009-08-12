package philips.scsm.view;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import philips.scsm.control.RepositoryControl;

/**
 *
 * @author pablo.sierralta
 */
public class SolutionRepositoryFrame extends javax.swing.JFrame implements TreeSelectionListener, TreeExpansionListener {

    private RepositoryControl repositoryControl;
    private DefaultMutableTreeNode top;
    private DefaultListModel mdlFiles;

    /** Creates new form SolutionRepositoryFrame */
    public SolutionRepositoryFrame() {
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension tamano = toolkit.getScreenSize();
        this.setPreferredSize(new java.awt.Dimension(tamano.width, tamano.height - 30));
        
        File f = new File("G:\\Development Support\\Projects\\System Maintenance\\Products\\XIRIS\\Maintenance");
        //File f = new File("/");

        top = new DefaultMutableTreeNode(f);
        populateNode(top, f);

        initComponents();
        repositoryControl = new RepositoryControl(this);
    }

    private boolean populateNode(DefaultMutableTreeNode node, File f) {
        node.removeAllChildren();
        return populateNode(node, f, 5);
    }

    private boolean populateNode(DefaultMutableTreeNode node, File f, int depth) {
        File[] files = f.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                //return pathname.isDirectory();
                return true;
            }
        });

        if (files != null && depth > 0) {
            for (int i = 0; i < files.length; i++) {
                String nombre = files[i].getName();
                if(nombre.indexOf("RQ") != -1) {
                    nombre = nombre.substring(nombre.indexOf("RQ"), nombre.length());
                }
                DefaultMutableTreeNode curr =
                        //new DefaultMutableTreeNode(files[i]);
                        new DefaultMutableTreeNode(nombre);

                        //System.out.println("files[i] " + files[i]);
                populateNode(curr, files[i], depth -1);
                node.add(curr);
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRepository = new javax.swing.JTable();
        btnLoadPatchData = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btnLoadPatchRepository = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeDir = new javax.swing.JTree(top);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solutions Repository");

        tbRepository.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbRepository);

        btnLoadPatchData.setText("Load Patch Data");
        btnLoadPatchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPatchDataActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);

        jTextField2.setEnabled(false);

        btnLoadPatchRepository.setText("Load Patch Repository");
        btnLoadPatchRepository.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPatchRepositoryActionPerformed(evt);
            }
        });

        treeDir.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                treeDirTreeExpanded(evt);
            }
        });
        treeDir.addTreeExpansionListener(this);
        jScrollPane2.setViewportView(treeDir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLoadPatchRepository, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadPatchData, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadPatchData)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadPatchRepository))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadPatchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPatchDataActionPerformed
        FileChooserDialog file = new FileChooserDialog(this, true);
        file.setFileFilter(new FileNameExtensionFilter("CSV file", "csv", "xls", "xml"));
        file.setVisible(true);
        File data = file.getFile();
        if (data != null) {
            List list = repositoryControl.getBugList(data);
            DefaultTableModel tb = (DefaultTableModel) tbRepository.getModel();
            tb.setColumnIdentifiers(repositoryControl.getColumnId());
            for (int i = 0; i < list.size(); i++) {
                HashMap item = (HashMap) list.get(i);
                Collection a = item.values();
                tb.addRow(a.toArray());
            }
        }
}//GEN-LAST:event_btnLoadPatchDataActionPerformed

    private void btnLoadPatchRepositoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPatchRepositoryActionPerformed
        /*
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Path", "."));
        fileChooser.showDialog(this, "Load");
         */
        FileChooserDialog file = new FileChooserDialog(this, true);
        file.setFileFilter(new FileNameExtensionFilter("Path", "."));
        file.setVisible(true);
        String path = file.getSelectedFilePath();
        System.out.println("Action Command -" + path + "- ");
        repositoryControl.getPatchList(new File("G:\\Development Support\\Projects\\System Maintenance\\Products\\XIRIS\\Maintenance"));


        

}//GEN-LAST:event_btnLoadPatchRepositoryActionPerformed

    private void treeDirTreeExpanded(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_treeDirTreeExpanded
        // TODO add your handling code here:

        System.out.println("exp");

    }//GEN-LAST:event_treeDirTreeExpanded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadPatchData;
    private javax.swing.JButton btnLoadPatchRepository;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbRepository;
    private javax.swing.JTree treeDir;
    // End of variables declaration//GEN-END:variables

  /**
     * Se ejecuta cuando cambia el valor seleccionado en la lista.
     * @param e El evento que sucedio
     */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) treeDir.getLastSelectedPathComponent();

        if (node == null) return;

        File f = (File) node.getUserObject();
        File[] files = f.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        mdlFiles.removeAllElements();
        if (files != null)
            for (int i = 0; i < files.length; i++) {
                mdlFiles.addElement(files[i]);
            }
    }

    /**
     * Se ejecuta cuando se expande una carpeta
     * @param event El evento que sucedio
     */
    public void treeExpanded(TreeExpansionEvent event) {
        /*
        TreePath path = event.getPath();
        DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) path.getLastPathComponent();

        if (node == null) return;

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        File f = (File) node.getUserObject();
        populateNode(node, f);

        JTree tree = (JTree) event.getSource();
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        model.nodeStructureChanged(node);

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        */
    }

    /**
     * Se ejecuta cuando se cierra una carpeta
     * @param event El evento que sucedio
     */
    public void treeCollapsed(TreeExpansionEvent event) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
