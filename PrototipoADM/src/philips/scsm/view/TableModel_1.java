package philips.scsm.view;

import java.util.Vector;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo.sierralta
 */
public class TableModel_1 extends AbstractTableModel {

    private Vector dataVector;
    private String[] columnIdentifiers;
    private boolean editable = false;
    private boolean[] colEditables;

    TableModel_1() {
        super();
    }

    TableModel_1(String[] columnIdentifiers, Vector dataVector) {
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
        return ((Vector) dataVector.get(row)).get(col);
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

    public void setDataVector(Vector dataVector) {
        this.dataVector = dataVector;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    public void setColumnIdentifiers(String[] columnIdentifiers) {
        this.columnIdentifiers = columnIdentifiers;
    }

    public Vector getDataVector() {
        return dataVector;
    }

    public String[] getColumnIdentifiers() {
        return columnIdentifiers;
    }
}