package Views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import Controller.deviceManager;
import Controller.productManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deviceManage {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private Object[] columnNames = {" ","ID","设备编号","设备名称","设备类别","设备规格","设备状态","设备概述"
			,"租用状态","所属工厂"};
	public deviceManage() {
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
		        		DefaultTableModel model = new DefaultTableModel
		        				(deviceManager.getU().getDeviceData(textField.getText()),columnNames);
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
					new deviceManage();
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
					Object[] newRow = new Object[]{"","","","","","","","","",""};
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
		        		deviceManager.getU().deleteData(table,table.getSelectedRow());
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
		                        deviceManager.getU().readDataFromJTable(table);
		                    }else {
		                    	new deviceManage();
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
		modeli.setDataVector(deviceManager.getU().getDeviceManager(),columnNames);
		table = new JTable(modeli) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){  
				   if(column == 2||column == 3||column == 4||column == 5||column == 7){  
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
		
		JButton btnNewButton_2_1_1_1 = new JButton("设备状态");
		btnNewButton_2_1_1_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		frame.dispose();
						deviceManager.getU().changeType(table, table.getSelectedRow());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		btnNewButton_2_1_1_1.setBounds(569, 71, 102, 23);
		frame.getContentPane().add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_2 = new JButton("保存新建数据");
		btnNewButton_2_2.setBounds(10, 73, 157, 23);
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                frame.dispose();
	                    TableCellEditor editor = table.getCellEditor();
	                    if (editor != null) {
	                        editor.stopCellEditing();
	                        int rowCount = model.getRowCount();       
			                for (int i = 0; i < rowCount; i++) {
			                	if(!(model.getValueAt(i, 8).equals("工厂设备"))) {
			                    model.setValueAt("关机", i, 6);
			                    model.setValueAt("未被租用", i, 8);
			                	}
			                }
	                        deviceManager.getU().readDataFromJTable(table);
	                    }else {
	                    	new deviceManage();
	                    }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_2);
	}
}
