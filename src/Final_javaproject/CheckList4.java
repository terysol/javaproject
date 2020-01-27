package Final_javaproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
//휴게 시간

public class CheckList4 extends JFrame {
	JPanel p = new JPanel();
	
	static int milliseconds = 0;
	static int seconds = 0;
	static int minutes = 0;
	static int hours = 0;
	
	static boolean state = true;
	
	Color c1 = new Color(70, 130, 180);
	
	public CheckList4() {
		p.setLayout(null);
		p.setVisible(true);
		setBackground(Color.white);
		
		p.setBackground(c1);
		
		JLabel hour = new JLabel("00 :");
		hour.setForeground(new Color(255, 255, 255));
		hour.setFont(new Font("굴림", Font.PLAIN, 36));
		hour.setBounds(33, 84, 82, 46);
		p.add(hour);
		
		JLabel minute = new JLabel("00 :");
		minute.setForeground(new Color(255, 255, 255));
		minute.setFont(new Font("굴림", Font.PLAIN, 36));
		minute.setBounds(142, 84, 82, 46);
		p.add(minute);
		
		JLabel second = new JLabel("00 : ");
		second.setForeground(new Color(255, 255, 255));
		second.setFont(new Font("굴림", Font.PLAIN, 36));
		second.setBounds(251, 84, 82, 46);
		p.add(second);
		
		JLabel millisecond = new JLabel("00");
		millisecond.setForeground(new Color(255, 255, 255));
		millisecond.setFont(new Font("굴림", Font.PLAIN, 24));
		millisecond.setBounds(355, 88, 82, 46);
		p.add(millisecond);
		
		//휴식시간을 멈춘다
		JButton stop = new JButton("STOP");
		stop.setBackground(new Color(192, 192, 192));
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timer ct1 = new Timer("");  //타이머 페이지로 간다
				dispose(); 
			}
		});
		stop.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 18));
		stop.setBounds(166, 150, 105, 37);
		p.add(stop);
		
		state = true;
		Thread t = new Thread() {
			public void run() {
				for(;;) {
					if(state == true) {
						try {
							sleep(1);
							
							if(milliseconds>550) {
								milliseconds = 0;
								seconds++;
							} if(seconds>60) {
								milliseconds = 0;
								seconds = 0;
								minutes++;
							} if(minutes>60) {
								milliseconds = 0;
								seconds = 0;
								minutes = 0;
								hours ++;
							}
							millisecond.setText(" : " + milliseconds);
							milliseconds++;
							
							second.setText(" : " + seconds);
							minute.setText(" : " + minutes);
							hour.setText("" + hours);
						} catch(Exception e) {
							
						}
				   } else {
					   break;
				   } 
				}
			}
		};
		t.start();
		
		add(p);
		
		setSize(469, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
