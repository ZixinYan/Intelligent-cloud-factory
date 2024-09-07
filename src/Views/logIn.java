package Views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import Controller.logInJudge;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

public class logIn {

	private JFrame frame;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public logIn(boolean judge) {
		initialize(judge);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(boolean judge) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Yu Mincho", Font.PLAIN, 40));
		frame.setBounds(100, 100, 742, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(frame.getBackground());
		textPane.setText("欢迎登录");
		textPane.setFont(new Font("SansSerif", Font.PLAIN, 35));
		textPane.setEditable(false);
		textPane.setBounds(275, 27, 264, 49);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(frame.getBackground());
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_1.setText("请输入密码");
		textPane_1.setBounds(20, 225, 138, 40);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(frame.getBackground());
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_2.setText("请输入用户名");
		textPane_2.setBounds(20, 98, 137, 40);
		frame.getContentPane().add(textPane_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 98, 460, 41);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnNewButton.setBounds(132, 329, 138, 40);
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	String password = new String(passwordField.getPassword());
		            try {
						logInJudge.getL().logInJudge(textField_1.getText(), password);
						logInJudge.getL().getName(textField_1.getText());
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnNewButton_1.setBounds(432, 329, 138, 40);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		            new setLogIn();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 225, 460, 40);
		frame.getContentPane().add(passwordField);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBackground(frame.getBackground());
		textPane_3.setEnabled(judge);
		textPane_3.setForeground(new Color(255, 0, 0));
		textPane_3.setText("用户名与密码不匹配");
		textPane_3.setEditable(false);
		textPane_3.setBounds(298, 285, 241, 33);
		frame.getContentPane().add(textPane_3);
		frame.setVisible(true);
		
	}
	
	public String getName() {
		return textField_1.getText();
	}
	
	public String getPassword() {
		String password =new String (passwordField.getPassword());
		return password;
    }
}
