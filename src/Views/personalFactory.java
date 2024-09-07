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
import Controller.devicePersonalManager;
import Controller.logInJudge;
import Controller.productManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class personalFactory {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private Object[] columnNames = {" ","ID","设备编号","设备名称","设备类别","设备规格","设备状态","设备概述"
			,"租用状态","所属工厂"};
	private int rowCount;
	public personalFactory() {
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
					new personalFactory();
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
		        		devicePersonalManager.getU().deleteData(table,table.getSelectedRow());
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
		                        devicePersonalManager.getU().readDataFromJTable(table);
		                    }else {
		                    	new personalFactory();
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
					new setLogIn();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_1_2);
		DefaultTableModel modeli = new DefaultTableModel();
		modeli.setDataVector(devicePersonalManager.getU().getDeviceManager(),columnNames);
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
		rowCount = table.getRowCount();
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
						devicePersonalManager.getU().changeType(table, table.getSelectedRow());
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
	                        int rowCountNew = model.getRowCount();       
			                for (int i = rowCount; i < rowCountNew; i++) {
			                    model.setValueAt("关机", i, 6);
			                    model.setValueAt("工厂设备", i, 8);
			                    model.setValueAt(logInJudge.getL().getFactoryName(), i, 9);
			                }
	                        devicePersonalManager.getU().readDataFromJTable(table);
	                    }else {
	                    	new personalFactory();
	                    }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_2);	
		JButton btnNewButton_3 = new JButton("租用设备");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	new rentDevice();
		        }
		    }
		});
		btnNewButton_3.setBounds(247, 105, 211, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
