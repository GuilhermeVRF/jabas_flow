package views.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Router.Router;
import models.User;
import utils.Response;
import views.customs.Button;
import views.customs.Label;
import views.customs.PasswordField;
import views.customs.RoundedBorder;
import views.customs.TextField;

public class RegisterForm extends Form {
    public RegisterForm() {
        this.setOpaque(false);
        this.setBackground(new Color(0,0,0));
        this.setBorder(new RoundedBorder(30));
        createFormFields();  
    }

    protected void createFormFields() {
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel registerTitle = new JLabel("Registrar");
        registerTitle.setFont(new Font("Roboto", Font.BOLD, 30));
        gbc.gridx = 0; gbc.gridy = 0; 
        gbc.gridwidth = 2;           
        gbc.anchor = GridBagConstraints.CENTER;   
        this.add(registerTitle, gbc);
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridwidth = 1; 
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Painel de Nome
        JLabel nameLabel = new Label("Nome");
        JTextField nameField = new TextField();
        gbc.gridx = 0; gbc.gridy = 1; 
        this.add(nameLabel, gbc);
        gbc.gridx = 1; 
        this.add(nameField, gbc);

        // Painel de E-mail
        JLabel emailLabel = new Label("E-mail");
        JTextField emailField = new TextField();
        gbc.gridx = 0; gbc.gridy = 2;
        this.add(emailLabel, gbc);
        gbc.gridx = 1;
        this.add(emailField, gbc);

        // Painel de Senha
        JLabel passwordLabel = new Label("Senha");
        PasswordField passwordField = new PasswordField();
        JToggleButton togglePassword = passwordField.getToggleButton();
        gbc.gridx = 0; gbc.gridy = 3;
        this.add(passwordLabel, gbc);
        gbc.gridx = 1;
        this.add(passwordField, gbc);
        gbc.gridx = 2;
        this.add(togglePassword, gbc);

        // Painel de Repita a Senha
        JLabel repeatPasswordLabel = new Label("Repita a Senha");
        PasswordField repeatPasswordField = new PasswordField();
        JToggleButton toggleRepeatPassword = repeatPasswordField.getToggleButton();
        gbc.gridx = 0; gbc.gridy = 4;
        this.add(repeatPasswordLabel, gbc);
        gbc.gridx = 1;
        this.add(repeatPasswordField, gbc);
        gbc.gridx = 2;
        this.add(toggleRepeatPassword, gbc);
        
        // Botão de Enviar
        JButton submitBtn = new Button("Enviar");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER;         // Centraliza o botão
        this.add(submitBtn, gbc);
        
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	            String username = nameField.getText();
	            String email = emailField.getText();
	            String password = passwordField.getText();
	            String repeatPassword = repeatPasswordField.getText();
	            
	            User user = new User(username, email, password, repeatPassword);
	            Response response = Router.storeUser(user);
	            
	            if(response.getSTATUS() == "success") {
	            	
	            }else {
	            	JOptionPane.showMessageDialog(null, user);
	            }
            }
        });
    }
}
