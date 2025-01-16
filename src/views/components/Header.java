package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.UserSession;

public class Header extends JPanel{
	public Header() {
		/* Levar para a tela de login */
		UserSession userSession = UserSession.getInstance();
		
		this.setBorder(new EmptyBorder(0, 20, 0, 20));
		this.setBackground(new Color(0x118B50));
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, 80));
		
		// Área da logo
		JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		logoPanel.setOpaque(true);
		ImageIcon logoIcon = new ImageIcon("src/assets/logo.png");
		JLabel logoLabel = new JLabel( logoIcon, JLabel.LEFT);
		this.add(logoLabel, BorderLayout.WEST);
		
		if(userSession.getUser() != null) {
			String profileFilePath = userSession.getUser().getProfile().getAbsolutePath();
			File profileFile = new File(profileFilePath);
			
			if(profileFile.exists()){
				JPanel profilePanel =  new JPanel(new GridBagLayout());
				profilePanel.setOpaque(false);
				ImageIcon profileIcon = new ImageIcon(profileFilePath);
	
	            Image scaledImage = profileIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	            profileIcon = new ImageIcon(scaledImage);
	
	            JLabel profileLabel = new JLabel(profileIcon);
	            profilePanel.add(profileLabel);
	            
	            this.add(profilePanel, BorderLayout.EAST);
			}
		}
		this.setVisible(true);
	}
}
