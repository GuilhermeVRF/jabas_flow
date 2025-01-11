package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import views.forms.RegisterForm;

public class Register extends BasePanel{
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

        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Dimension middleScreen = new Dimension(screenSize.width / 2, screenSize.height / 2);
        registerForm.setPreferredSize(middleScreen);
        
        // Configura o layout para centralizar e permitir redimensionamento
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; 
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE; 

        // Define tamanhos mínimos e máximos para o RegisterForm
        registerForm.setMinimumSize(new Dimension(500, 300));
        registerForm.setMaximumSize(middleScreen);

        // Adiciona o formulário ao painel
        body.add(registerForm, gbc);

        
		body.setBackground(new Color(0xF4F6FF));
		this.add(body);
		body.setVisible(true);
	}
}
