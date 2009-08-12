package philips.scsm.arbol;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileFilter;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * La clase principal. Muestra un JTree y un JList para permitir navegar en el 
 * sistema de archivos
 * @author Magus
 */
public class Main
extends JFrame
implements TreeSelectionListener, TreeExpansionListener {
    
    private JScrollPane scrlDir;
        private JTree treeDir;
    
    private JScrollPane scrlFiles;
        private DefaultListModel mdlFiles;
        private JList lstFiles;
    
    
    /**
     * Constructor de la clase 
     */
    public Main() {
        this.setLayout(new BorderLayout());
        
        /** Que tan grandes son los iconos que voy a mostrar en la lista */
        final int ICON_SIZE = 32;
        
        /** 
         * Creo un nuevo File, el constructor que estoy utilizando me permite 
         * pasarle un String como la ruta base en la que debe empezar, estoy 
         * pasandole "/" que significa el directorio raiz.
         */
        File f = new File("/");
        /**
         * DefaultMutableTreeNode es la clase que me permite agregar nodos a un 
         * JTree, el metodo mas importante de esta clase es add(), con el que 
         * podemos agregar nodos hijos
         */
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(f);
        populateNode(top, f);
        
        /** 
         * Creo el JTree utilizando el nodo superior en el constructor
         */
        treeDir = new JTree(top);
        /**
         * El CellRenderer me permite modificar la manera en que se despliega 
         * la informacion en mi JTree, es un poco complicado de implementar 
         * pero me da mucha libertad en cuanto a como se dibuja el control en 
         * la pantalla
         */
        //treeDir.setCellRenderer(new DirectoryRenderer(ICON_SIZE));
        /**
         * setPreferredSize me permite determinar un ancho y un alto 
         * preferentes, que cuando utilizamos el metodo pack se utilizan para 
         * generar la interfaz.
         */
        treeDir.setPreferredSize(new Dimension(250, 200));
        /** 
         * El JTree tiene dos eventos importantisimos, cuando seleccionan algo
         * utilizamos el TreeSelectionListener para manejar el evento
         */
        treeDir.getSelectionModel().addTreeSelectionListener(this);
        /**
         * El otro evento importante es el ExpansionListener, lo utilizamos 
         * para no cargar todo a memoria de un solo golpe y que la aplicacion 
         * corra lento.
         */
        treeDir.addTreeExpansionListener(this);
        /** 
         * Utilizo un JScrollPane para que aparezcan barras de desplazamiento 
         */
        scrlDir = new JScrollPane(treeDir);
        scrlDir.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrlDir, BorderLayout.WEST);
        
        mdlFiles = new DefaultListModel();
        lstFiles = new JList(mdlFiles);
        lstFiles.setCellRenderer(new FileRenderer(ICON_SIZE));
        lstFiles.setPreferredSize(new Dimension(400, 200));
        lstFiles.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lstFiles.setVisibleRowCount(-1);
        scrlFiles = new JScrollPane(lstFiles);
        scrlFiles.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrlFiles, BorderLayout.CENTER);
        
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Arbol");
        this.setVisible(true);
    }
    
    /**
     * Inicia la ejecucion
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
    private boolean populateNode(DefaultMutableTreeNode node, File f) {
        node.removeAllChildren();
        return populateNode(node, f, 2);
    }
    
    private boolean populateNode(DefaultMutableTreeNode node, File f, int depth) {
        File[] files = f.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        
        if (files != null && depth > 0) {
            for (int i = 0; i < files.length; i++) {
                DefaultMutableTreeNode curr = 
                        new DefaultMutableTreeNode(files[i]);
                
                populateNode(curr, files[i], depth -1);
                node.add(curr);
            }
        }
        return true;
    }

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
    }

    /**
     * Se ejecuta cuando se cierra una carpeta
     * @param event El evento que sucedio
     */
    public void treeCollapsed(TreeExpansionEvent event) {
    }

}
