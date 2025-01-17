package views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import views.components.DashboardPanel;
import views.components.Header;
import views.components.Sidebar;

public class Page extends JPanel{
	public static JSplitPane splitPane;
	private Sidebar sidebar;
	private Header header;
	protected JPanel mainContent;
	
	public Page() {
		this.header = new Header();
		
		this.setLayout(new BorderLayout());
		this.sidebar = new Sidebar(this);
		
		this.mainContent = new DashboardPanel();
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.sidebar, this.mainContent);
		splitPane.setDividerLocation(250);
		splitPane.setEnabled(false);
		
		this.add(this.header, BorderLayout.NORTH);
		this.add(splitPane, BorderLayout.CENTER);
	}
}
