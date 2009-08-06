package philips.scsm.view;



import javax.swing.UIManager;

/**
 *
 * @author zAxA
 */
public class EjecutaAplicacionServidor {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new SolutionRepositoryFrame().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
