package Final_javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class showInfo extends JFrame {
	//JPanel p = new JPanel();
	
	Color c1 = new Color(70, 130, 180);
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JButton btnDfohow;
	private JButton back;
	String list="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showInfo frame = new showInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public showInfo(){
		//setBackground();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(c1);
		
		table_1 = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("날짜");
		model.addColumn("이름");
		model.addColumn("시간");
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"날짜", "이름", "시간"
			}
		));
		table_1.setModel(model);
		table_1.setModel(model);
		
		DBstudyinfo DB=new DBstudyinfo();
		String sql="SELECT * FROM studyinfotb";
		//String sql2="SELECT SEC_TO_TIME(sum(TIME_TO_SEC(time))) FROM test";
		try {
			DB.rs=DB.stmt.executeQuery(sql);
			//DB.rs=DB.stmt.executeQuery(sql2);
			while(DB.rs.next()) {
				model.addRow(new Object [] {
						DB.rs.getString("date"),
						DB.rs.getString("name"),
						DB.rs.getString("time")
				});
			}
			table_1.setModel(model);
		}catch(Exception e) {
			e.printStackTrace();
		}
		table_1.setBounds(27, 97, 573, 291);
		contentPane.add(table_1);
		
		btnDfohow = new JButton("총 공부 시간(1일 기준)");
		btnDfohow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DayStudytime dst=new DayStudytime();
				dst.main(null);
				dispose();
			}
		});
		btnDfohow.setFont(new Font("굴림", Font.BOLD, 17));
		btnDfohow.setBounds(27, 41, 256, 27);
		contentPane.add(btnDfohow);
		
		JButton button = new JButton("평균 공부 시간(7일 기준)");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Weekstudytime wsf=new Weekstudytime();
				wsf.main(null);
				dispose();
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 17));
		button.setBounds(331, 42, 256, 27);
		contentPane.add(button);
		
		back = new JButton("타이머창으로 가기");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Timer(list);
				dispose();
			}
		});
		back.setFont(new Font("굴림", Font.BOLD, 17));
		back.setBounds(206, 428, 192, 27);
		contentPane.add(back);
	}
}
