package views.customs;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

public class PasswordField extends JPasswordField {
    
    private JToggleButton toggleButton;

    public PasswordField() {
        this.setPreferredSize(new Dimension(300, 35));

        // Criar o botão de alternância
        toggleButton = new JToggleButton("Show");
        toggleButton.setPreferredSize(new Dimension(80, 35));
        // Adicionar um ouvinte de ação para o botão
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggleButton.isSelected()) {
                    setEchoChar((char) 0);
                    toggleButton.setText("Hide");
                } else {
                    setEchoChar('*');
                    toggleButton.setText("Show");
                }
            }
        });
        
        this.add(toggleButton);
    }

    public JToggleButton getToggleButton() {
        return toggleButton;
    }
}
