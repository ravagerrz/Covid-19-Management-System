package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextField;

import model.DBConnection;
import model.login;

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

public class accountRegisteration extends JPanel {
    private JTextField txt_uname;
    private JTextField txt_pass;
    private PreparedStatement pst;
    private ResultSet rs;
    private JPasswordField passwordField;
    
    private login log = new login();

    /**
     * Create the panel.
     */
    public accountRegisteration() {
        setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("COVID'19 Management System");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel.setBounds(140, 27, 262, 28);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("REGISTRATION PAGE");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
        lblNewLabel_1.setBounds(35, 87, 158, 28);
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
        
        JButton btnRegister = new JButton("REGISTER");
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setBackground(Color.WHITE);
        btnRegister.setBounds(123, 229, 147, 23);
		add(btnRegister);
		btnRegister.setBorderPainted(false);
		btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnRegister.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnRegister.setBackground(Color.WHITE);
		    }
		});
        
        JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		    	layout.show(cardLayoutPanel, "t2");
		    }
		});
        
		// Event Handler Code
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_uname.getText().isEmpty() && txt_pass.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Complete Information.", "Missing Information",JOptionPane.ERROR_MESSAGE);
					restoreDefaultValues();
				}
				else
				{
					log.setUsername(txt_uname.getText());
					log.setPassword(txt_pass.getText());
					
					if(log.saveData())
					{
						JOptionPane.showMessageDialog(null, "Registeration has been Successful", "Registeration Successful",JOptionPane.INFORMATION_MESSAGE);
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
		txt_uname.setText("");
		txt_pass.setText("");
	}
}