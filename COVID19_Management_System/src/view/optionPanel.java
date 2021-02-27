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
import java.awt.Canvas;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class optionPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public optionPanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COVID'19 Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 27, 262, 28);
		add(lblNewLabel);
		
		JButton btnPatientsReg = new JButton("PATIENTS REGISTRATION");
		btnPatientsReg.setHorizontalAlignment(SwingConstants.LEADING);
		btnPatientsReg.setFont(new Font("Calibri", Font.BOLD, 12));
		btnPatientsReg.setForeground(Color.BLACK);
		btnPatientsReg.setBorderPainted(false);
		btnPatientsReg.setBackground(Color.WHITE);
		btnPatientsReg.setBounds(35, 126, 168, 52);
		add(btnPatientsReg);
		btnPatientsReg.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnPatientsReg.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnPatientsReg.setBackground(Color.WHITE);
		    }

		    public void mouseClicked(java.awt.event.MouseEvent e)
		    {
		    	JButton button = (JButton)e.getSource();
		    	JPanel buttonPanel = (JPanel)button.getParent();
		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
		    	layout.show(cardLayoutPanel, "t4");
		    }
		});
		
		JButton btnPatientsInfo = new JButton("PATIENTS' INFO");
		btnPatientsInfo.setHorizontalAlignment(SwingConstants.LEADING);
		btnPatientsInfo.setForeground(Color.BLACK);
		btnPatientsInfo.setFont(new Font("Calibri", Font.BOLD, 12));
		btnPatientsInfo.setBorderPainted(false);
		btnPatientsInfo.setBackground(Color.WHITE);
		btnPatientsInfo.setBounds(308, 127, 168, 52);
		add(btnPatientsInfo);
		btnPatientsInfo.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnPatientsInfo.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnPatientsInfo.setBackground(Color.WHITE);
		    }

		    public void mouseClicked(java.awt.event.MouseEvent e)
		    {
		    	JButton button = (JButton)e.getSource();
		    	JPanel buttonPanel = (JPanel)button.getParent();
		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
		    	layout.show(cardLayoutPanel, "t6");
		    }
		});
		
		JButton btnDoctorsReg = new JButton("DOCTORS REGISTRATION");
		btnDoctorsReg.setHorizontalAlignment(SwingConstants.LEADING);
		btnDoctorsReg.setForeground(Color.BLACK);
		btnDoctorsReg.setFont(new Font("Calibri", Font.BOLD, 12));
		btnDoctorsReg.setBorderPainted(false);
		btnDoctorsReg.setBackground(Color.WHITE);
		btnDoctorsReg.setBounds(35, 210, 168, 51);
		add(btnDoctorsReg);
		btnDoctorsReg.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDoctorsReg.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDoctorsReg.setBackground(Color.WHITE);
		    }

		    public void mouseClicked(java.awt.event.MouseEvent e)
		    {
		    	JButton button = (JButton)e.getSource();
		    	JPanel buttonPanel = (JPanel)button.getParent();
		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
		    	layout.show(cardLayoutPanel, "t5");
		    }
		});
		
		JButton btnDoctorsInfo = new JButton("DOCTORS' INFO");
		btnDoctorsInfo.setHorizontalAlignment(SwingConstants.LEADING);
		btnDoctorsInfo.setForeground(Color.BLACK);
		btnDoctorsInfo.setFont(new Font("Calibri", Font.BOLD, 12));
		btnDoctorsInfo.setBorderPainted(false);
		btnDoctorsInfo.setBackground(Color.WHITE);
		btnDoctorsInfo.setBounds(308, 211, 168, 51);
		add(btnDoctorsInfo);
		btnDoctorsInfo.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDoctorsInfo.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDoctorsInfo.setBackground(Color.WHITE);
		    }

		    public void mouseClicked(java.awt.event.MouseEvent e)
		    {
		    	JButton button = (JButton)e.getSource();
		    	JPanel buttonPanel = (JPanel)button.getParent();
		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
		    	layout.show(cardLayoutPanel, "t7");
		    }
		});
		
		JButton btnNewTest = new JButton("NEW TEST");
		btnNewTest.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewTest.setForeground(Color.BLACK);
		btnNewTest.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewTest.setBorderPainted(false);
		btnNewTest.setBackground(Color.WHITE);
		btnNewTest.setBounds(308, 292, 168, 52);
		add(btnNewTest);
		
		JButton btnAdmissionForm = new JButton("ADMISSION FORM");
		btnAdmissionForm.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdmissionForm.setForeground(Color.BLACK);
		btnAdmissionForm.setFont(new Font("Calibri", Font.BOLD, 12));
		btnAdmissionForm.setBorderPainted(false);
		btnAdmissionForm.setBackground(Color.WHITE);
		btnAdmissionForm.setBounds(35, 293, 168, 49);
		add(btnAdmissionForm);
		btnAdmissionForm.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnAdmissionForm.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnAdmissionForm.setBackground(Color.WHITE);
		    }

		    public void mouseClicked(java.awt.event.MouseEvent e)
		    {
		    	JButton button = (JButton)e.getSource();
		    	JPanel buttonPanel = (JPanel)button.getParent();
		    	JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
		    	CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
		    	layout.show(cardLayoutPanel, "t8");
		    }
		});
		
		
		JButton btnStatisticalData = new JButton("STATISTICAL DATA");
		btnStatisticalData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnStatisticalData.setBackground(Color.RED);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnStatisticalData.setBackground(Color.CYAN);
		    }
		    
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Not Enough Data To Compute Statistics.", "Statistical Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnStatisticalData.setHorizontalAlignment(SwingConstants.LEADING);
		btnStatisticalData.setForeground(Color.BLACK);
		btnStatisticalData.setFont(new Font("Calibri", Font.BOLD, 12));
		btnStatisticalData.setBorderPainted(false);
		btnStatisticalData.setBackground(Color.CYAN);
		btnStatisticalData.setBounds(35, 377, 168, 52);
		add(btnStatisticalData);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 12));
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(Color.CYAN);
		btnLogout.setBounds(308, 377, 168, 52);
		add(btnLogout);
		btnLogout.setBorderPainted(false);
		btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnLogout.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnLogout.setBackground(Color.CYAN);
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
	}
}