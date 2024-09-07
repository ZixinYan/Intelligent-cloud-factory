package Views;
import java.awt.EventQueue;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class setLogIn extends MouseAdapter{
	private JFrame frame;
	public setLogIn() {
		initialize();
	}
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 60));
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	new logIn(false);
		            
		        }
		    }
		});
		btnNewButton.setBounds(108, 292, 124, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		            new register();
		        }
		    }
		});
		btnNewButton_1.setBounds(467, 292, 124, 53);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 255, 255));
		textPane.setBackground(new Color(0,0,0,0));
		textPane.setEditable(false);
		textPane.setFont(new Font("Yu Mincho", Font.PLAIN, 65));
		textPane.setText("云智能平台");
		textPane.setBounds(193, 68, 491, 134);
		frame.getContentPane().add(textPane);
		frame.setVisible(true);
	    //ImageIcon img = new ImageIcon("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\background.jpg");
		//JLabel label  =  new JLabel(img);
		//label.setSize(750,500);
		//frame.getLayeredPane().add(label,Integer.MIN_VALUE);
        //JPanel pan =  (JPanel)frame.getContentPane();
        //pan.setOpaque(false);
	}
}
