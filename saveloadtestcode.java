package schedule;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
 
 
public class saveloadtestcode extends JFrame {
     
    private String[] columnNames = 
        {"Course", "Time"};
     
    private Object[][] data;
     
    private JButton jbtAddRow = new JButton("Add new row");
    private JButton jbtSave = new JButton("Save Table");
    private JButton jbtLoad = new JButton("Load Table");
         
    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    private JTable myJTable = new JTable(tableModel);
     
    private JFileChooser myJFileChooser = new JFileChooser(new File("."));
     
    private void saveTable() {
        if (myJFileChooser.showSaveDialog(this) ==
                JFileChooser.APPROVE_OPTION ) {
            saveTable(myJFileChooser.getSelectedFile());
        }
    }
     
    private void saveTable(File file) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
                out.writeObject(tableModel.getDataVector());
                out.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
    }
     
    private void loadTable() {
        if (myJFileChooser.showOpenDialog(this) ==
                JFileChooser.APPROVE_OPTION )
            loadTable(myJFileChooser.getSelectedFile());
    }
     
    private void loadTable(File file) {
        try {
            ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(file));
            Vector rowData = (Vector)in.readObject();
            Iterator itr = rowData.iterator();
            while(itr.hasNext()) {
                tableModel.addRow((Vector) itr.next());
            }
            in.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
    public saveloadtestcode() {
         
        add(jbtAddRow, BorderLayout.NORTH);
         
        add(new JScrollPane(myJTable), BorderLayout.CENTER);
         
        JPanel panel = new JPanel(new java.awt.GridLayout(1, 2));
        panel.add(jbtSave);
        panel.add(jbtLoad);
        add(panel, BorderLayout.SOUTH);
         
        jbtAddRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (myJTable.getSelectedRow() >= 0 )
                    tableModel.insertRow (myJTable.getSelectedRow(),
                        new java.util.Vector());
                else
                    tableModel.addRow(new java.util.Vector());
            }
        });
         
        jbtSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTable();
            }
        });
 
        jbtLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTable();
            }
        });
         
        // Create a combo box for season
        JComboBox jcboSeason = new JComboBox();
        jcboSeason.addItem("Math");
        jcboSeason.addItem("Compsci");
        jcboSeason.addItem("Super Math");
        jcboSeason.addItem("Extreme Comp Sci");
                         
        // Set combo box as the editor for the season column
        TableColumn seasonColumn = myJTable.getColumn("Course");
        seasonColumn.setCellEditor(
        new DefaultCellEditor(jcboSeason));
         
        // Create a combo box for sport
        JComboBox jcboSport = new JComboBox();
        jcboSport.addItem("Morning");
        jcboSport.addItem("Noon");
        jcboSport.addItem("Evening");
        jcboSport.addItem("Night");
                         
        // Set combo box as the editor for the sport column
        TableColumn sportColumn = myJTable.getColumn("Time");
        sportColumn.setCellEditor(
        new DefaultCellEditor(jcboSport));
         
    }
 
    public static void main(String[] args) {
     
        saveloadtestcode frame = new saveloadtestcode();
        frame.setTitle("Saved Courses");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
 
    }
 
}
