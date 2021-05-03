package kean;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.*;
import java.util.ArrayList;

public class Table {
	Connection conn = null;
	Statement stmt = null;

	public JFrame frame;
	private JTable jT_disp;
	DefaultTableModel model;
	public Object[][] r = new Object[6][6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//connection to database
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://sql5.freemysqlhosting.net/sql5407518";
	static final String USER = "sql5407518";
	static final String PSS = "rmZ9NDyfU2";
	
	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
		showCourse();
	}
	
	//Method to make an arraylist of course from the database
	public ArrayList<course> courseList(){
		ArrayList<course> courseList = new ArrayList<>();
		try {
			//Register JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PSS);
			String query1 = "SELECT * FROM course_info";
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(query1);
			course course;
			//Get courses from database
			while(rs.next()) {
				course=new course(rs.getString("C_name"), rs.getString("C_days"), rs.getString("C_time"), rs.getString("Credits"), rs.getString("C_code"));
				courseList.add(course);
			}

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		//return arraylist of courses imported from database
		return courseList;
	}
	
	public void showCourse() {
		//initialize arraylist to the method courselist
		ArrayList<course> list = courseList();
		DefaultTableModel model = (DefaultTableModel)jT_disp.getModel();
		//make row object 
		Object[] row = new Object[5];
		//add each course in the array list to the jtable row by row
		for(int i=0;i<list.size(); i++) {
			row[0]=list.get(i).getName();
			row[1]=list.get(i).getDays();
			row[2]=list.get(i).getTime();
			row[3]=list.get(i).getCredits();
			row[4]=list.get(i).getCode();
			model.addRow(row);
		}
	}
	
	//Allows user to sort based on categories selected
	private void sort() {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		jT_disp.setRowSorter(sorter);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 704, 544);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Kean Course Scheduler", TitledBorder.CENTER, TitledBorder.TOP));
		panel.setLayout(null);
		
		
		//Add function
		JButton addBut = new JButton("Add");
		addBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize new scheduler to update the data
				Scheduler sch = new Scheduler();
				//Import old data from old scheduler instance
				for(int i=0; i<6;i++) {
					for(int j=0; j<6;j++) {
						sch.model.setValueAt(r[i][j], i, j);
					}
				}
				//Get course that user selected
				String name, days, time, credits, code;
				int i=jT_disp.getSelectedRow();
				int j=jT_disp.getSelectedColumn();
				name = (String) jT_disp.getValueAt(i,0);
				days = (String) jT_disp.getValueAt(i,1);
				time = (String) jT_disp.getValueAt(i,2);
				credits = (String) jT_disp.getValueAt(i,3);
				code = (String) jT_disp.getValueAt(i,4);
				//Yasmeen's add code
				if(days.equals("MWF")) {
					if(time.equals("9:30AM-10:45AM")){
						sch.model.setValueAt(name+code+days+time+credits,0,0);
						sch.model.setValueAt(name+code+days+time+credits,0,2);
						sch.model.setValueAt(name+code+days+time+credits,0,4);
				    }
					else if(time.equals("11:00AM-12:15PM")) {
						sch.model.setValueAt(name+code+days+time+credits,1,0);
						sch.model.setValueAt(name+code+days+time+credits,1,2);
						sch.model.setValueAt(name+code+days+time+credits,1,4);
					}
				    else if(time.equals("12:30PM-1:45PM")) {
				    	sch. model.setValueAt(name+code+days+time+credits,2,0);
				    	sch.model.setValueAt(name+code+days+time+credits,2,2);
				    	sch.model.setValueAt(name+code+days+time+credits,2,4);
				    }
				    else if(time.equals("2:30PM-3:15PM")) {
				    	sch.model.setValueAt(name+code+days+time+credits,3,0);
				    	sch.model.setValueAt(name+code+days+time+credits,3,2);
				    	sch.model.setValueAt(name+code+days+time+credits,3,4);
				    }
				    else if(time.equals("4:30PM-5:45PM")) {
				    	sch.model.setValueAt(name+code+days+time+credits,4,0);
				    	sch.model.setValueAt(name+code+days+time+credits,4,2);
				    	sch.model.setValueAt(name+code+days+time+credits,4,4);
				    }
				}
				if(days.equals("T")) {
					if(time.equals("12:00PM-3:15PM")) {
						sch.model.setValueAt(name+code+days+time+credits,2,1);
					}
					else if(time.equals("12:30PM-4:00PM")) {
						sch.model.setValueAt(name+code+days+time+credits,2,1);
					}
				}
				if(days.equals("TTR")) {
					if(time.equals("9:30AM-10:45AM")) {
						sch.model.setValueAt(name+code+days+time+credits, 0, 1);
						sch.model.setValueAt(name+code+days+time+credits, 0, 3);
					}
					else if(time.equals("11:00AM-12:15PM")) {
						sch.model.setValueAt(name+code+days+time+credits, 1, 1);
						sch.model.setValueAt(name+code+days+time+credits, 1, 3);
					}
					else if(time.equals("12:30PM-1:45PM")) {
						sch.model.setValueAt(name+code+days+time+credits, 2, 1);
						sch.model.setValueAt(name+code+days+time+credits, 2, 3);
					}
					else if(time.equals("2:30PM-3:15PM")) {
						sch.model.setValueAt(name+code+days+time+credits,3,1);
						sch.model.setValueAt(name+code+days+time+credits,3,3);
					}
					else if(time.equals("4:30PM-5:45PM")) {
						sch.model.setValueAt(name+code+days+time+credits,4,1);
						sch.model.setValueAt(name+code+days+time+credits,4,3);
					}
				}
				if(days.equals("TR")) {
					if(time.equals("12:00PM-3:15PM")) {
						sch.model.setValueAt(name+code+days+time+credits,2,3);
					}
				}
				
				//After course has been added go back to scheduler
				sch.frame.show();
				//close and delete current frame
				frame.dispose();
			}
		});
		addBut.setBounds(38, 230, 89, 23);
		panel.add(addBut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 50, 483, 462);
		panel.add(scrollPane);
		
		//Table viewer code
		jT_disp = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Course Name", "Course Days", "Course Time", "Credits", "Course Code"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		jT_disp.setRowHeight(30);
		jT_disp.setModel(model);
		scrollPane.setViewportView(jT_disp);
		
		JButton backBut = new JButton("Back");
		backBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Initialize new scheduler to update the data
				Scheduler sch = new Scheduler();
				//Import old data from old scheduler instance
				for(int i=0; i<6;i++) {
					for(int j=0; j<6;j++) {
						sch.model.setValueAt(r[i][j], i, j);
					}
				}
				// go back to scheduler
				sch.frame.show();
				//close current and delete frame
				frame.dispose();
			}
		});
		backBut.setBounds(38, 283, 89, 23);
		panel.add(backBut);
		sort();
		
	}
}
