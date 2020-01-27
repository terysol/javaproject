package Final_javaproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

import javax.swing.*;

public class CheckList2 extends JFrame {
	JPanel p = new JPanel();
	
	Color c1 = new Color(70, 130, 180);

	private Object String;

	private java.lang.String listTxt;
	
	public  CheckList2() {
		p.setLayout(null);
		p.setVisible(true);
		setBackground(Color.white);
		
		p.setBackground(c1);
		
		JLabel plus = new JLabel("추가 할 To Do List를 작성해주세요.");
		plus.setForeground(new Color(255, 255, 255));
		plus.setHorizontalAlignment(SwingConstants.CENTER);
		plus.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 20));
		plus.setBounds(36, 46, 371, 36);
		p.add(plus);
		
		JTextField list = new JTextField();
		list.setFont(new Font("굴림", Font.PLAIN, 20));
		list.setBounds(30, 119, 377, 25);
		p.add(list);
		list.setColumns(10);
		
		
		
		
		//DoTheList의 확인 버튼
		JButton ok = new JButton("확인");
		ok.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		ok.setBackground(new Color(192, 192, 192));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String listTxt=list.getText();
				new Timer(listTxt);
				dispose();
				
			}
		});
		ok.setBounds(441, 119, 70, 27);
		p.add(ok);
		
		add(p);
		
		setSize(560, 233);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}
