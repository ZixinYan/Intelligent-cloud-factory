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
import Controller.productManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rentDevice {

	private JFrame frame;
	private JTable table;
	private Object[] columnNames = {" ","ID","设备编号","设备名称","设备类别","设备规格","设备状态","设备概述"
			,"租用状态","所属工厂"};
	public rentDevice() {
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
		
		JButton btnNewButton_2_1_1 = new JButton("确认");
		btnNewButton_2_1_1.setBounds(40, 331, 102, 23);
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	try {
		        		frame.dispose();
						devicePersonalManager.getU().rentDevice(table, table.getSelectedRow());
					} catch (IOException e) {
						// TODO Auto-generated catch block
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
					new personalFactory();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_1_2);
		DefaultTableModel modeli = new DefaultTableModel();
		int o =0;
		modeli.setDataVector(devicePersonalManager.getU().getDeviceManager(o),columnNames);
		table = new JTable(modeli) {
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
		scrollPane.setBounds(40, 57, 643, 249);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
		scrollPane.setViewportView(table);
	}
}
