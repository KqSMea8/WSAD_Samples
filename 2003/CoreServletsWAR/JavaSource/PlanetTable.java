import java.awt.Color;

import javax.swing.JApplet;

/*
 * Created on 23.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PlanetTable extends JApplet {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JTable jTable = null;
	private javax.swing.JScrollPane jScrollPane = null;
	/**
	 * This is the default constructor
	 */
	public PlanetTable() {
		super();
		init();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void init() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private javax.swing.JTable getJTable() {
		if(jTable == null) {
			//jTable = new javax.swing.JTable(cells, columnNames);
			jTable = new javax.swing.JTable(new InvestmentTableModel(30,5,10));
		}
		return jTable;
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}
	private Object[][] cells =
	{  
	   { 
		  "Mercury", new Double(2440),  new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Venus", new Double(6052), new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Earth", new Double(6378), new Integer(1),
		  Boolean.FALSE, Color.blue
	   },
	   { 
		  "Mars", new Double(3397), new Integer(2),
		  Boolean.FALSE, Color.red
	   },
	   { 
		  "Jupiter", new Double(71492), new Integer(16),
		  Boolean.TRUE, Color.orange
	   },
	   { 
		  "Saturn", new Double(60268), new Integer(18),
		  Boolean.TRUE, Color.orange
	   },
	   { 
		  "Uranus", new Double(25559), new Integer(17),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Neptune", new Double(24766), new Integer(8),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Pluto", new Double(1137), new Integer(1),
		  Boolean.FALSE, Color.black
	   },
	   { 
		  "Mercury", new Double(2440),  new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Venus", new Double(6052), new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Earth", new Double(6378), new Integer(1),
		  Boolean.FALSE, Color.blue
	   },
	   { 
		  "Mars", new Double(3397), new Integer(2),
		  Boolean.FALSE, Color.red
	   },
	   { 
		  "Jupiter", new Double(71492), new Integer(16),
		  Boolean.TRUE, Color.orange
	   },
	   {  
		  "Saturn", new Double(60268), new Integer(18),
		  Boolean.TRUE, Color.orange
	   },
	   { 
		  "Uranus", new Double(25559), new Integer(17),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Neptune", new Double(24766), new Integer(8),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Pluto", new Double(1137), new Integer(1),
		  Boolean.FALSE, Color.black
	   },
	   { 
		  "Mercury", new Double(2440),  new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Venus", new Double(6052), new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Earth", new Double(6378), new Integer(1),
		  Boolean.FALSE, Color.blue
	   },
	   { 
		  "Mars", new Double(3397), new Integer(2),
		  Boolean.FALSE, Color.red
	   },
	   { 
		  "Jupiter", new Double(71492), new Integer(16),
		  Boolean.TRUE, Color.orange
	   },
	   { 
		  "Saturn", new Double(60268), new Integer(18),
		  Boolean.TRUE, Color.orange
	   },
	   { 
		  "Uranus", new Double(25559), new Integer(17),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Neptune", new Double(24766), new Integer(8),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Pluto", new Double(1137), new Integer(1),
		  Boolean.FALSE, Color.black
	   },
	   { 
		  "Mercury", new Double(2440),  new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Venus", new Double(6052), new Integer(0),
		  Boolean.FALSE, Color.yellow
	   },
	   { 
		  "Earth", new Double(6378), new Integer(1),
		  Boolean.FALSE, Color.blue
	   },
	   { 
		  "Mars", new Double(3397), new Integer(2),
		  Boolean.FALSE, Color.red
	   },
	   { 
		  "Jupiter", new Double(71492), new Integer(16),
		  Boolean.TRUE, Color.orange
	   },
	   { 
		  "Saturn", new Double(60268), new Integer(18),
		  Boolean.TRUE, Color.orange
	   },
	   { 
		  "Uranus", new Double(25559), new Integer(17),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Neptune", new Double(24766), new Integer(8),
		  Boolean.TRUE, Color.blue
	   },
	   { 
		  "Pluto", new Double(1137), new Integer(1),
		  Boolean.FALSE, Color.black
	   }
	   
	};


	private String[] columnNames =
	{  
	   "Planet", "Radius", "Moons", "Gaseous", "Color"
	};
	
}
