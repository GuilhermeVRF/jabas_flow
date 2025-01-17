package views.customs;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableModelHandler extends AbstractCellEditor implements TableCellRenderer, TableCellEditor{
	private final JPanel panel;
	private final JButton editBtn;
	private final JButton deleteBtn;
	
	public TableModelHandler(ActionListener editAction, ActionListener deleteAction) {
		this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		this.editBtn = new JButton(new ImageIcon("src/assets/form/edit.png"));
		this.deleteBtn = new JButton(new ImageIcon("src/assets/form/delete.png"));
		this.editBtn.setBackground(Color.WHITE);
		this.deleteBtn.setBackground(Color.WHITE);
		
		this.editBtn.addActionListener(editAction);
		this.deleteBtn.addActionListener(deleteAction);
		
		this.panel.add(editBtn);
		this.panel.add(deleteBtn);
		this.panel.setBackground(new Color(245, 245, 245)); 
		//this.panel.setOpaque(false);
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object arg1, boolean isSelected, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
		return panel;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object arg1, boolean isSelected, boolean hasFocus, int arg4, int arg5) {		
		if(isSelected) {
			this.panel.setBackground(table.getSelectionBackground());
			this.panel.setForeground(table.getSelectionForeground());
		}else {
			this.panel.setBackground(table.getBackground());
			this.panel.setForeground(table.getForeground());
		}
		
		return panel;
	}

}
