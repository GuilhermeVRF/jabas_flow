package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import views.forms.LoginForm;

public class Login extends AuthenticationView{
	public Login() {
		super();
		this.setVisible(true);
		
		this.createBody();
	}
	
	@Override
	protected void createBody() {	
		JPanel body = new JPanel();
		body.setLayout(new GridBagLayout());
		body.setPreferredSize(new Dimension(100, 100));
		
		LoginForm loginForm = new LoginForm();
		this.justifyContent(loginForm, "middle");
		body.add(loginForm);
		
		body.setBackground(new Color(0xF4F6FF));
		this.add(body);
		body.setVisible(true);
	}

}
