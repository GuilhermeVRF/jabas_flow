package Router;

import javax.swing.JPanel;

import views.Main;

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
}
