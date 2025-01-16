package views.customs;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JTextField;

public class TextField extends JTextField{
	public TextField() {
		this.setPreferredSize(new Dimension(300, 35));
		this.setMinimumSize(new Dimension(100, 35));
	}
	
	public TextField(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(100, 35));
	}
}
