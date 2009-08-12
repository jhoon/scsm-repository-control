package philips.scsm.view;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pablo.sierralta
 */
public class FileChooserDialog extends javax.swing.JDialog {

    /** Creates new form FileChooserDialog */
    public FileChooserDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    void setFileFilter(FileNameExtensionFilter fileNameExtensionFilter) {
        fileChooser.setFileFilter(fileNameExtensionFilter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        // TODO add your handling code here:

        if (evt.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
            System.out.println(evt.getActionCommand()+ " APPROVE_SELECTION -");
            if (fileChooser.getSelectedFile() == null) {
                JOptionPane.showMessageDialog(this, "Select a file");
            }
            this.setVisible(false);

        }
        else if (evt.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
            System.out.println(evt.getActionCommand() + " CANCEL_SELECTION -");
            fileChooser.setSelectedFile(null);
            this.setVisible(false);
        } else {
            System.out.println(evt.getActionCommand() +" Other  -" + evt.getSource().toString() + "- ");

        }
}//GEN-LAST:event_fileChooserActionPerformed

    public java.io.File getFile() {
        return fileChooser.getSelectedFile();
    }

    public String getSelectedFilePath() {
        return fileChooser.getCurrentDirectory().getPath();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
}
