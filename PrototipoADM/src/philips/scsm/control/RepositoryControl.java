package philips.scsm.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import philips.scsm.view.SolutionRepositoryFrame;

/**
 *
 * @author pablo.sierralta
 */
public class RepositoryControl {

    private SolutionRepositoryFrame parent;
    private String[] columnId;

    public RepositoryControl(SolutionRepositoryFrame parent) {
        this.parent = parent;
    }

    public List getBugList(File file) {
        List source = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String[] header = null;

            if (reader.ready()) {
                String linea = reader.readLine();
                header = linea.split(",");
                columnId = header;
            }

            while (reader.ready()) {
                /*String linea = reader.readLine();
                StringTokenizer tok = new StringTokenizer(linea, ",");
                LinkedHashMap item = new LinkedHashMap();
                int i = 0;
                while (tok.hasMoreElements()) {
                String value = String.valueOf(tok.nextElement()).replaceAll("\"", "");
                if (value.isEmpty()) {
                System.out.println("vacio " + i);
                } else {
                System.out.println("no vacio -" + value + "-");
                }
                item.put(header[i], value);
                i++;
                }
                source.add(item);*/

                String[] tok = reader.readLine().split(",");
                LinkedHashMap item = new LinkedHashMap();

                int head = 0;
                for (int i = 0; i < tok.length; i++) {
                    String value =tok[i].replaceAll("\"", "");
                    item.put(header[head], value);
                    head++;
                }
                source.add(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

    public String getPatchList(File base) {
        System.out.println("ProcessList Method");
        String data = "Report images by center number: \n";

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

    public String[] getColumnId() {
        return columnId;
    }
}
