package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel{
	public Header() {
		this.setBackground(new Color(0x118B50));
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, 80));
		
		// Área da logo
		JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		logoPanel.setOpaque(true);
		ImageIcon logoIcon = new ImageIcon("src/assets/logo.png");
		JLabel logoLabel = new JLabel( logoIcon, JLabel.LEFT);
		this.add(logoLabel, BorderLayout.WEST);
		
		this.setVisible(true);
	}
}
