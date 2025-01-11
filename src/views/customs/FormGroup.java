package views.customs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class FormGroup extends JPanel{
	public FormGroup() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setOpaque(false);
	}
	
	public FormGroup(LayoutManager layoutManager) {
		this.setLayout(layoutManager);
	}
}
