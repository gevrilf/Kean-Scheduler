package kean;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Scheduler {

	public JFrame frame;
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scheduler window = new Scheduler();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Scheduler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 718, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Window organizer
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 682, 470);
		//Add Jframe into Jpanel
		frame.getContentPane().add(panel);
		//Set title for the Scheduler
		panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Kean Course Scheduler", TitledBorder.CENTER, TitledBorder.TOP));
		panel.setLayout(null);
		
		// Add add button to the window panel
		JButton addButton = new JButton("Add");
		// Event listener for add button for when it is pressed
		addButton.addActionListener(new ActionListener() {
			// open new jframe to select classes when add button is pressed
			public void actionPerformed(ActionEvent e) {
				// initialize new jframe (select classes)
				Table x = new Table();
				//for loop to pass current jframe classes to the new jframe so that data is not lost
				for(int i=0; i<6;i++) {
					for(int j=0; j<6;j++) {
						//write to the r variable in the Table class
						x.r[i][j]=table.getValueAt(i,j);
					}
				}
				//open the new window(jframe)
				x.frame.show();
				//get rid of the current one
				frame.dispose();
			}
		});
		addButton.setBounds(10, 75, 89, 23);
		panel.add(addButton);
		
		//delete button
		JButton delButton = new JButton("Delete");
		delButton.addActionListener(new ActionListener() {
			
			//will delete any cell that is selected by setting the cell value to blank ("")
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				int j=table.getSelectedColumn();
				if(i>=0&&j>=0) {
					model.setValueAt("",i,j);
					JOptionPane.showMessageDialog(null, "Course Deleted");
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Class First");
				}
			}
		});
		delButton.setBounds(10, 124, 89, 23);
		panel.add(delButton);
		
		//save button
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(10, 169, 89, 23);
		panel.add(saveButton);
		
		
		//Add a scroll pane so that you can scroll on the jframe table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 22, 534, 420);
		//add the scroll pane to the panel
		panel.add(scrollPane);
		
		
		//initialize jtable with the data we have set
		table = new JTable();
		
		//model variable is used to modify jtable
		model = new DefaultTableModel();
		//object class to set column titles in jtable
		Object[] column = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		Object[] row = new Object[0];
		
		//set the column titles to what we entered in the column variable
		model.setColumnIdentifiers(column);
		//set the table cell height
		table.setRowHeight(65);
		//make a predetermined 6 rows (can add more if we want)
		model.addRow(row);
		model.addRow(row);
		model.addRow(row);
		model.addRow(row);
		model.addRow(row);
		model.addRow(row);
		//update the jtable to the modifications we did in model
		table.setModel(model);
		//the scroll area, initialize view to the jtable
		scrollPane.setViewportView(table);
		
		
	}
}
