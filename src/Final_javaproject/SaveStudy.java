package Final_javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

//내가 걸린 시간과 한 공부를 db에 저장하는 클래스
public class SaveStudy extends JFrame {

	Color c1 = new Color(70, 130, 180);
	private JPanel contentPane;
	private JTextField date;
	private JTextField name;
	private JTextField time;
	private JLabel lblDwk;
	private JLabel lblJguu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveStudy frame = new SaveStudy();
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
	public SaveStudy() {
		
		DBstudy study=new DBstudy();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(c1);
		
		JLabel lblDate = new JLabel("날짜");
		lblDate.setFont(new Font("굴림", Font.BOLD, 20));
		lblDate.setBounds(47, 125, 80, 24);
		contentPane.add(lblDate);
		
		lblDwk = new JLabel("이름");
		lblDwk.setFont(new Font("굴림", Font.BOLD, 20));
		lblDwk.setBounds(42, 204, 62, 18);
		contentPane.add(lblDwk);
		
		lblJguu = new JLabel("걸린시간 (시간:분)");
		lblJguu.setFont(new Font("Dialog", Font.BOLD, 14));
		lblJguu.setBounds(14, 269, 171, 38);
		contentPane.add(lblJguu);
		
		date = new JTextField();
		date.setBounds(141, 120, 288, 38);
		contentPane.add(date);
		date.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(141, 196, 288, 38);
		contentPane.add(name);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(141, 269, 288, 38);
		contentPane.add(time);
		
		JButton btnDkg = new JButton("확인");
		btnDkg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dateTxt=date.getText();
				String nameTxt=name.getText();
				String timeTxt=time.getText();
				
				DBstudy.StudyInfo(dateTxt, nameTxt, timeTxt);
				JOptionPane.showMessageDialog(null,"회원님의 공부 시간이 저장되었습니다."); 
				
				Timer e = new Timer("");
				dispose();
			}
		});
		btnDkg.setBounds(203, 341, 105, 38);
		contentPane.add(btnDkg);
		
		
	}
}
