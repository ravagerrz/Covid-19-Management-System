package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import view.mainView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class patientInfo extends JPanel {
	private JTextField txt_patientIDS;
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField txt_fnameS;
	private JTextField txt_patientID;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_phone;
	private JTextField txt_gender;
	private JTextField txt_drfname;
	private JTextField txt_roomNo;
	private JTextField txt_bedNo;
	private JTextField txt_status;
	private JTextField txt_drlname;
	
	private String doctorIDCheck;
	
	/**
	 * Create the panel.
	 */
	public patientInfo() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COVID'19 Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 27, 262, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_1.setBounds(35, 87, 105, 28);
		add(lblNewLabel_1);
		
		txt_patientIDS = new JTextField();
		txt_patientIDS.setBounds(140, 89, 105, 20);
		add(txt_patientIDS);
		txt_patientIDS.setColumns(10);
		
		JButton btnEnterpid = new JButton("ENTER");
		btnEnterpid.setBounds(278, 88, 89, 23);
		add(btnEnterpid);
		btnEnterpid.setForeground(Color.BLACK);
        btnEnterpid.setBackground(Color.WHITE);
		btnEnterpid.setBorderPainted(false);
		btnEnterpid.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnEnterpid.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnEnterpid.setBackground(Color.WHITE);
		    }
		});
		
		JButton btnBack = new JButton("<");
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(35, 29, 41, 23);
		add(btnBack);
		btnBack.setBorderPainted(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("FIRST NAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(35, 126, 105, 28);
		add(lblNewLabel_1_1);
		
		txt_fnameS = new JTextField();
		txt_fnameS.setColumns(10);
		txt_fnameS.setBounds(140, 128, 105, 20);
		add(txt_fnameS);
		
		JButton btnEnterfname = new JButton("ENTER");
		btnEnterfname.setBounds(278, 127, 89, 23);
		add(btnEnterfname);
		btnEnterfname.setForeground(Color.BLACK);
        btnEnterfname.setBackground(Color.WHITE);
		btnEnterfname.setBorderPainted(false);
		btnEnterfname.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnEnterfname.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnEnterfname.setBackground(Color.WHITE);
		    }
		});
		
		JLabel lblNewLabel_2 = new JLabel("PATIENT ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 183, 121, 14);
		add(lblNewLabel_2);
		
		txt_patientID = new JTextField();
		txt_patientID.setEnabled(false);
		txt_patientID.setDisabledTextColor(Color.GRAY);
		txt_patientID.setColumns(10);
		txt_patientID.setBounds(160, 178, 147, 20);
		add(txt_patientID);
		
		JLabel lblNewLabel_2_1 = new JLabel("FIRST NAME");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(36, 223, 146, 14);
		add(lblNewLabel_2_1);
		
		txt_fname = new JTextField();
		txt_fname.setColumns(10);
		txt_fname.setBounds(160, 218, 147, 20);
		add(txt_fname);
		txt_fname.setEnabled(false);
        txt_fname.setDisabledTextColor(Color.GRAY);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("LAST NAME");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(36, 262, 146, 14);
		add(lblNewLabel_2_1_1);
		
		txt_lname = new JTextField();
		txt_lname.setColumns(10);
		txt_lname.setBounds(160, 257, 147, 20);
		add(txt_lname);
		txt_lname.setEnabled(false);
        txt_lname.setDisabledTextColor(Color.GRAY);
		
		JLabel lblNewLabel_2_2 = new JLabel("GENDER");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(35, 299, 154, 14);
		add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PHONE NUMBER");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(36, 339, 146, 14);
		add(lblNewLabel_2_1_2);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(160, 334, 147, 20);
		add(txt_phone);
		txt_phone.setEnabled(false);
        txt_phone.setDisabledTextColor(Color.GRAY);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("ADDRESS");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(36, 378, 146, 14);
		add(lblNewLabel_2_1_1_1);
		
		JTextArea txt_address = new JTextArea();
		txt_address.setBounds(221, 371, 146, 46);
		add(txt_address);
		JScrollPane scroll1 = new JScrollPane(txt_address);
		scroll1.setBounds(160, 371, 146, 46);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll1);
		txt_address.setEnabled(false);
        txt_address.setDisabledTextColor(Color.GRAY);
        
        txt_gender = new JTextField();
        txt_gender.setEnabled(false);
        txt_gender.setDisabledTextColor(Color.GRAY);
        txt_gender.setColumns(10);
        txt_gender.setBounds(159, 294, 147, 20);
        add(txt_gender);
        
        JLabel lblNewLabel_2_1_1_2 = new JLabel("Dr. First Name");
        lblNewLabel_2_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_2_1_1_2.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_1_1_2.setBounds(344, 183, 89, 14);
        add(lblNewLabel_2_1_1_2);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("ROOM NO.");
        lblNewLabel_2_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_2_1.setBounds(343, 260, 98, 14);
        add(lblNewLabel_2_2_1);
        
        JLabel lblNewLabel_2_1_2_1 = new JLabel("BED NO.");
        lblNewLabel_2_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_1_2_1.setBounds(344, 300, 89, 14);
        add(lblNewLabel_2_1_2_1);
        
        JLabel lblNewLabel_2_1_1_1_1 = new JLabel("STATUS");
        lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_2_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_1_1_1_1.setBounds(344, 339, 89, 14);
        add(lblNewLabel_2_1_1_1_1);
        
        txt_drfname = new JTextField();
        txt_drfname.setEnabled(false);
        txt_drfname.setDisabledTextColor(Color.GRAY);
        txt_drfname.setColumns(10);
        txt_drfname.setBounds(445, 177, 147, 20);
        add(txt_drfname);
        
        txt_roomNo = new JTextField();
        txt_roomNo.setEnabled(false);
        txt_roomNo.setDisabledTextColor(Color.GRAY);
        txt_roomNo.setColumns(10);
        txt_roomNo.setBounds(445, 257, 147, 20);
        add(txt_roomNo);
        
        txt_bedNo = new JTextField();
        txt_bedNo.setEnabled(false);
        txt_bedNo.setDisabledTextColor(Color.GRAY);
        txt_bedNo.setColumns(10);
        txt_bedNo.setBounds(445, 296, 147, 20);
        add(txt_bedNo);
        
        txt_status = new JTextField();
        txt_status.setEnabled(false);
        txt_status.setDisabledTextColor(Color.GRAY);
        txt_status.setColumns(10);
        txt_status.setBounds(444, 333, 147, 20);
        add(txt_status);
        
        JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Dr. Last Name");
        lblNewLabel_2_1_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1_1_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_1_1_2_1.setBounds(344, 223, 89, 14);
        add(lblNewLabel_2_1_1_2_1);
        
        txt_drlname = new JTextField();
        txt_drlname.setEnabled(false);
        txt_drlname.setDisabledTextColor(Color.GRAY);
        txt_drlname.setColumns(10);
        txt_drlname.setBounds(445, 218, 147, 20);
        add(txt_drlname);
		
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
		    	restoreDefaultValues();
		    }
		    
		    public void restoreDefaultValues()
			{
		    	txt_patientIDS.setText("");
		    	txt_fnameS.setText("");
		    	txt_patientID.setText("");
				txt_fname.setText("");
				txt_lname.setText("");
				txt_gender.setText("");
				txt_phone.setText("");
				txt_address.setText("");
				txt_drfname.setText("");
				txt_drlname.setText("");
				txt_roomNo.setText("");
				txt_bedNo.setText("");
				txt_status.setText("");
			}
		});
		
		// Event Handlers
		btnEnterpid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
        			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        			String query = "Select * FROM COVID19_Management_System.Patient WHERE patientID=?";
        			pst = conn.prepareStatement(query);
        			pst.setString(1, txt_patientIDS.getText());
        			
        			rs = pst.executeQuery();
        			
        			if (rs.next())
        			{
        				txt_patientID.setText(rs.getString("patientID"));
        				txt_fname.setText(rs.getString("fname"));
        				txt_lname.setText(rs.getString("lname"));
        				txt_gender.setText(rs.getString("Gender"));
        				txt_phone.setText(rs.getString("Phone"));
        				txt_address.setText(rs.getString("Address"));
        				
        				try {
                			String query1 = "Select * FROM COVID19_Management_System.Admission WHERE patientID=?";
                			pst = conn.prepareStatement(query1);
                			pst.setString(1, txt_patientIDS.getText());
                			
                			rs = pst.executeQuery();
                			
                			if (rs.next())
                			{
                				doctorIDCheck = rs.getString("doctorID");
                				txt_roomNo.setText(rs.getString("roomNo"));
                				txt_bedNo.setText(rs.getString("bedNo"));
                				txt_status.setText(rs.getString("Status"));
                				
                				try {
                        			String query2 = "Select * FROM COVID19_Management_System.Doctor WHERE doctorID=?";
                        			pst = conn.prepareStatement(query2);
                        			pst.setString(1, doctorIDCheck);
                        			
                        			rs = pst.executeQuery();
                        			
                        			if (rs.next())
                        			{
                        				txt_drfname.setText(rs.getString("fname"));
                        				txt_drlname.setText(rs.getString("lname"));
                                    }
                        			
                				} catch (SQLException sqlException) {
                                    sqlException.printStackTrace();
                                }
                            }
                			
        				} catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                    }
        			else
        			{
                        JOptionPane.showMessageDialog(btnEnterpid, "Wrong Type");
                    }
        			
				} catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
		
		btnEnterfname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
        			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        			String query4 = "Select * FROM COVID19_Management_System.Patient WHERE fname=?";
        			pst = conn.prepareStatement(query4);
        			pst.setString(1, txt_fnameS.getText());
        			
        			rs = pst.executeQuery();
        			
        			if (rs.next())
        			{
        				txt_patientID.setText(rs.getString("patientID"));
        				txt_fname.setText(rs.getString("fname"));
        				txt_lname.setText(rs.getString("lname"));
        				txt_gender.setText(rs.getString("Gender"));
        				txt_phone.setText(rs.getString("Phone"));
        				txt_address.setText(rs.getString("Address"));
        				
        				try {
                			String query1 = "Select * FROM COVID19_Management_System.Admission WHERE patientID=?";
                			pst = conn.prepareStatement(query1);
                			pst.setString(1, txt_patientID.getText());
                			
                			rs = pst.executeQuery();
                			
                			if (rs.next())
                			{
                				doctorIDCheck = rs.getString("doctorID");
                				txt_roomNo.setText(rs.getString("roomNo"));
                				txt_bedNo.setText(rs.getString("bedNo"));
                				txt_status.setText(rs.getString("Status"));
                				
                				try {
                        			String query2 = "Select * FROM COVID19_Management_System.Doctor WHERE doctorID=?";
                        			pst = conn.prepareStatement(query2);
                        			pst.setString(1, doctorIDCheck);
                        			
                        			rs = pst.executeQuery();
                        			
                        			if (rs.next())
                        			{
                        				txt_drfname.setText(rs.getString("fname"));
                        				txt_drlname.setText(rs.getString("lname"));
                                    }
                        			
                				} catch (SQLException sqlException) {
                                    sqlException.printStackTrace();
                                }
                            }
                			
        				} catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                    }
        			else
        			{
                        JOptionPane.showMessageDialog(btnEnterfname, "Wrong Type");
                    }
        			
				} catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
	}
}