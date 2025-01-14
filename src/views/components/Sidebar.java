package views.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.Page;

public class Sidebar extends JPanel{
	private Page page;
	
	public Sidebar(Page page) {
		this.page = page;
		this.setPreferredSize(new Dimension(250, 600));
		this.setBackground(new Color(0x557C56));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblDashboard = createNavLabel("Dashboard", page);
        JLabel lblSettings = createNavLabel("Gastos", page);
        JLabel lblReports = createNavLabel("Receitas", page);
        JLabel lblRecurrences = createNavLabel("Recorrências", page);

        // Adicionar labels à sidebar
        this.add(lblDashboard);
        this.add(lblSettings);
        this.add(lblReports);
        this.add(lblRecurrences);
	}
	
	private JLabel createNavLabel(String text, Page page) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Roboto", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(100, 40));
        label.setMaximumSize(new Dimension(150, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setAlignmentX(CENTER_ALIGNMENT);

        // Adicionar MouseListener para capturar cliques
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	page.showPage(text);
            	System.out.println(text);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            	label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        return label;
    }
}
