package views.customs;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import models.Category;

public class CategoryTableModel extends AbstractTableModel{
	private final String[] columnNames = {"ID", "Nome", "Ações"};
	private List<Category> categories;
	
	public CategoryTableModel(List<Category> categories) {
		this.categories = categories;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return categories.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Category category = categories.get(rowIndex);
		
		return switch(columnIndex) {
		case 0 -> category.getId();
		case 1 -> category.getName();
		case 2 -> "Ações";
		default -> null;
		};
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	public void addAll(List<Category> categories) {
		categories.clear();
		categories.addAll(categories);
		fireTableDataChanged();
	}
	
	public void addCategory(Category category) {
		categories.add(category);
		fireTableRowsInserted(categories.size() - 1, categories.size() - 1);
	}
	
	public void removeCategory(int rowIndex) {
		categories.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
