/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package philips.scsm.view;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo.sierralta
 */

public class TableModel extends AbstractTableModel {

    String[] columnNames = null;
    Object[][] data = null;

    public TableModel() {
        super();
    }

    public TableModel(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}