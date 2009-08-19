package philips.scsm.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import philips.scsm.view.SolutionRepositoryFrame;

/**
 *
 * @author pablo.sierralta
 */
public class RepositoryControl {

    private SolutionRepositoryFrame parent;
    private String[] columnId;
    private int countHasTicket;
    private int countNeedTicket;
    private int countHasJarPatch;
    private int countHasTxtPatch;
    private int countHasEmailPatch;
    private int countHasCodeCVS;
    private int countHasCodePatch;
    private int countHasFinished;
    private int totalCount;

    public RepositoryControl(SolutionRepositoryFrame parent) {
        this.parent = parent;
    }

    public List checkRepository2(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        List patchList = new LinkedList();

        for (int i = 0; i < list.length; i++) {
            String patchPath = list[i].getName();
            if (patchPath.indexOf("RQ") != -1) {
                totalCount++;
                String name = patchPath.substring(patchPath.indexOf("RQ"), patchPath.length());
                String id = name.substring(name.indexOf(" ") + 1, name.indexOf("_"));
                boolean hasTicket = false;
                boolean needTicket = true;
                boolean hasJarPatch;
                boolean hasTxtPatch;
                boolean hasEmailPatch;
                boolean hasCodeCVS;
                boolean hasCodePatch;
                boolean hasFinished = false;

                File requirements = new File(path + "\\" + patchPath + "\\" + "1. Requirements\\");
                File[] valRequirements = requirements.listFiles();
                if (valRequirements == null || valRequirements.length == 0) {
                    hasTicket = false;
                } else {
                    for (int j = 0; j < valRequirements.length; j++){
                        String file = valRequirements[j].getName();
                        if (file.indexOf(".xls") != -1 || file.indexOf(".doc") != -1) {
                            hasTicket = true;
                            countHasTicket++;
                        }
                        if (file.indexOf("NO TICKET") != -1 ) {
                            needTicket = false;
                            countNeedTicket++;
                        }
                    }
                }

                File results = new File(path + "\\" + patchPath + "\\" + "4. Test\\");
                File[] valResults = results.listFiles();
                if (valResults == null || valResults.length == 0) {
                    hasFinished = false;
                } else {
                    hasFinished = true;
                    countHasFinished++;
                } 

                Vector vec = new Vector();
                vec.add(Integer.valueOf(id));
                vec.add(name);
                vec.add(hasTicket);
                vec.add(needTicket);
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(hasFinished);
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

    public Vector checkRepository3(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        Vector patchList = new Vector();

        for (int i = 0; i < list.length; i++) {
            String patchPath = list[i].getName();
            if (patchPath.indexOf("RQ") != -1) {
                totalCount++;
                String name = patchPath.substring(patchPath.indexOf("RQ"), patchPath.length());
                String id = name.substring(name.indexOf(" ") + 1, name.indexOf("_"));
                boolean hasTicket = false;
                boolean needTicket = true;
                boolean hasJarPatch;
                boolean hasTxtPatch;
                boolean hasEmailPatch;
                boolean hasCodeCVS;
                boolean hasCodePatch;
                boolean hasFinished = false;

                File requirements = new File(path + "\\" + patchPath + "\\" + "1. Requirements\\");
                File[] valRequirements = requirements.listFiles();
                if (valRequirements == null || valRequirements.length == 0) {
                    hasTicket = false;
                } else {
                    for (int j = 0; j < valRequirements.length; j++){
                        String file = valRequirements[j].getName();
                        if (file.indexOf(".xls") != -1 || file.indexOf(".doc") != -1) {
                            hasTicket = true;
                            countHasTicket++;
                        }
                        if (file.indexOf("NO TICKET") != -1 ) {
                            needTicket = false;
                            countNeedTicket++;
                        }
                    }
                }

                File results = new File(path + "\\" + patchPath + "\\" + "4. Test\\");
                File[] valResults = results.listFiles();
                if (valResults == null || valResults.length == 0) {
                    hasFinished = false;
                } else {
                    hasFinished = true;
                    countHasFinished++;
                }

                Vector vec = new Vector();
                vec.add(Integer.valueOf(id));
                vec.add(name);
                vec.add(hasTicket);
                vec.add(needTicket);
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(new Boolean(true));
                vec.add(hasFinished);
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
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
                vec.add(new Boolean(false));
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

    /**
     * @return the countHasTicket
     */
    public int getCountHasTicket() {
        return countHasTicket;
    }

    /**
     * @return the countNeedTicket
     */
    public int getCountNeedTicket() {
        return countNeedTicket;
    }

    /**
     * @return the countHasJarPatch
     */
    public int getCountHasJarPatch() {
        return countHasJarPatch;
    }

    /**
     * @return the countHasTxtPatch
     */
    public int getCountHasTxtPatch() {
        return countHasTxtPatch;
    }

    /**
     * @return the countHasEmailPatch
     */
    public int getCountHasEmailPatch() {
        return countHasEmailPatch;
    }

    /**
     * @return the countHasCodeCVS
     */
    public int getCountHasCodeCVS() {
        return countHasCodeCVS;
    }

    /**
     * @return the countHasCodePatch
     */
    public int getCountHasCodePatch() {
        return countHasCodePatch;
    }

    /**
     * @return the countHasFinished
     */
    public int getCountHasFinished() {
        return countHasFinished;
    }

    /**
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }
}
