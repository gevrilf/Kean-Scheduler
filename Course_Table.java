package schedule;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Course_Table {

	JFrame frame;
	JPanel ctrl_panel;
	private JButton btnDel; // Delete button variable
	
	
	private void createGUI() {
		
		frame = new JFrame("Scheduler");
		frame.setSize(700,550);
		//frame.setLayout(new BorderLayout());
		
		/*frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});*/
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ctrl_panel = new JPanel();
		//ctrl_panel.setLayout(new BorderLayout());
		
		frame.add(ctrl_panel);
		frame.setVisible(true);
	}
	
	public Course_Table() {
		createGUI();
	}
	
	private void ShowLayout() {
		JPanel panel = new JPanel();
		panel.setSize(700,400);
		
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		
		panel.setLayout(layout);
		panel.add(new JButton("add"), BorderLayout.LINE_START);
		panel.add(new JButton("save"), BorderLayout.PAGE_END);
		
		panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Kean Course Scheduler", TitledBorder.CENTER, TitledBorder.TOP));
        String[] columns = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
		
		String[][] data = {{"CPS4200: 10AM-11:15AM","MATH3351: 10AM-11:15AM","CPS4200: 10AM-11:15AM","MATH3351: 10AM-11:15AM",""},
				{"PSYCH4200: 2PM-3:15PM","HIST3351: 2PM-3:15PM","PSYCH4200: 2PM-3:15PM","HIST3351: 2PM-3:15PM",""},
				{"RELI4200: 5PM-6:15PM","ASL3351: 5PM-6:15PM","RELI4200: 5PM-6:15PM","ASL3351: 5PM-6:15PM",""},
				{"CPS2200: 5PM-6:15PM","MATH3251: 5PM-6:15PM","CPS2200: 5PM-6:15PM","MATH3251: 5PM-6:15PM",""}};
		
		JTable planner = new JTable(data,columns) {
			
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
			
			btnDel = new JButton("DELETE");  //Basic delete functionality based on clicking a spot on the jtable
			btnDel.addActionListener(new ActionListener() {
			  @Override
			    public void actionPerformed(ActionEvent e) {
			    int i=planner.getSelectedRow();  // get clicked row
			    int j=planner.getSelectedColumn();  // get click column
			    if (i>=0&&j>=0) {
			      planner.setValueAt("", i, j); // deleted value at selected row x column
			      JOptionPane.showMessageDialog(null, "Course Deleted");
			    } else {
			      JOptionPane.showMessageDialog(null, "Please Select A Class First"); // joption pane to catch errors if nothing was clicked
			    }
			  }
			}
			);
			panel.add(btnDel, BorderLayout.LINE_END); // add delete button to the panel    	
		
		planner.setRowHeight(planner.getRowHeight() + 90);
		
		panel.add(new JScrollPane(planner), BorderLayout.CENTER);
		
		
		ctrl_panel.add(panel);
		frame.setVisible(true);
	}
	
	/*private void create_table() {
		JPanel table_panel = new JPanel();
		table_panel.setSize(700,400);
		
		
		String[] columns = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
		
		Object[][] data = {{"CPS4200","10AM-11:15AM","3 credits"},
				{"MATH3351","12PM-1:15PM","4 credits"},
				{"CPS4521","7PM-8:15PM","2 credits"},
				{"CPS4521","8PM-9:15PM","3 credits"},
				{"CPS4521","1PM-2:15PM","4 credits"},
				{"CPS4521","4PM-5:15PM","3 credits"}};
		
		JTable planner = new JTable(data,columns);
		
		table_panel.add(new JScrollPane(planner), BorderLayout.CENTER);
		ctrl_panel.add(table_panel);
		frame.setVisible(true);
		
		}*/
	
	public static void main(String[] args) {
		Course_Table schedule = new Course_Table();
		//schedule.create_table();
		schedule.ShowLayout();
	}
	
}
