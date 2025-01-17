package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Router.Router;
import Router.ViewManager;
import models.Category;
import views.customs.Button;
import views.customs.CategoryTableModel;
import views.customs.Label;
import views.customs.Table;
import views.customs.TableModelHandler;
import views.forms.CreateCategoryForm;

public class CategoriesPanel extends MainContent{
	public CategoriesPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setOpaque(false);
		
		topPanel.add(new Label("Categorias", Font.BOLD, 24), BorderLayout.WEST);
		
		JButton createCategoryBtn = new Button("Criar categoria", new Color(0x1F509A));
		topPanel.add(createCategoryBtn, BorderLayout.EAST);
		
		createCategoryBtn.addActionListener(e -> {
			ViewManager.displayMainContent("Criar Categoria");
		});
		
		this.add(topPanel, BorderLayout.NORTH);
		
		this.setBorder(new EmptyBorder(50, 50, 50, 50));
		
		List<Category> categories = Router.getCategories().getDATA();
		JTable table = new Table(new CategoryTableModel(categories));
        JScrollPane scrollPane = new JScrollPane(table);
        TableModelHandler actionsColumn = new TableModelHandler(e -> {System.out.println("Editando");}, e -> {System.out.println("Apagando");});
        
        table.getColumnModel().getColumn(2).setCellRenderer(actionsColumn);
        table.getColumnModel().getColumn(2).setCellEditor(actionsColumn);
        
        this.add(scrollPane, BorderLayout.SOUTH);
	}
}
