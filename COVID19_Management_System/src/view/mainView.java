package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

public class mainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView frame = new mainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainView() {
		setTitle("COVID'19 Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel p1 = new startUp();
		contentPane.add(p1, "t1");
		
		JPanel p2 = new loginPanel();
		contentPane.add(p2, "t2");
		
		JPanel p3 = new optionPanel();
		contentPane.add(p3, "t3");
		
		JPanel p4 = new patientRegistration();
		contentPane.add(p4, "t4");
		
		JPanel p5 = new doctorRegistration();
		contentPane.add(p5, "t5");
		
		JPanel p6 = new patientInfo();
		contentPane.add(p6, "t6");
		
		JPanel p7 = new doctorInfo();
		contentPane.add(p7, "t7");
		
		JPanel p8 = new admissionPanel();
		contentPane.add(p8, "t8");
		
		JPanel p10 = new accountRegisteration();
		contentPane.add(p10, "t10");
	}

}