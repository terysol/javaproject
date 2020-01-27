package Final_javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class Weekstudytime extends JFrame {

	private JPanel contentPane;
	Color c1 = new Color(70, 130, 180);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Weekstudytime frame = new Weekstudytime();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Weekstudytime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(c1);
		contentPane.setLayout(null);
		
		JTable table = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("날짜");
		model.addColumn("7일 기준 공부량");
		DBstudyinfo DB=new DBstudyinfo();
		String sql="SELECT TIME_FORMAT(SEC_TO_TIME(sum(TIME_TO_SEC(time))/7), '%H시간 %i분') AS '평균시간(7일기준)' FROM studyinfotb";
		//String sql2="SELECT SEC_TO_TIME(sum(TIME_TO_SEC(time))) FROM test";
		try {
			DB.rs=DB.stmt.executeQuery(sql);
			//DB.rs=DB.stmt.executeQuery(sql2);
			while(DB.rs.next()) {
				model.addRow(new Object [] {
						DB.rs.getString("평균시간(7일기준)")
				});
			}
			table.setModel(model);
		}catch(Exception e) {
			e.printStackTrace();
		}
		table.setBounds(43, 102, 477, 210);
		contentPane.add(table);
		
		JButton button = new JButton("확인");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInfo info=new showInfo();
				showInfo.main(null);
				dispose();
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 18));
		button.setBounds(234, 342, 105, 40);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("7일 기준 공부량");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(178, 39, 222, 30);
		contentPane.add(lblNewLabel);
	}
}
