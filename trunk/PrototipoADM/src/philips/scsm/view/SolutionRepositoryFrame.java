package philips.scsm.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import philips.scsm.control.RepositoryControl;

/**
 *
 * @author pablo.sierralta
 */
public class SolutionRepositoryFrame extends javax.swing.JFrame {

    private RepositoryControl repositoryControl;

    /** Creates new form SolutionRepositoryFrame */
    public SolutionRepositoryFrame() {
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        java.awt.Dimension tamano = toolkit.getScreenSize();
        this.setPreferredSize(new java.awt.Dimension(tamano.width, tamano.height - 30));
        initComponents();
        repositoryControl = new RepositoryControl(this);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solutions Repository");

        tbRepository.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bug ID", "Title", "Author", "Status", "Resolution", "Link"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbRepository);
        tbRepository.getColumnModel().getColumn(0).setResizable(false);
        tbRepository.getColumnModel().getColumn(1).setResizable(false);

        btnLoadPatchData.setText("Load Patch Data");
        btnLoadPatchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPatchDataActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);

        jTextField2.setEnabled(false);

        btnLoadPatchRepository.setText("Load Patch Repository");
        btnLoadPatchRepository.setEnabled(false);
        btnLoadPatchRepository.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPatchRepositoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadPatchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPatchDataActionPerformed
        FileChooserDialog file = new FileChooserDialog(this, true);
        file.getFileChooser().setFileFilter(new FileNameExtensionFilter("CSV file", "csv", "xls", "xml"));
        file.setVisible(true);
        File data = file.getFileChooser().getSelectedFile();
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
        file.getFileChooser().setFileFilter(new FileNameExtensionFilter("CSV file", "csv", "xls", "xml"));
        file.setVisible(true);
        File data = file.getFileChooser().getSelectedFile();
        System.out.println("Action Command -" + fileChooser.getCurrentDirectory().getPath() + "- ");
        repositoryControl.getPatchList(new File("G:\\Development Support\\Projects\\System Maintenance\\Products\\XIRIS\\Maintenance"));

}//GEN-LAST:event_btnLoadPatchRepositoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadPatchData;
    private javax.swing.JButton btnLoadPatchRepository;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbRepository;
    // End of variables declaration//GEN-END:variables
}
