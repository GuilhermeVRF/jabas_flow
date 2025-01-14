package views;

import java.awt.BorderLayout;
import java.awt.Color;     
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import factories.MainContentFactory;
import views.components.DashboardPanel;
import views.components.Header;
import views.components.Sidebar;

public class Page extends JPanel{
	private JSplitPane splitPane;
	private Sidebar sidebar;
	private Header header;
	protected JPanel mainContent;
	
	public Page() {
		this.header = new Header();
		
		this.setLayout(new BorderLayout());
		this.sidebar = new Sidebar(this);
		
		this.mainContent = new DashboardPanel();
		
		this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.sidebar, this.mainContent);
		this.splitPane.setDividerLocation(250);
		this.splitPane.setEnabled(false);
		
		this.add(this.header, BorderLayout.NORTH);
		this.add(this.splitPane, BorderLayout.CENTER);
	}
	
	public void showPage(String page) {
		JPanel newContent = MainContentFactory.show(page);
		this.splitPane.setRightComponent(newContent);
		
		this.splitPane.setDividerLocation(250);
		this.splitPane.revalidate();
		this.splitPane.repaint();
	}
}
