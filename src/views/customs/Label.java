package views.customs;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel{
	public Label(String text, int style, int size) {
		this.setText(text);
		this.setFont(new Font("Roboto", style, size));
	}
	
	public Label(String text) {
		this.setText(text);
		this.setFont(new Font("Roboto", Font.PLAIN, 18));
	}

	public Label(String labelText, ImageIcon icon, int left) {
		super(labelText, icon, left);
		this.setFont(new Font("Roboto", Font.PLAIN, 16));
	}
}
