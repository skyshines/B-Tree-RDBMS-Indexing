package oui;

import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
	JTabbedPane tabPane; // this is just a reference to a JTabbedPane
	HomePanel homePanel; // this is a user defined class
	DataPanel dataPanel; // this is a user defined class
	IndexPanel indexPanel; // this is a user defined class
	QueryPanel queryPanel; // this is a user defined class

	public App() {
		tabPane = new JTabbedPane(); // here the object is made
		tabPane.setFont(new Font("Comic Sans MS", 1, 30));
		tabPane.setBackground(Color.DARK_GRAY);
		tabPane.setForeground(Color.WHITE);

		homePanel = new HomePanel(tabPane);
		dataPanel = new DataPanel(tabPane);
		indexPanel = new IndexPanel(tabPane);
		queryPanel = new QueryPanel(tabPane);

		super.add(tabPane);

		pack();

		super.setTitle("RDBMS Index Implementation");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
}
