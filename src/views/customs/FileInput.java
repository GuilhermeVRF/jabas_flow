package views.customs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileInput extends JPanel{
	private JLabel filePathField;
	private JButton selectButton;
	private File selectedFile;
	
	public FileInput(String buttonText) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(300, 35));
		this.setBackground(Color.WHITE);
		
		this.filePathField = new JLabel();
		this.filePathField.setBackground(getBackground());
		this.add(filePathField, BorderLayout.CENTER);
		
		this.selectButton = new JButton(buttonText);
		this.add(selectButton, BorderLayout.EAST);
		
		this.selectButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                	System.out.print("Arquivo coletado!");
                    selectedFile = fileChooser.getSelectedFile();
                    filePathField.setText(selectedFile.getName());
                }
			}
		});
	}
	
	public File getSelectedFile() {
		return this.selectedFile;
	}
}
