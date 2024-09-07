package Views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import Controller.JCheckBoxEditor;
import Controller.JCheckBoxRenderer;
import Controller.userManager;
import Controller.userManagerData;
import Controller.userModel;
import Model.User;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class userManage {
	
	private JFrame frame;
	private Object[] columnNames = {"  ","ID","用户名","真实姓名","联系方式","用户类型"};
	private JTextField textField;
	private JTable table;
	private ButtonGroup buttonGroup;
	public userManage() throws IOException {
		initialize();
	}


	@SuppressWarnings("serial")
	public void initialize() throws IOException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 11, 264, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("用户姓名查找");
		btnNewButton.setBounds(299, 11, 103, 40);
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		DefaultTableModel model = new DefaultTableModel(userManager.getUserManager().getUserManagerData(textField.getText()),columnNames);
		        		table.setModel(model);
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setBounds(412, 11, 89, 40);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	try {
						new userManage();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_1);
		

		
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBounds(454, 62, 89, 29);
		btnNewButton_2.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		frame.dispose();
		        		DefaultTableModel model = new DefaultTableModel(userManagerData.getU().getUserManagerData(),columnNames);
		        		model.removeRow(table.getSelectedRow());
		        		userManager.getUserManager().deleteData(table,table.getSelectedRow());
		        		table.setModel(model);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("修改");
		btnNewButton_2_1.setBounds(561, 62, 89, 29);
		btnNewButton_2_1.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	try {
		        		frame.dispose();
		        		TableCellEditor editor = table.getCellEditor();
	                    if (editor != null) {
	                        editor.stopCellEditing();
						    userManager.getUserManager().readDataFromJTable(table);
	                    }else {
	                    	new userManage();
	                    }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("返回");
		btnNewButton_3.setBounds(585, 341, 89, 33);
		btnNewButton_3.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	new menu();
		        }
		    }
		});
		frame.getContentPane().add(btnNewButton_3);
		
	
		table = new JTable(userManagerData.getU().getUserManagerData(),columnNames) {
			public boolean isCellEditable(int row,int column){  
				   if(column == 2||column == 4){  
				       return true;  
				   }else{  
				       return false;  
				   }  
				} 
		};
		table.setSurrendersFocusOnKeystroke(true);
        JScrollPane scrollPane1 = new JScrollPane(table);
        scrollPane1.setSize(628, 234);
        scrollPane1.setLocation(22, 102);
		frame.getContentPane().add(scrollPane1);
		frame.setVisible(true);
	}
}


//table.getColumnModel().getColumn(0).setCellRenderer(new RadioButtonRenderer());
//table.getColumnModel().getColumn(0).setCellEditor(new RadioButtonEditor(new JCheckBox()));
//buttonGroup = new ButtonGroup();

/*       // 添加状态（选中/未选中）变更监听器
table.getModel().addTableModelListener((TableModelListener) new TableModelListener() {
    public void tableChanged1(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) {
            int row = e.getFirstRow();
            Boolean selected = ((Boolean) table.getValueAt(row, 0)).booleanValue();

            for (int i = 1; i <table.getColumnCount(); i++) {
                table.setValueAt(selected, row, i);
            }
        }
    }

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
});
*/

/*
class RadioButtonRenderer implements TableCellRenderer {
    private JPanel panel;
    private JRadioButton radioButton;
    private ButtonGroup buttonGroup;

    public RadioButtonRenderer() {
        panel = new JPanel();
        radioButton = new JRadioButton();
        panel.setLayout(new BorderLayout());
        panel.add(radioButton, BorderLayout.CENTER);
        radioButton.setHorizontalAlignment(JRadioButton.CENTER);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        radioButton.setSelected(((Boolean) value).booleanValue());
        buttonGroup.add(radioButton);
        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return panel;
    }
}

class RadioButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    private JRadioButton radioButton;
    private ButtonGroup buttonGroup;

    public RadioButtonEditor(JCheckBox checkBox) {
        panel = new JPanel();
        radioButton = new JRadioButton();
        panel.setLayout(new BorderLayout());
        panel.add(radioButton, BorderLayout.CENTER);
        radioButton.setHorizontalAlignment(JRadioButton.CENTER);

        // 添加ItemListener以处理编辑器组件的值更改事件
        radioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        buttonGroup.add(radioButton);
        radioButton.setSelected(((Boolean) value).booleanValue());
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return Boolean.valueOf(radioButton.isSelected());
    }
}
*/