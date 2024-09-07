package Controller;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

public class JCheckBoxEditor extends DefaultCellEditor implements TableCellEditor {
	    public JCheckBoxEditor() {
	        super(new JCheckBoxRenderer());
	    }
	    public Object getCellEditorValue() {
	        return Boolean.valueOf(((JCheckBox) editorComponent).isSelected());
	    }
	    public boolean isCellEditable(EventObject anEvent) {
	        return true;
	    }
		@Override
		public boolean shouldSelectCell(EventObject anEvent) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean stopCellEditing() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void cancelCellEditing() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void addCellEditorListener(CellEditorListener l) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void removeCellEditorListener(CellEditorListener l) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return null;
		}
	}

