package Views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Color;

public class registerSuccessful {

	private JFrame frame;

	public registerSuccessful() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 801, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		textPane.setText("注册成功");
		textPane.setBackground(frame.getBackground());
		textPane.setBounds(268, 59, 212, 134);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setForeground(new Color(0, 255, 255));
		textPane_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 38));
		textPane_1.setText("欢迎加入云智能平台");
		textPane_1.setBackground(frame.getBackground());
		textPane_1.setBounds(200, 185, 522, 103);
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton = new JButton("去登录！");
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton.setBounds(268, 331, 212, 44);
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		            new logIn(false);
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);		
	}
}
