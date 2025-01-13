package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Sidebar extends JPanel{
	
	public Sidebar() {
		this.setPreferredSize(new Dimension(250, 600));
		this.setBackground(new Color(0x557C56));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
}
