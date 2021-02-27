package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextField;

import model.DBConnection;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.sql.*;
import java.util.*;
import javax.swing.JPasswordField;

public class loginPanel extends JPanel {
    private JTextField txt_uname;
    private JTextField txt_pass;
    private PreparedStatement pst;
    private ResultSet rs;
    private JPasswordField passwordField;

    /**
     * Create the panel.
     */
    public loginPanel() {
        setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("COVID'19 Management System");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel.setBounds(140, 27, 262, 28);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("LOGIN PAGE");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
        lblNewLabel_1.setBounds(35, 87, 97, 28);
        add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(35, 142, 74, 14);
        add(lblNewLabel_2);
        
        txt_uname = new JTextField();
        txt_uname.setBounds(123, 137, 147, 20);
        add(txt_uname);
        txt_uname.setColumns(10);
        
        JLabel lblNewLabel_2_1 = new JLabel("Password");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel_2_1.setBounds(35, 188, 74, 14);
        add(lblNewLabel_2_1);
        
        JPasswordField txt_pass = new JPasswordField();
        txt_pass.setColumns(10);
        txt_pass.setBounds(123, 183, 147, 20);
        txt_pass.setEchoChar('*');
        add(txt_pass);
        
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBounds(123, 229, 147, 23);
		add(btnLogin);
		btnLogin.setBorderPainted(false);
		btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnLogin.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnLogin.setBackground(Color.WHITE);
		    }
		});
        
        JButton btnBack = new JButton("<");
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(35, 29, 41, 23);
		add(btnBack);
		btnBack.setBorderPainted(false);
		
		JButton btnRegister = new JButton("CREATE ACCOUNT");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setBounds(123, 266, 147, 23);
		add(btnRegister);
		btnRegister.setBorderPainted(false);
		btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnRegister.setBackground(Color.CYAN);
		    	btnRegister.setForeground(Color.BLACK);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnRegister.setForeground(Color.BLUE);
				btnRegister.setBackground(Color.BLACK);
		    }
		    
		    public void mouseClicked(java.awt.event.MouseEvent e)
		    {
		    	JButton button = (JButton)e.getSource();
		    	JPanel buttonPanel = (JPanel)button.getParent();
		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
		    	layout.show(cardLayoutPanel, "t10");
		    }
		});
		
		
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
		    	layout.show(cardLayoutPanel, "t1");
		    }
		});
        
        // Event Handlers
        btnLogin.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
        			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        			String query = "Select username, password FROM COVID19_Management_System.Login WHERE username=? AND password=?";
        			pst = conn.prepareStatement(query);
        			pst.setString(1, txt_uname.getText());
        			pst.setString(2, txt_pass.getText());
        			
        			rs = pst.executeQuery();
        			
        			if (rs.next())
        			{
        				JButton button = (JButton)e.getSource();
        		    	JPanel buttonPanel = (JPanel)button.getParent();
        		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
        		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
        		    	layout.show(cardLayoutPanel, "t3");
        				
        				JOptionPane.showMessageDialog(btnLogin, "You have successfully logged in");
        				restoreDefaultValues();
                    }
        			else
        			{
                        JOptionPane.showMessageDialog(btnLogin, "Wrong Username & Password");
                        restoreDefaultValues();
                    }
        			
				} catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
        	}
        	
        	public void restoreDefaultValues()
        	{
        		txt_uname.setText("");
        		txt_pass.setText("");
        	}
        });

    }
}