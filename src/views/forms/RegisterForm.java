package views.forms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import Router.Router;
import requests.UserRequest;
import utils.Response;
import views.Login;
import views.customs.Button;
import views.customs.FileInput;
import views.customs.Label;
import views.customs.PasswordField;
import views.customs.TextField;

public final class RegisterForm extends Form {
    public RegisterForm() {
        createFormFields();  
    }

    protected void createFormFields() {
    	this.createTitle("Registrar");
 
        // Painel de Nome
        JTextField nameField = new TextField();
        this.createField("Nome", nameField, 1);

        // Painel de E-mail
        JTextField emailField = new TextField();
        this.createField("E-mail", emailField, 2);

        // Painel de Senha
        PasswordField passwordField = new PasswordField();
        this.createPasswordField("Senha", passwordField, 3);

        // Painel de Repita a Senha
        PasswordField repeatPasswordField = new PasswordField();
        this.createPasswordField("Repita a Senha", repeatPasswordField, 4);
        
        JLabel profileFileLabel = new Label("Imagem de perfil");
        FileInput profileFileField = new FileInput("Selecionar imagem");
        FLEX_COLUMN.gridx = 0; FLEX_COLUMN.gridy = 5;
        this.add(profileFileLabel, FLEX_COLUMN);
        FLEX_COLUMN.gridx = 1;
        this.add(profileFileField, FLEX_COLUMN);
        
        // Botão de Enviar
        this.createSubmitButton("Enviar", 6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	            String username = nameField.getText();
	            String email = emailField.getText();
	            String password = new String(passwordField.getPassword());
	            String repeatPassword = new String(repeatPasswordField.getPassword());
	            
	            UserRequest userRequest = new UserRequest(username, email, password, repeatPassword, profileFileField.getSelectedFile());
	            Response response = Router.storeUser(userRequest);
	            
	            if(response.getSTATUS().equals("success")) {
	            	JOptionPane.showMessageDialog(null, response.getMESSAGE(), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	            }else {
	            	JOptionPane.showMessageDialog(null, response.getMESSAGE(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
            }
        });
        
        JLabel alreadyRegistred = new Label("<html><u>Já possui cadastro? Faça login!</u></html>");
        alreadyRegistred.setForeground(Color.BLUE);
        FLEX_COLUMN.gridx = 0;FLEX_COLUMN.gridy = 7;FLEX_COLUMN.gridwidth = 2; 
        FLEX_COLUMN.anchor = GridBagConstraints.LINE_START;
        this.add(alreadyRegistred, FLEX_COLUMN);
        
        alreadyRegistred.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Router.displayView(new Login());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                alreadyRegistred.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                alreadyRegistred.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}
