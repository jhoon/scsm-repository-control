package philips.scsm.view;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import philips.scsm.control.RepositoryControl;
import philips.scsm.data.Solution;

/**
 *
 * @author pablo.sierralta
 */
public class SolutionRepositoryFrame extends javax.swing.JFrame implements TreeExpansionListener {

    private RepositoryControl repositoryControl;
    private DefaultMutableTreeNode top;
    private String path;

    /** Creates new form SolutionRepositoryFrame */
    public SolutionRepositoryFrame() {
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension tamano = toolkit.getScreenSize();
        this.setPreferredSize(new java.awt.Dimension(tamano.width, tamano.height - 30));
        repositoryControl = new RepositoryControl(this);
        path = "G:\\Development Support\\Projects\\System Maintenance\\Products\\XIRIS\\Maintenance";
        File f = new File(path);
        //File f = new File("/");

        top = new DefaultMutableTreeNode(f);
        //populateNode(top, f);

        initComponents();
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
                if (nombre.indexOf("RQ") != -1) {
                    nombre = nombre.substring(nombre.indexOf("RQ"), nombre.length());
                }
                DefaultMutableTreeNode curr =
                        //new DefaultMutableTreeNode(files[i]);
                        new DefaultMutableTreeNode(nombre);

                //System.out.println("files[i] " + files[i]);
                populateNode(curr, files[i], depth - 1);
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
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbFilter = new javax.swing.JTable();

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

        treeDir.addTreeExpansionListener(this);
        jScrollPane2.setViewportView(treeDir);

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbFilter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbFilter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLoadPatchRepository, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadPatchData, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
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
                    .addComponent(btnLoadPatchRepository)
                    .addComponent(jButton1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
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
        FileChooserDialog file = new FileChooserDialog(this, true);
        file.setFileFilter(new FileNameExtensionFilter("Path", "."));
        file.setVisible(true);
        String filePath = file.getSelectedFilePath();
        System.out.println("Action Command -" + filePath + "- ");
        repositoryControl.getPatchList(new File(filePath));

}//GEN-LAST:event_btnLoadPatchRepositoryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        List patchList = repositoryControl.checkRepository(path);

        DefaultTableModel model = (DefaultTableModel) tbFilter.getModel();
        model.setColumnIdentifiers(
                new Object[]{
                    "Bug ID",
                    "Description",
                    "Have Ticket",
                    "Have Patch Solution",
                    "Have Patch Release",
                    "Have Patch Email",
                    "Have CVS code",
                    "Have Solution code"
                }
        );

        for (int i = 0; i < patchList.size(); i++) {
            Solution sol = (Solution) patchList.get(i);
            Object[] rowData = new Object[]{
                sol.getId(),
                sol.getDescription(),
                sol.isHaveTicket(),
                sol.isHaveJarPatch(),
                sol.isHaveTxtPatch(),
                sol.isHaveEmailPatch(),
                sol.isHaveCodeCVS(),
                sol.isHaveCodePatch()
            };
            model.addRow(rowData);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadPatchData;
    private javax.swing.JButton btnLoadPatchRepository;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbFilter;
    private javax.swing.JTable tbRepository;
    private javax.swing.JTree treeDir;
    // End of variables declaration//GEN-END:variables

    public void treeExpanded(TreeExpansionEvent event) {
    }

    public void treeCollapsed(TreeExpansionEvent event) {
    }
}
