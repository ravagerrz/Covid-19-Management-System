package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.patient;
import view.mainView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class patientRegistration extends JPanel {
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField txt_patientID;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_phone;
	private JTextArea txt_address;
	private JComboBox cb_gender;
	
	private patient pt = new patient();
	
	/**
	 * Create the panel.
	 */
	public patientRegistration() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COVID'19 Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 27, 262, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT DATA");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_1.setBounds(35, 87, 115, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PATIENT ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 131, 121, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("FIRST NAME");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(36, 171, 146, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("LAST NAME");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(36, 210, 146, 14);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("GENDER");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(35, 247, 154, 14);
		add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PHONE NUMBER");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(36, 287, 146, 14);
		add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("ADDRESS");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(36, 326, 146, 14);
		add(lblNewLabel_2_1_1_1);
		
		JButton btnBack = new JButton("<");
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(35, 29, 41, 23);
		add(btnBack);
		btnBack.setBorderPainted(false);
		btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnBack.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnBack.setBackground(Color.WHITE);
		    }

		    public void mouseClicked(java.awt.event.MouseEvent e)
		    {
		    	JButton button = (JButton)e.getSource();
		    	JPanel buttonPanel = (JPanel)button.getParent();
		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
		    	layout.show(cardLayoutPanel, "t3");
		    }
		});
		
		txt_address = new JTextArea();
		txt_address.setBounds(220, 322, 147, 46);
		add(txt_address);
		JScrollPane scroll1 = new JScrollPane(txt_address);
		scroll1.setBounds(221, 319, 147, 46);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll1);
		
		txt_patientID = new JTextField();
		txt_patientID.setBounds(221, 126, 147, 20);
		add(txt_patientID);
		txt_patientID.setColumns(10);
		txt_patientID.setEnabled(false);
        txt_patientID.setDisabledTextColor(Color.GRAY);
        
        try {
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			String query = "Select * FROM COVID19_Management_System.Patient";
			pst = conn.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			if (rs.next())
			{
				txt_patientID.setText(String.valueOf(rs.getInt("patientID") + 1));
            }
			else
			{
				txt_patientID.setText("0");
			}
			
		} catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		txt_fname = new JTextField();
		txt_fname.setColumns(10);
		txt_fname.setBounds(221, 166, 147, 20);
		add(txt_fname);
		
		txt_lname = new JTextField();
		txt_lname.setColumns(10);
		txt_lname.setBounds(221, 205, 147, 20);
		add(txt_lname);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(221, 282, 147, 20);
		add(txt_phone);
		
		cb_gender = new JComboBox();
		cb_gender.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE", "OTHER"}));
		cb_gender.setToolTipText("");
		cb_gender.setBounds(221, 241, 147, 22);
		add(cb_gender);
		
		JButton btnSave = new JButton("SAVE");
		
		btnSave.setForeground(Color.BLACK);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(221, 378, 89, 23);
		add(btnSave);
	
		// Event Handler Code
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_fname.getText().isEmpty() || txt_lname.getText().isEmpty() || txt_phone.getText().isEmpty() || txt_address.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Complete Information.", "Missing Information",JOptionPane.ERROR_MESSAGE);
					restoreDefaultValues();
				}
				else
				{
					pt.setFname(txt_fname.getText());
					pt.setLname(txt_lname.getText());
					pt.setGender(cb_gender.getSelectedItem().toString());
					pt.setPhone(txt_phone.getText());
					pt.setAddress(txt_address.getText());
					
					if(pt.saveData())
					{
						JOptionPane.showMessageDialog(null, "Patient has been added Successfully.", "Data Insertion Successful",JOptionPane.INFORMATION_MESSAGE);
						restoreDefaultValues();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Check connection and Try again.", "Data Insertion Failed",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		// End
	}
	
	public void restoreDefaultValues()
	{
		txt_fname.setText("");
		txt_lname.setText("");
		cb_gender.setSelectedIndex(0);
		txt_phone.setText("");
		txt_address.setText("");
	}
}