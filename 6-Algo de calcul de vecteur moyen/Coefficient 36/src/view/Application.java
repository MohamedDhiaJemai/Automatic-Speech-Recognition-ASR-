package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Application extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Application frame = new Application();
					frame.setVisible(true);
					
				}
			    		
			   catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		
		
		setType(Type.POPUP);
		setTitle("Classification \r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Create MFCC Vector"));
		panel.add(panel_1, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setColumns(35);
		panel_1.add(textField);
		
		JButton button = new JButton("Import folder");
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setHorizontalAlignment(SwingConstants.LEADING);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(button);
		
		JButton btnCreateThVector = new JButton("Create th Vector");
		btnCreateThVector.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(btnCreateThVector);
		
		JButton btnShowTheVector = new JButton("Show the Vector");
		btnShowTheVector.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(btnShowTheVector);
		
		JButton btnNewButton = new JButton("save Vector");
		panel_1.add(btnNewButton);
	}

}
