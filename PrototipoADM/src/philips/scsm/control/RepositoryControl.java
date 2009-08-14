package philips.scsm.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import philips.scsm.data.Solution;
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

    public List checkRepository2(String path) {
        File root = new File(path);
        File[] list = root.listFiles();
        List patchList = new LinkedList();

        for (int i = 0; i < list.length; i++) {
            String name = list[i].getName();
            if (name.indexOf("RQ") != -1) {
                name = name.substring(name.indexOf("RQ"), name.length());
                String id = name.substring(name.indexOf(" ") + 1, name.indexOf("_"));

                Vector vec = new Vector();
                vec.add(Integer.valueOf(id));
                vec.add(name);
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                patchList.add(vec);
            } else {
                continue;
            }
        }
        Collections.sort(patchList, new Comparator<Vector>() {

            public int compare(Vector o1, Vector o2) {
                return Integer.parseInt((o1.get(0)).toString()) - Integer.parseInt((o2.get(0)).toString());
            }
        });

        return patchList;
    }

    public Vector checkRepository(String path) {
        File root = new File(path);
        File[] list = root.listFiles();
        Vector patchList = new Vector();

        for (int i = 0; i < list.length; i++) {
            String name = list[i].getName();
            if (name.indexOf("RQ") != -1) {
                name = name.substring(name.indexOf("RQ"), name.length());
                String id = name.substring(name.indexOf(" ") + 1, name.indexOf("_"));
                Vector vec = new Vector();
                vec.add(Integer.valueOf(id));
                vec.add(name);
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                patchList.add(vec);
            } else {
                continue;
            }
        }
        Collections.sort(patchList, new Comparator<Vector>() {
            public int compare(Vector o1, Vector o2) {
                return Integer.parseInt((o1.get(0)).toString()) - Integer.parseInt((o2.get(0)).toString());
            }
        });
        return patchList;
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
                String[] tok = reader.readLine().split(",");
                LinkedHashMap item = new LinkedHashMap();

                int head = 0;
                for (int i = 0; i < tok.length; i++) {
                    String value = tok[i].replaceAll("\"", "");
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
        //System.out.println(data);
        return data;
    }

    public String[] getColumnId() {
        return columnId;
    }
}
