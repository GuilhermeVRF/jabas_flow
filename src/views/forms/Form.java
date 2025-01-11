package views.forms;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public abstract class Form extends JPanel{
	
	public Form() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}
	
	protected abstract void createFormFields();
}
