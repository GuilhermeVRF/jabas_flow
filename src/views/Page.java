package views;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import views.components.Header;

public class Page extends JPanel{
	private JSplitPane splitPane;
	private Sidebar sidebar;
	private Header header;
	protected JPanel mainContent;
	
	public Page() {
		this.header = new Header();
		
		this.setLayout(new BorderLayout());
		this.sidebar = new Sidebar();
		
		this.mainContent = new JPanel();
		this.mainContent.setBackground(new Color(0xF4F6FF));
		this.mainContent.setLayout(new BorderLayout());
		
		this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.sidebar, this.mainContent);
		this.splitPane.setDividerLocation(250);
		this.splitPane.setOneTouchExpandable(true);
		this.splitPane.setEnabled(false);
		
		this.add(this.header, BorderLayout.NORTH);
		this.add(this.splitPane, BorderLayout.CENTER);
	}
}
