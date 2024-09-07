package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.factoryManager;
import Controller.userManager;
import Controller.userManagerData;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class factoryManage {

	private JFrame frame;
	private JTextField textField;
	private Object[] columnNames = {"  ","ID","工厂名称","工厂简介","负责人","联系方式","登录账号","工厂状态"};
	private JTable table;
	public factoryManage() throws FileNotFoundException, IOException {
		initialize();
	}
	private void initialize() throws FileNotFoundException, IOException {
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Serif", Font.PLAIN, 12));
		frame.setBounds(100, 100, 732, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 44, 222, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("工厂名称查询");
		btnNewButton.setBounds(262, 44, 122, 29);
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		DefaultTableModel model = new DefaultTableModel(factoryManager.getU().getFactoryData(textField.getText()),columnNames);
		        		table.setModel(model);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("切换");
		btnNewButton_1.setBounds(30, 102, 107, 29);
		btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		frame.dispose();
		        		factoryManager.getU().changeType(table, table.getSelectedRow());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_1);
		
		table = new JTable(factoryManager.getU().getFactoryManager(),columnNames) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){  
				   if(column == 0){  
				       return true;  
				   }else{  
				       return false;  
				   }  
				} 
		};
		table.setSurrendersFocusOnKeystroke(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 142, 643, 166);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_2.setBounds(601, 336, 107, 29);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	new menu();	
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2);
	}
}
