package views.customs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

public class PasswordField extends JPasswordField {
    
    private JToggleButton toggleButton;

    public PasswordField() {
        this.setPreferredSize(new Dimension(300, 35));
        this.setMinimumSize(new Dimension(100, 35));
        
        // Criar o botão de alternância
        toggleButton = new JToggleButton(new ImageIcon("src/assets/form/mostrarSenha.png"));
        toggleButton.setBackground(Color.WHITE);
        toggleButton.setPreferredSize(new Dimension(40, 35));
        // Adicionar um ouvinte de ação para o botão
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggleButton.isSelected()) {
                    setEchoChar((char) 0);
                    toggleButton.setIcon(new ImageIcon("src/assets/form/ocultarSenha.png"));
                } else {
                    setEchoChar('*');
                    toggleButton.setIcon(new ImageIcon("src/assets/form/mostrarSenha.png"));
                }
            }
        });
        
        this.add(toggleButton);
    }

    public JToggleButton getToggleButton() {
        return toggleButton;
    }
}
