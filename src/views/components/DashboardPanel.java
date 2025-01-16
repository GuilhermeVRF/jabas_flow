package views.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import views.customs.FilterComboBox;
import views.customs.Label;
import views.customs.TextField;

public class DashboardPanel extends MainContent{
	public DashboardPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setOpaque(false);
		
		JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		filterPanel.setOpaque(false);
		
		filterPanel.add(new Label("Filtrar por: ", Font.PLAIN, 14));
		JComboBox<String> filterField = new FilterComboBox();
		filterField.setSelectedIndex(0);
		
		filterPanel.add(filterField);
		
		topPanel.add(new Label("Estatísticas Gerais", Font.BOLD, 24), BorderLayout.WEST);
		topPanel.add(filterPanel, BorderLayout.EAST);
		
		JPanel financePanel = new JPanel();
		financePanel.setOpaque(false);
		
		financePanel.add(new Label("Receita: R$300,00"), BorderLayout.WEST);
		financePanel.add(new Label("Gastos: R$200,00"), BorderLayout.CENTER);
		financePanel.add(new Label("Total: R$100,00"), BorderLayout.EAST);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(financePanel, BorderLayout.CENTER);
		
		String[] columns = {"ID", "Nome", "Data Transação", "Preço", "Forma de Pagamento", "Categoria"};
        Object[][] data = {
            {"1", "Compra A", "2025-01-14", "R$ 100,00", "Cartão", "Alimentação"},
            {"2", "Compra B", "2025-01-14", "R$ 200,00", "Dinheiro", "Transporte"}
        };
        JTable table = new JTable(new DefaultTableModel(data, columns));
        JScrollPane scrollPane = new JScrollPane(table);
        
        this.add(scrollPane, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(50, 50, 50, 50));
	}
}
