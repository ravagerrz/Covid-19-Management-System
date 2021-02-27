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

public class doctorInfo extends JPanel {
	private JTextField txt_doctorIDS;
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField txt_fnameS;
	private JTextField txt_doctorID;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_phone;
	private JTextField txt_gender;
	private JTextField txt_type;
	private JTextField txt_status;
	
	/**
	 * Create the panel.
	 */
	public doctorInfo() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COVID'19 Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 27, 262, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DOCTOR ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_1.setBounds(35, 87, 105, 28);
		add(lblNewLabel_1);
		
		txt_doctorIDS = new JTextField();
		txt_doctorIDS.setBounds(140, 89, 105, 20);
		add(txt_doctorIDS);
		txt_doctorIDS.setColumns(10);
		
		JButton btnEnterdid = new JButton("ENTER");
		btnEnterdid.setBounds(278, 88, 89, 23);
		add(btnEnterdid);
		btnEnterdid.setForeground(Color.BLACK);
        btnEnterdid.setBackground(Color.WHITE);
		btnEnterdid.setBorderPainted(false);
		btnEnterdid.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnEnterdid.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnEnterdid.setBackground(Color.WHITE);
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
		
		JLabel lblNewLabel_2 = new JLabel("DOCTOR ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 183, 121, 14);
		add(lblNewLabel_2);
		
		txt_doctorID = new JTextField();
		txt_doctorID.setEnabled(false);
		txt_doctorID.setDisabledTextColor(Color.GRAY);
		txt_doctorID.setColumns(10);
		txt_doctorID.setBounds(221, 178, 147, 20);
		add(txt_doctorID);
		
		JLabel lblNewLabel_2_1 = new JLabel("FIRST NAME");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(36, 223, 146, 14);
		add(lblNewLabel_2_1);
		
		txt_fname = new JTextField();
		txt_fname.setColumns(10);
		txt_fname.setBounds(221, 218, 147, 20);
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
		txt_lname.setBounds(221, 257, 147, 20);
		add(txt_lname);
		txt_lname.setEnabled(false);
        txt_lname.setDisabledTextColor(Color.GRAY);
		
		JLabel lblNewLabel_2_2 = new JLabel("GENDER");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(34, 337, 154, 14);
		add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PHONE NUMBER");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(35, 377, 146, 14);
		add(lblNewLabel_2_1_2);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(220, 372, 147, 20);
		add(txt_phone);
		txt_phone.setEnabled(false);
        txt_phone.setDisabledTextColor(Color.GRAY);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("ADDRESS");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(35, 416, 146, 14);
		add(lblNewLabel_2_1_1_1);
		
		JTextArea txt_address = new JTextArea();
		txt_address.setBounds(221, 371, 146, 46);
		add(txt_address);
		JScrollPane scroll1 = new JScrollPane(txt_address);
		scroll1.setBounds(220, 409, 146, 46);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll1);
		txt_address.setEnabled(false);
        txt_address.setDisabledTextColor(Color.GRAY);
        
        txt_gender = new JTextField();
        txt_gender.setEnabled(false);
        txt_gender.setDisabledTextColor(Color.GRAY);
        txt_gender.setColumns(10);
        txt_gender.setBounds(219, 332, 147, 20);
        add(txt_gender);
        
        JLabel lblNewLabel_2_1_1_2 = new JLabel("TYPE");
        lblNewLabel_2_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_2_1_1_2.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_1_1_2.setBounds(35, 300, 146, 14);
        add(lblNewLabel_2_1_1_2);
        
        txt_type = new JTextField();
        txt_type.setEnabled(false);
        txt_type.setDisabledTextColor(Color.GRAY);
        txt_type.setColumns(10);
        txt_type.setBounds(220, 295, 147, 20);
        add(txt_type);
        
        JLabel lblNewLabel_2_1_1_2_1 = new JLabel("STATUS");
        lblNewLabel_2_1_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1_1_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_1_1_2_1.setBounds(35, 477, 146, 14);
        add(lblNewLabel_2_1_1_2_1);
        
        txt_status = new JTextField();
        txt_status.setEnabled(false);
        txt_status.setDisabledTextColor(Color.GRAY);
        txt_status.setColumns(10);
        txt_status.setBounds(220, 472, 147, 20);
        add(txt_status);
		
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
		    	txt_doctorIDS.setText("");
		    	txt_fnameS.setText("");
		    	txt_doctorID.setText("");
				txt_fname.setText("");
				txt_lname.setText("");
				txt_type.setText("");
				txt_gender.setText("");
				txt_phone.setText("");
				txt_address.setText("");
				txt_status.setText("");
			}
		});
		
		// Event Handlers
		btnEnterdid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
        			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        			String query4 = "Select * FROM COVID19_Management_System.Doctor WHERE doctorID=?";
        			pst = conn.prepareStatement(query4);
        			pst.setString(1, txt_doctorIDS.getText());
        			
        			rs = pst.executeQuery();
        			
        			if (rs.next())
        			{
        				txt_doctorID.setText(rs.getString("doctorID"));
        				txt_fname.setText(rs.getString("fname"));
        				txt_lname.setText(rs.getString("lname"));
        				txt_type.setText(rs.getString("type"));
        				txt_gender.setText(rs.getString("Gender"));
        				txt_phone.setText(rs.getString("Phone"));
        				txt_address.setText(rs.getString("Address"));
        				txt_status.setText(rs.getString("Status"));
                    }
        			else
        			{
                        JOptionPane.showMessageDialog(btnEnterdid, "Wrong Type");
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
        			String query4 = "Select * FROM COVID19_Management_System.Doctor WHERE fname=?";
        			pst = conn.prepareStatement(query4);
        			pst.setString(1, txt_fnameS.getText());
        			
        			rs = pst.executeQuery();
        			
        			if (rs.next())
        			{
        				txt_doctorID.setText(rs.getString("doctorID"));
        				txt_fname.setText(rs.getString("fname"));
        				txt_lname.setText(rs.getString("lname"));
        				txt_type.setText(rs.getString("type"));
        				txt_gender.setText(rs.getString("Gender"));
        				txt_phone.setText(rs.getString("Phone"));
        				txt_address.setText(rs.getString("Address"));
        				txt_status.setText(rs.getString("Status"));
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