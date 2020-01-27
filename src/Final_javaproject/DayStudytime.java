package Final_javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


//하루에 한 공부의 시간을 한눈에 보여준다.
public class DayStudytime extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	Color c1 = new Color(70, 130, 180);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DayStudytime frame = new DayStudytime();
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
	public DayStudytime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(c1);
		
		table = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("날짜");
		model.addColumn("총합시간(1일기준)");
		DBstudyinfo DB=new DBstudyinfo();
		String sql="SELECT date AS '날짜',TIME_FORMAT(SEC_TO_TIME(sum(TIME_TO_SEC(time))),'%H시간 %i분' )AS '총합시간(1일기준)' \r\n" + 
				" FROM studyinfotb GROUP BY date";
		//String sql2="SELECT SEC_TO_TIME(sum(TIME_TO_SEC(time))) FROM test";
		try {
			DB.rs=DB.stmt.executeQuery(sql);
			//DB.rs=DB.stmt.executeQuery(sql2);
			while(DB.rs.next()) {
				model.addRow(new Object [] {
						DB.rs.getString("날짜"),
						DB.rs.getString("총합시간(1일기준)")
				});
			}
			table.setModel(model);
		}catch(Exception e) {
			e.printStackTrace();
		}
		table.setBounds(49, 119, 477, 185);
		contentPane.add(table);
		
		
		/*DefaultTableModel model_1=new DefaultTableModel();
		model.addColumn("날짜");
		model.addColumn("총합시간(1일기준)");
		DBstudyinfo_1 DB_1=new DBstudyinfo_1();
		String sql_1="SELECT DATE_1 AS '날짜',TIME_FORMAT(SEC_TO_TIME(sum(TIME_TO_SEC(time_1))),'%H시간 %i분' )AS '총합시간(1일기준)' FROM studyinfotb_1";
		//String sql2="SELECT SEC_TO_TIME(sum(TIME_TO_SEC(time))) FROM test";
		try {
			DB_1.rs=DB_1.stmt.executeQuery(sql_1);
			//DB.rs=DB.stmt.executeQuery(sql2);
			while(DB_1.rs.next()) {
				model.addRow(new Object [] {
						DB_1.rs.getString("날짜"),
						DB_1.rs.getString("총합시간(1일기준)")
				});
			}
			table.setModel(model);*/
		
			JLabel lblDwf = new JLabel("하루에 한 공부량");
			lblDwf.setFont(new Font("굴림", Font.BOLD, 25));
			lblDwf.setBounds(176, 48, 231, 40);
			contentPane.add(lblDwf);
			
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
		//}catch(Exception e) {
			//e.printStackTrace();
		//}
	}
}
