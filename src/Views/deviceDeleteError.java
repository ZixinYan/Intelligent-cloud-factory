package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import Controller.deviceManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;

public class deviceDeleteError {

	private JFrame frame;
	public deviceDeleteError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Serif", Font.PLAIN, 35));
		textPane.setForeground(new Color(255, 0, 0));
		textPane.setBackground(new Color(0,0,0,0));
		textPane.setText("设备正在被租用            不能删除！！！");
		textPane.setEditable(false);
		textPane.setBounds(51, 40, 385, 114);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.setBounds(147, 197, 89, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	new deviceManage();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton);
	}
}
