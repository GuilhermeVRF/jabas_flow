package factories;

import javax.swing.JPanel;

import views.components.DashboardPanel;

public class MainContentFactory {
	public static JPanel show(String page) {
		return switch (page) {  
        case "Dashboard" -> new DashboardPanel();        
        default -> null;                           
    };
	}
}
