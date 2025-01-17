package Router;

import javax.swing.JPanel;

import factories.MainContentFactory;
import views.Main;
import views.Page;

public class ViewManager {
	/* Displaying view */
	public static JPanel displayingView = null;
	
	public static void displayView(JPanel view) {
		if(displayingView != null) Main.FRAME.remove(displayingView);
		
		displayingView = view;
		Main.FRAME.add(view);
		Main.FRAME.revalidate();
		Main.FRAME.repaint();
	}
	
	public static void displayMainContent(String page) {
		JPanel newContent = MainContentFactory.show(page);
		Page.splitPane.setRightComponent(newContent);
		
		Page.splitPane.setDividerLocation(250);
		Page.splitPane.revalidate();
		Page.splitPane.repaint();
	}
}
