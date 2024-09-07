package Views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class factoryManageSuccessful {

	private JFrame frame;
	public factoryManageSuccessful() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 672, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Serif", Font.PLAIN, 45));
		textPane.setForeground(new Color(0, 255, 255));
		textPane.setText("修改成功");
		textPane.setBackground(new Color(0,0,0,0));
		textPane.setBounds(202, 86, 270, 58);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.setBounds(229, 223, 149, 38);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            try {
						new factoryManage();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}

}
