package Views;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import Controller.factoryManager;
import Controller.productManager;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class productInformationManager {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private Object[] columnNames = {" ","ID","产品编号","产品名称","产品类别","产品规格","产品概述"};
	public productInformationManager() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 213, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("类别名称查询");
		btnNewButton.setBounds(247, 32, 102, 30);
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		DefaultTableModel model = new DefaultTableModel(productManager.getU().getProductData(textField.getText()),columnNames);
		        		table.setModel(model);
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setBounds(359, 32, 89, 30);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
					new productInformationManager();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("新建");
		btnNewButton_2.setBounds(10, 105, 102, 23);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	DefaultTableModel model = (DefaultTableModel)table.getModel();
		        	table.setModel(model);
					Object[] newRow = new Object[]{" ","  ", "", "", "", "", ""};
					model.addRow(newRow);
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("删除");
		btnNewButton_2_1.setBounds(122, 105, 102, 23);
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		frame.dispose();
		        		productManager.getU().deleteData(table,table.getSelectedRow());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("修改");
		btnNewButton_2_1_1.setBounds(569, 105, 102, 23);
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		                    frame.dispose();
		                    TableCellEditor editor = table.getCellEditor();
		                    if (editor != null) {
		                        editor.stopCellEditing();
		                        productManager.getU().readDataFromJTable(table);
		                    }else {
		                    	new productInformationManager();
		                    }
		                    
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("返回");
		btnNewButton_2_1_2.setBounds(569, 331, 102, 23);
		btnNewButton_2_1_2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
					new menu();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_1_2);
		DefaultTableModel modeli = new DefaultTableModel();
		modeli.setDataVector(productManager.getU().getProductManager(),columnNames);
		table = new JTable(modeli) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){  
				   if(column == 2||column == 3||column == 4||column == 5||column == 6){  
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
	}
}
