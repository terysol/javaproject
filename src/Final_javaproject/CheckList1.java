package Final_javaproject;

//stop누르면 휴식시간을 가질지 공부를 끝낼지 물어보는 클래스
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;

import javax.swing.*;

public class CheckList1 extends JFrame {
	JPanel p = new JPanel();
	
	Color c1 = new Color(70, 130, 180);
	
	public CheckList1() {
		p.setLayout(null);
		p.setVisible(true);
		setBackground(Color.white);
		
		p.setBackground(c1);
		
		JButton bt = new JButton("휴식시간 가지기");
		bt.setBackground(new Color(192, 192, 192));
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CheckList4();  //휴식시간 타이머 진행
				dispose();  //창을 닫아 버린다
			}
		});
		bt.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 18));
		bt.setBounds(74, 58, 275, 37);
		p.add(bt);
		
		JButton end = new JButton("공부 끝내기");
		end.setBackground(new Color(192, 192, 192));
		end.setForeground(new Color(0, 0, 0));
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  //창을 꺼버린다
			}
		});
		end.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 18));
		end.setBounds(74, 143, 275, 37);
		p.add(end);
		
		getContentPane().add(p);
		
		JButton studyinfo = new JButton("내 공부량 보기");
		studyinfo.setBackground(new Color(192,192,192));
		studyinfo.setForeground(new Color(0,0,0));
			studyinfo.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					showInfo info =new showInfo();  //내 하루의 공부시간을 알아본다.
					info.main(null);
					dispose();
					
				}
			
			});
		studyinfo.setFont(new Font("Dialog", Font.BOLD, 18));
		studyinfo.setBounds(74, 226, 275, 37);
		p.add(studyinfo);
		
		setSize(450, 365);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}