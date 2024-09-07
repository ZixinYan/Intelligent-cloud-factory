package Views;
import java.io.*;

import Model.Factory;
import Model.User;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Controller.userModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

@SuppressWarnings("rawtypes")
public class register{

	private JFrame frame;
	private User user = new User();
	private Factory factory = new Factory();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private boolean judge1;
	private boolean judge2;
	private JPasswordField textField_3;
	private userModel u = userModel.getUserModel();

	public register(){
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 762, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Serif", Font.PLAIN, 20));
		textPane.setBackground(frame.getBackground());
		textPane.setText("登录账号");
		textPane.setBounds(49, 50, 92, 39);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setFont(new Font("Serif", Font.PLAIN, 20));
		textPane_1.setBackground(frame.getBackground());
		textPane_1.setText("登录密码");
		textPane_1.setBounds(49, 100, 92, 39);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setFont(new Font("Serif", Font.PLAIN, 20));
		textPane_2.setBackground(frame.getBackground());
		textPane_2.setText("真实姓名");
		textPane_2.setBounds(49, 150, 92, 39);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setFont(new Font("Serif", Font.PLAIN, 20));
		textPane_3.setBackground(frame.getBackground());
		textPane_3.setText("联系方式");
		textPane_3.setBounds(49, 200, 92, 39);
		frame.getContentPane().add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setFont(new Font("Serif", Font.PLAIN, 20));
		textPane_4.setBackground(frame.getBackground());
		textPane_4.setText("注册方式");
		textPane_4.setBounds(49, 250, 92, 39);
		frame.getContentPane().add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setFont(new Font("Serif", Font.PLAIN, 20));
		textPane_5.setBackground(frame.getBackground());
		textPane_5.setText("工厂名称");
		textPane_5.setBounds(49, 300, 92, 39);
		frame.getContentPane().add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setEditable(false);
		textPane_6.setText("工厂简介");
		textPane_6.setFont(new Font("Serif", Font.PLAIN, 20));
		textPane_6.setBackground(frame.getBackground());
		textPane_6.setBounds(49, 350, 92, 36);
		frame.getContentPane().add(textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setFont(new Font("Wingdings", Font.PLAIN, 66));
		textPane_7.setText("注册");
		textPane_7.setBackground(frame.getBackground());
		textPane_7.setBounds(582, 8, 133, 338);
		frame.getContentPane().add(textPane_7);
		
		textField = new JTextField();
		textField.setBounds(145, 50, 346, 31);
		frame.getContentPane().add(textField);

		
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 100, 346, 31);
	
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 150, 346, 31);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(145, 200, 346, 31);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(145, 300, 346, 31);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(145, 350, 346, 31);
		frame.getContentPane().add(textField_6);
		

		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
					String name = textField.getText();
					String password =  new String(textField_3.getPassword());
					String realName =  textField_7.getText();
					String email = textField_4.getText();
					String Fcname = textField_5.getText();
					String Fcbi = textField_6.getText();
		        	if(!(judge1==judge2) && !(name.isEmpty()) && !(password.isEmpty())
		        			&& !(email.isEmpty()) && !(realName.isEmpty())) {
		        		user.setUserName(name);
		    			user.setPassword(password);
		    			user.setRealName(realName);
		    			user.setEmail(email);
		    			if(!judge1) {
		    			    user.setType("经销商");
			    		    try {
			    		    	frame.dispose();
								userModel.getUserModel().safeUser(user);
							} catch (IOException e) {
								e.printStackTrace();
							}
			    		    
		    			}else {
		    				user.setType("云工厂");
		    				factory.setRealName(realName);
		    				factory.setFcName(Fcname);
		    				factory.setFcBriefIntroduction(Fcbi);
		    				factory.setEmail(email);
		    				factory.setUserName(name);
		    				factory.setType("开启");
			    		    try {
			    		    	frame.dispose();
								userModel.getUserModel().safeUser(user);
								userModel.getUserModel().safeFactory(factory);
							} catch (IOException e) {
								e.printStackTrace();
							}
		    			}
		    		}   else {
		    			  frame.dispose();
		    			  new registerError();
		    		  }
		        }
		    }
		});
		btnNewButton.setBounds(531, 350, 80, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_1.setBounds(637, 350, 80, 36);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            new setLogIn();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("云工厂");
		rdbtnNewRadioButton.setFont(new Font("Serif", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(147, 250, 121, 26);
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            judge1 = true;
		        } else {
		            judge1 = false;
		        }
		    }
		});
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("经销商");
		rdbtnNewRadioButton_1.setFont(new Font("Serif", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(318, 250, 121, 26);
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            judge2 = true;
		        } else {
		            judge2 = false;
		        }
		    }
		});
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setFont(new Font("SimHei", Font.PLAIN, 15));
		txtpnEmail.setBackground(frame.getBackground());
	    txtpnEmail.setText("(Email)");
		txtpnEmail.setEditable(false);
		txtpnEmail.setBounds(485, 200, 63, 31);
		frame.getContentPane().add(txtpnEmail);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(145, 150, 346, 31);
		frame.getContentPane().add(textField_7);
		
		textField_3 = new JPasswordField();
		textField_3.setBounds(145, 100, 346, 31);
		frame.getContentPane().add(textField_3);
		frame.setVisible(true);

	}
}

