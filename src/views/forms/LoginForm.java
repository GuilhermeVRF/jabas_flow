package views.forms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Router.Router;
import requests.LoginRequest;
import utils.Response;
import views.Register;
import views.customs.Label;
import views.customs.PasswordField;
import views.customs.RoundedBorder;
import views.customs.TextField;

public class LoginForm extends Form{
	public LoginForm() {
		this.setOpaque(false);
        this.setBackground(new Color(0,0,0));
        this.setBorder(new RoundedBorder(30));
        this.setVisible(true);
        
        this.createFormFields();
	}
	@Override
	protected void createFormFields() {
		this.createTitle("Login");
		
        JTextField emailField = new TextField();
        this.createField("src/assets/form/email.png", "E-mail", emailField, 1);
		
        PasswordField passwordField = new PasswordField();
        this.createPasswordField("src/assets/form/senha.png","Senha", passwordField, 2);
        
        this.createSubmitButton("Enviar", 3, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = emailField.getText();
				String password = new String(passwordField.getPassword());
				LoginRequest loginRequest = new LoginRequest(email, password);
				
				Response response = Router.login(loginRequest);
				
				if(response.getSTATUS().equals("success")) {
					JOptionPane.showMessageDialog(null, response.getMESSAGE(), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	            }else {
	            	JOptionPane.showMessageDialog(null, response.getMESSAGE(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
			}
		});
        
        JLabel dontHaveAccount = new Label("<html><u>Não possui cadastro? Crie sua conta!</u></html>");
        dontHaveAccount.setForeground(Color.BLUE);
        FLEX_COLUMN.gridx = 0;FLEX_COLUMN.gridy = 7;FLEX_COLUMN.gridwidth = 2; 
        FLEX_COLUMN.anchor = GridBagConstraints.LINE_START;
        this.add(dontHaveAccount, FLEX_COLUMN);
        
        dontHaveAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Router.displayView(new Register());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            	dontHaveAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	dontHaveAccount.setCursor(Cursor.getDefaultCursor());
            }
        });
	}

}
