package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import views.components.Header;

public abstract class AuthenticationView extends JPanel{
	protected final GridBagConstraints FLEX_COLUMN = new GridBagConstraints();
	
	public AuthenticationView() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(100,100));
		this.makeResponsive();
		this.add(new Header(), BorderLayout.NORTH);
	}
	
	protected abstract void createBody();
	
	protected void justifyContent(JPanel component, String position) {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		component.setMinimumSize(new Dimension(700, 500));
		
		switch(position) {
			case "middle": 
				Dimension middleScreen = new Dimension(screenSize.width / 2, screenSize.height / 2);
				component.setPreferredSize(middleScreen);
				component.setMaximumSize(middleScreen);
				FLEX_COLUMN.anchor = GridBagConstraints.CENTER;
			break;
		}
	}
	
	private void makeResponsive() {
		FLEX_COLUMN.gridx = 0;
		FLEX_COLUMN.gridy = 0;
		FLEX_COLUMN.weightx = 1.0;
		FLEX_COLUMN.weighty = 1.0; 
		FLEX_COLUMN.fill = GridBagConstraints.NONE; 
	}
}
