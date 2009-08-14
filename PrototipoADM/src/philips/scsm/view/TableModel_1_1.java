package philips.scsm.view;

import java.util.List;
import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo.sierralta
 */
public class TableModel_1_1 extends AbstractTableModel {

    private List dataVector;
    private String[] columnIdentifiers;
    private boolean editable = false;
    private boolean[] colEditables;

    TableModel_1_1() {
        super();
    }

    TableModel_1_1(String[] columnIdentifiers, List dataVector) {
        this.columnIdentifiers = columnIdentifiers;
        this.dataVector = dataVector;
    }

    public int getColumnCount() {
        return columnIdentifiers.length;
    }

    public int getRowCount() {
        return dataVector.size();
    }

    @Override
    public String getColumnName(int col) {
        return "" + columnIdentifiers[col];
    }

    public Object getValueAt(int row, int col) {
        return ((List) dataVector.get(row)).get(col);
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (colEditables != null) {
            return colEditables[columnIndex];
        } else {
            return editable;
        }
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void setColEditables(boolean[] colEditables) {
        this.colEditables = colEditables;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public List getDataVector() {
        return dataVector;
    }

    public String[] getColumnIdentifiers() {
        return columnIdentifiers;
    }

    @Override
    public TableModelListener[] getTableModelListeners() {
        return super.getTableModelListeners();
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setColumnIdentifiers(String[] columnIdentifiers) {
        this.columnIdentifiers = columnIdentifiers;
    }

    public void setDataVector(List dataVector) {

        this.dataVector = dataVector;
    }
}