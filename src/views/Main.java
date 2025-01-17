package views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Router.ViewManager;

public class Main {
	public static final JFrame FRAME = new JFrame("Login");
	public static void main(String[] args) {		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        // Configurar o tamanho do JFrame para ocupar toda a tela
        FRAME.setSize(screenSize.width, screenSize.height);
        FRAME.setMinimumSize(new Dimension(1000, 800));
        ViewManager.displayView(new Login());
        FRAME.setVisible(true);
	}
}
