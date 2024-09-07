package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class menu {

	private JFrame frame;

	public menu() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 860, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Serif", Font.PLAIN, 30));
		textPane.setEditable(false);
		textPane.setText("菜单——选择业务");
		textPane.setBackground(frame.getBackground());
		textPane.setBounds(36, 28, 299, 50);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("用户管理");
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton.setBounds(148, 107, 158, 50);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            try {
						new userManage();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("云工厂信息");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
		btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_1.setBounds(487, 107, 158, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("产品类别管理");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            try {
						new productTypeManage();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});
		btnNewButton_2.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_2.setBounds(148, 207, 158, 50);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("产品信息管理");
		btnNewButton_3.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_3.setBounds(487, 207, 158, 50);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            new productInformationManager();
		        }
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("设备类型管理");
		btnNewButton_4.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_4.setBounds(148, 301, 158, 50);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            try {
						new deviceTypeManage();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("设备管理");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            new deviceManage();
		        }
			}
		});
		btnNewButton_5.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_5.setBounds(487, 301, 158, 50);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("退出");
		btnNewButton_5_1.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton_5_1.setBounds(335, 366, 118, 39);
		btnNewButton_5_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		            frame.dispose();
		            new setLogIn();
		        }
			}
		});
		frame.getContentPane().add(btnNewButton_5_1);
		
		frame.setVisible(true);
	}
}
