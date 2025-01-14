package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import views.forms.RegisterForm;

public class Register extends AuthenticationView{
	public Register() {
		super();
		// Corpo
		this.createBody();
		this.setVisible(true);
	}

	@Override
	protected void createBody() {
		JPanel body = new JPanel();
		body.setLayout(new GridBagLayout());
		body.setPreferredSize(new Dimension(100, 100));
		
		RegisterForm registerForm = new RegisterForm();

        this.justifyContent(registerForm, "middle");

        // Adiciona o formulário ao painel
        body.add(registerForm, FLEX_COLUMN);

        
		body.setBackground(new Color(0xF4F6FF));
		this.add(body);
		body.setVisible(true);
	}
}
