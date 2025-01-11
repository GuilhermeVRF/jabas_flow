package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import views.components.Header;

public abstract class BasePanel extends JPanel{
	public BasePanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(100,100));
		
		this.add(new Header(), BorderLayout.NORTH);
	}
	
	protected abstract void createBody();
}
