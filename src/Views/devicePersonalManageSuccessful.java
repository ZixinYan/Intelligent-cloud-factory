package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;

public class devicePersonalManageSuccessful {

	private JFrame frame;
	public devicePersonalManageSuccessful() {
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
		textPane.setFont(new Font("Serif", Font.PLAIN, 45));
		textPane.setForeground(new Color(0, 255, 255));
		textPane.setText("修改成功");
		textPane.setBackground(new Color(0,0,0,0));
		textPane.setBounds(111, 63, 270, 58);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.setBounds(155, 193, 120, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            new personalFactory();
		        }
			}
		});
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
}
