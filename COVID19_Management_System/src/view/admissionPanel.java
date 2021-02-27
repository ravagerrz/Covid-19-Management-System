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

import model.admission;
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

public class admissionPanel extends JPanel {
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField txt_admitID;
	private JTextField txt_patientID;
	private JTextField txt_doctorID;
	private JTextField txt_bedNo;
	private JComboBox cb_status;
	
	private admission ad = new admission();
	private JTextField txt_roomNo;
	
	/**
	 * Create the panel.
	 */
	public admissionPanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COVID'19 Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 27, 262, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADMISSION FORM");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_1.setBounds(35, 87, 147, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIT ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 131, 121, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("PATIENT ID");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(36, 171, 146, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DOCTOR ID");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(36, 210, 146, 14);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("ROOM NO.");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(35, 247, 154, 14);
		add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("BED NO.");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(36, 287, 146, 14);
		add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("STATUS");
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
		
		txt_admitID = new JTextField();
		txt_admitID.setBounds(221, 126, 147, 20);
		add(txt_admitID);
		txt_admitID.setColumns(10);
		txt_admitID.setEnabled(false);
        txt_admitID.setDisabledTextColor(Color.GRAY);
        
        try {
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			String query = "Select * FROM COVID19_Management_System.Admission";
			pst = conn.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			if (rs.next())
			{
				txt_admitID.setText(String.valueOf(rs.getInt("admitID") + 1));
            }
			else
			{
				txt_admitID.setText("0");
			}
			
		} catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		txt_patientID = new JTextField();
		txt_patientID.setColumns(10);
		txt_patientID.setBounds(221, 166, 147, 20);
		add(txt_patientID);
		
		txt_doctorID = new JTextField();
		txt_doctorID.setColumns(10);
		txt_doctorID.setBounds(221, 205, 147, 20);
		add(txt_doctorID);
		
		txt_bedNo = new JTextField();
		txt_bedNo.setColumns(10);
		txt_bedNo.setBounds(221, 282, 147, 20);
		add(txt_bedNo);
		
		JButton btnSave = new JButton("SAVE");
		
		btnSave.setForeground(Color.BLACK);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(221, 361, 89, 23);
		add(btnSave);
		
		txt_roomNo = new JTextField();
		txt_roomNo.setColumns(10);
		txt_roomNo.setBounds(221, 242, 147, 20);
		add(txt_roomNo);
		
		cb_status = new JComboBox();
		cb_status.setModel(new DefaultComboBoxModel(new String[] {"ADMITTED", "RECOVERED", "DECEASED"}));
		cb_status.setToolTipText("");
		cb_status.setBounds(221, 320, 147, 22);
		add(cb_status);
	
		// Event Handler Code
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_patientID.getText().isEmpty() || txt_doctorID.getText().isEmpty() || txt_roomNo.getText().isEmpty() || txt_bedNo.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Complete Information.", "Missing Information",JOptionPane.ERROR_MESSAGE);
					restoreDefaultValues();
				}
				else
				{
					
					try {
						Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
						String query = "Select * FROM COVID19_Management_System.Patient WHERE patientID=?";
						pst = conn.prepareStatement(query);
						pst.setString(1, txt_patientID.getText());
						
						rs = pst.executeQuery();
						
						if (rs.next())
						{
							try {
								String query1 = "Select * FROM COVID19_Management_System.Doctor WHERE doctorID=?";
								pst = conn.prepareStatement(query1);
								pst.setString(1, txt_doctorID.getText());
								
								rs = pst.executeQuery();
								
								if (rs.next())
								{
									ad.setPatientID(Integer.parseInt(txt_patientID.getText()));
									ad.setDoctorID(Integer.parseInt(txt_doctorID.getText()));
									ad.setRoomNo(Integer.parseInt(txt_roomNo.getText()));
									ad.setBedNo(Integer.parseInt(txt_bedNo.getText()));
									ad.setStatus(cb_status.getSelectedItem().toString());
									
									if(ad.saveData())
									{
										JOptionPane.showMessageDialog(null, "Admission has been Successfull.", "Data Insertion Successfull",JOptionPane.INFORMATION_MESSAGE);
										restoreDefaultValues();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Check connection and Try again.", "Data Insertion Failed",JOptionPane.ERROR_MESSAGE);
									}
					            }
								else
								{
									JOptionPane.showMessageDialog(null, "This Doctor ID Doesn't Exist.", "Incorrect Doctor ID",JOptionPane.ERROR_MESSAGE);
								}
								
							} catch (SQLException sqlException) {
					            sqlException.printStackTrace();
					        }
			            }
						else
						{
							JOptionPane.showMessageDialog(null, "This Patient ID Doesn't Exist.", "Incorrect Patient ID",JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (SQLException sqlException) {
			            sqlException.printStackTrace();
			        }
				}
			}
		});
		// End
	}
	
	public void restoreDefaultValues()
	{
		txt_patientID.setText("");
		txt_doctorID.setText("");
		txt_roomNo.setText("");
		txt_bedNo.setText("");
		cb_status.setSelectedIndex(0);
	}
}