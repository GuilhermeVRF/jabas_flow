package views.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import views.customs.Button;
import views.customs.Label;
import views.customs.PasswordField;
import views.customs.RoundedBorder;

public abstract class Form extends JPanel{
	protected final Font TITLE_FONT = new Font("Roboto", Font.BOLD, 30);
	protected final GridBagConstraints FLEX_COLUMN = new GridBagConstraints();
	
	public Form() {
		this.setOpaque(false);
        this.setBackground(new Color(0,0,0));
        this.setBorder(new RoundedBorder(30));
        this.setLayout(new GridBagLayout());
        
        this.FLEX_COLUMN.insets = new Insets(10, 10, 10, 10);
	}
	
	protected abstract void createFormFields();
	
	protected void createTitle(String titleText) {
	    JLabel titleLabel = new JLabel(titleText);
	    titleLabel.setFont(this.TITLE_FONT);  
	    FLEX_COLUMN.gridx = 0;
	    FLEX_COLUMN.gridy = 0;
	    FLEX_COLUMN.gridwidth = 2;
	    FLEX_COLUMN.anchor = GridBagConstraints.CENTER;  
	    
	    this.add(titleLabel, FLEX_COLUMN);
	    
	    FLEX_COLUMN.gridwidth = 1;
	    FLEX_COLUMN.anchor = GridBagConstraints.WEST;
	}
	
	protected void createField(String labelText, JTextField field, int gridy) {
        Label label = new Label(labelText); 
        FLEX_COLUMN.gridx = 0; 
        FLEX_COLUMN.gridy = gridy; 
        this.add(label, FLEX_COLUMN); 
        
        FLEX_COLUMN.gridx = 1; 
        this.add(field, FLEX_COLUMN); 
    }
	
	protected void createPasswordField(String labelText, PasswordField passwordField, int gridy) {
	    this.createField(labelText, passwordField, gridy);

	    JToggleButton togglePassword = passwordField.getToggleButton();
	    FLEX_COLUMN.gridx = 2;
	    this.add(togglePassword, FLEX_COLUMN);
	}
	
	protected void createSubmitButton(String buttonText, int gridy, ActionListener actionListener) {
	    JButton submitBtn = new Button(buttonText);
	    
	    FLEX_COLUMN.gridx = 0;
	    FLEX_COLUMN.gridy = gridy;
	    FLEX_COLUMN.gridwidth = 2;
	    FLEX_COLUMN.anchor = GridBagConstraints.CENTER;
	    this.add(submitBtn, FLEX_COLUMN);
	    
	    submitBtn.addActionListener(actionListener);
	}

}
