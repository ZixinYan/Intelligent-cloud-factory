package Views;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registerError {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public registerError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Serif", Font.PLAIN, 30));
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 693, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(new Color(255, 0, 0));
		textPane.setFont(new Font("SimHei", Font.PLAIN, 45));
		textPane.setText("错误");
		textPane.setBackground(frame.getBackground());
		textPane.setBounds(277, 11, 111, 65);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("检查：");
		textPane_1.setForeground(Color.RED);
		textPane_1.setFont(new Font("SimHei", Font.PLAIN, 30));
		textPane_1.setEditable(false);
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setBounds(33, 83, 146, 55);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setText("1.有必要信息没有填写");
		textPane_1_1.setForeground(new Color(255, 0, 0));
		textPane_1_1.setFont(new Font("SimHei", Font.PLAIN, 30));
		textPane_1_1.setEditable(false);
		textPane_1_1.setBackground(SystemColor.menu);
		textPane_1_1.setBounds(75, 149, 492, 55);
		frame.getContentPane().add(textPane_1_1);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setText("2.账户类型只能选择一种");
		textPane_1_1_1.setForeground(new Color(255, 0, 0));
		textPane_1_1_1.setFont(new Font("SimHei", Font.PLAIN, 30));
		textPane_1_1_1.setEditable(false);
		textPane_1_1_1.setBackground(SystemColor.menu);
		textPane_1_1_1.setBounds(75, 215, 492, 55);
		frame.getContentPane().add(textPane_1_1_1);
		
		JTextPane textPane_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1.setText("3.已经有重复账户在库中");
		textPane_1_1_1_1.setForeground(Color.RED);
		textPane_1_1_1_1.setFont(new Font("SimHei", Font.PLAIN, 30));
		textPane_1_1_1_1.setEditable(false);
		textPane_1_1_1_1.setBackground(SystemColor.menu);
		textPane_1_1_1_1.setBounds(75, 281, 492, 55);
		frame.getContentPane().add(textPane_1_1_1_1);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1) {
		        	frame.dispose();
		        	new register();
		            
		        }
		    }
		});
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 35));
		btnNewButton.setBounds(263, 347, 146, 50);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);

	}
}
