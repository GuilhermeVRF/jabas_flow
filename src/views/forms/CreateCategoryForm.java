package views.forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Router.Router;
import Router.ViewManager;
import models.Category;
import requests.CategoryRequest;
import utils.Response;
import views.customs.RoundedBorder;
import views.customs.TextField;

public class CreateCategoryForm extends Form{
	public CreateCategoryForm() {
		this.setOpaque(false);
        this.setBackground(new Color(0,0,0));
        this.setBorder(new RoundedBorder(30));
        this.setVisible(true);
        
        this.createFormFields();
	}
		
	@Override
	protected void createFormFields() {
		this.createTitle("Criar Categoria");
		
		 JTextField nameField = new TextField();
		 this.createField("src/assets/form/name.png", "Nome", nameField, 1);
		
		 
		 this.createSubmitButton("Enviar", 2, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Response<Category> response = Router.storeCategory(new CategoryRequest(nameField.getText()));
				
				if(response.getSTATUS() == "success") {
					JOptionPane.showMessageDialog(null, response.getMESSAGE(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					ViewManager.displayMainContent("Categorias");
				}else {
					JOptionPane.showMessageDialog(null, response.getMESSAGE(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
