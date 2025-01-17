package factories;

import javax.swing.JPanel;

import views.components.CategoriesPanel;
import views.components.DashboardPanel;
import views.forms.CreateCategoryForm;

public class MainContentFactory {
	public static JPanel show(String page) {
		return switch (page) {  
        case "Dashboard" -> new DashboardPanel(); 
        case "Categorias" -> new CategoriesPanel();
        case "Criar Categoria" -> new CreateCategoryForm();
        default -> null;                           
    };
	}
}
