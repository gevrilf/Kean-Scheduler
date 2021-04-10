package schedule;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;


public class Course_Table {

	JFrame frame;
	JPanel ctrl_panel;
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/course_info";
	static final String USER = "menen";
	static final String PSS = "2t@r";
	
	public void connectDB() {
		Connection conn = null;
		Statement stmt = null;
		
		JPanel btn_pnl = new JPanel();
		btn_pnl.setLayout(new BoxLayout(btn_pnl, BoxLayout.Y_AXIS));
		
		try {
			//Register JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PSS);
			
			//Query to pull all courses from database and display them
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM course_info";
			
			//creates a set of all fetched results from database
			ResultSet rs = stmt.executeQuery(sql);
			
			JPanel table_panel = new JPanel();
		      //creates border around the table with a customized heading
		      table_panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Kean Course Scheduler", TitledBorder.CENTER, TitledBorder.TOP));
		        
		        //defines column headers for table
		        String[] columns = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
				
		        //populates the table with data, soon to be replaced with DB and add function
				String[][] data = {{"","","","",""},
						{"","","","",""},
						{"","","","",""},
						{"","","","",""}};
				
				//statement to create the table with data above
				DefaultTableModel model = new DefaultTableModel(data, columns);
				JTable planner = new JTable(model) {
					//tooltip function which gets values at each cell and displays them as you hover over
					public String getToolTipText(MouseEvent e) {
						String  tip = null;
						java.awt.Point p = e.getPoint();
						int rowIndex = rowAtPoint(p);
						int colIndex = columnAtPoint(p);
						
						try{
							tip = getValueAt(rowIndex,colIndex).toString();
						} catch (RuntimeException e1) {
						}
						return tip;
						}
					};
						
				//sets height of cells in table to make it look more like a planner/calendar
				planner.setRowHeight(planner.getRowHeight() + 90);
				//creates a scroll bar when table exceeds dimensions
				table_panel.add(new JScrollPane(planner), BorderLayout.CENTER);
				//add all elements to the window
				ctrl_panel.add(table_panel);
			
			while(rs.next()) {
				//initialize variables with column values from database
				String name = rs.getString("C_name");
				String days = rs.getString("C_days");
				String time = rs.getString("C_time");
				String credits = rs.getString("Credits");
				String code = rs.getString("C_code");
				
				JButton btn = new JButton();
				btn.setText(name + code + " \n" + days + time + " \n" + credits);
				btn_pnl.add(btn);				
				
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(days.equals("M W F")) {
							if(time.equals("9:30AM - 10:45A")){
								 model.setValueAt(name+code+days+time+credits,0,0);
								 model.setValueAt(name+code+days+time+credits,0,2);
								 model.setValueAt(name+code+days+time+credits,0,4);
						    }
						    else if(time.equals("12:30PM-1:45PM")) {
						    	 model.setValueAt(name+code+days+time+credits,2,0);
								 model.setValueAt(name+code+days+time+credits,2,2);
								 model.setValueAt(name+code+days+time+credits,2,4);
						    }
						}
						if(days.equals("T TR")) {
							if(time.equals("9:30AM - 10:45A")) {
								model.setValueAt(name+code+days+time+credits, 0, 1);
								model.setValueAt(name+code+days+time+credits, 0, 3);
							}
							else if(time.equals("11:00AM -12:15P")) {
								model.setValueAt(name+code+days+time+credits, 1, 1);
								model.setValueAt(name+code+days+time+credits, 1, 3);
							}
							else if(time.equals("12:30PM-1:45PM")) {
								model.setValueAt(name+code+days+time+credits, 2, 1);
								model.setValueAt(name+code+days+time+credits, 2, 3);
							}
						}
					}  
				});
				//use predefined variables to print results to client
				/*System.out.println("Course Name: " + name);
				System.out.println("Meeting information: " + days + " " + time);
				System.out.println("Credits: " + credits);
				System.out.println("Course code: " + code);*/
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.err.println("Got an exception error!");
			System.err.println(e.getMessage());
		}
		ctrl_panel.add(btn_pnl, BorderLayout.WEST);
		frame.setVisible(true);
	}
	
	private void createGUI() {
		//defines overall frame/window of application
		frame = new JFrame("Scheduler");
		frame.setSize(700,550);
		//closes application when the user hits the X on the window
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//panel where elements can be added to frame
		ctrl_panel = new JPanel();
		//elements added to window and able to be displayed
		frame.add(ctrl_panel);
		frame.setVisible(true);
	}
	
	public Course_Table() {
		//constructor class when creating a Course_Table object
		createGUI();
	}
	
	private void ShowLayout() {
		//panel creation to add elements to window
		//JPanel panel = new JPanel();
		//panel.setSize(700,400);
		
		/*BorderLayout layout = new BorderLayout();
		ctrl_panel.setLayout(layout);*/
		
		//sets the layout and height of each cell appropriately
		//BorderLayout layout = new BorderLayout();
		//layout.setHgap(5);
		//layout.setVgap(5);
		
		//calls function defined earlier to connect to MySQL DB
		connectDB();
		
		//buttons for main functionality
		/*JButton save = new JButton("save");
		JButton delete = new JButton("delete");*/
		
		
		//positioning buttons on panel
		//panel.setLayout(layout);
		/*panel.add(add, BorderLayout.LINE_START);
		panel.add(save, BorderLayout.PAGE_END);
		panel.add(delete, BorderLayout.LINE_END);*/
		
		//save JTable onto device
		/*save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});*/
		
		//delete course in JTable
		/*delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to delete entry from JTable
			}
		});*/
		
		//calls function to create the JTable
		
		//create_table();
		
		//adds panel to the main frame/window of the application
		//ctrl_panel.add(panel);
		frame.setVisible(true);
	}
	
	public void create_table() {
	  //creates another panel to add elements onto main window
      JPanel table_panel = new JPanel();
      //creates border around the table with a customized heading
      table_panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Kean Course Scheduler", TitledBorder.CENTER, TitledBorder.TOP));
        
        //defines column headers for table
        String[] columns = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
		
        //populates the table with data, soon to be replaced with DB and add function
		String[][] data = {{"","","","",""},
				{"","","","",""},
				{"","","","",""},
				{"","","","",""}};
		
		//statement to create the table with data above
		DefaultTableModel model = new DefaultTableModel(data, columns);
		JTable planner = new JTable(model) {
			//tooltip function which gets values at each cell and displays them as you hover over
			public String getToolTipText(MouseEvent e) {
				String  tip = null;
				java.awt.Point p = e.getPoint();
				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);
				
				try{
					tip = getValueAt(rowIndex,colIndex).toString();
				} catch (RuntimeException e1) {
				}
				return tip;
				}
			};
			
		//sets height of cells in table to make it look more like a planner/calendar
		planner.setRowHeight(planner.getRowHeight() + 90);
		//creates a scroll bar when table exceeds dimensions
		table_panel.add(new JScrollPane(planner), BorderLayout.CENTER);
		//add all elements to the window
		ctrl_panel.add(table_panel);
		frame.setVisible(true);
		
		}
	
	public static void main(String[] args) {
		Course_Table schedule = new Course_Table();
		schedule.ShowLayout();
	}
	
}
