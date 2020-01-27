package Final_javaproject;


	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.*;
	import javax.swing.*;

//로그인하면 들어오는 창
	public class Timer extends JFrame {
		JPanel p = new JPanel();
		
		static int milliseconds = 0;
		static int seconds = 0;
		static int minutes = 0;
		static int hours = 0;
		
		static boolean state = true;
		
		Color c1 = new Color(70, 130, 180);
		
		public Timer(String listTxt) {
			p.setVisible(true);
			setBackground(Color.white);
			
			p.setBackground(c1);
			p.setLayout(null);
			
			JLabel hour = new JLabel("00 :");
			hour.setBounds(129, 83, 82, 46);
			hour.setForeground(Color.WHITE);
			hour.setFont(new Font("굴림", Font.PLAIN, 36));
			p.add(hour);
			
			JLabel minute = new JLabel("00 :");
			minute.setBounds(238, 83, 82, 46);
			minute.setForeground(Color.WHITE);
			minute.setFont(new Font("굴림", Font.PLAIN, 36));
			p.add(minute);
			
			JLabel second = new JLabel("00 : ");
			second.setBounds(345, 83, 82, 46);
			second.setForeground(Color.WHITE);
			second.setFont(new Font("굴림", Font.PLAIN, 36));
			p.add(second);
			
			JLabel millisecond = new JLabel("00");
			millisecond.setBounds(452, 87, 92, 46);
			millisecond.setForeground(Color.WHITE);
			millisecond.setFont(new Font("굴림", Font.PLAIN, 24));
			p.add(millisecond);
			
			JButton stop = new JButton("STOP");
			stop.setBounds(438, 174, 112, 46);
			stop.setForeground(new Color(0, 0, 0));
			stop.setBackground(new Color(192, 192, 192));
			stop.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
			stop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					state = false;	  //멈춘다
					
				}
			});
			p.add(stop);
			stop.setBounds(180, 174, 112, 46);
			stop.setForeground(new Color(0, 0, 0));
			stop.setBackground(new Color(192, 192, 192));
			stop.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
			
			JButton start = new JButton("START");
			start.setBounds(44, 174, 112, 46);
			start.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, listTxt +"의 공부를 시작합니다.");  //리스트에 쓴 공부를 한다
					state = true;  //시작한다
					
					
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
				}
			});
			start.setForeground(new Color(0, 0, 0));
			start.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
			start.setBackground(new Color(192, 192, 192));
			p.add(start);
			
			//do the list
			JButton add = new JButton("추가");
			add.setBounds(248, 321, 100, 50);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new CheckList2();
					dispose();
				}
			});
			
			JButton out = new JButton("나가기");  //아예 창을 나간다
			out.setBounds(393, 321, 100, 50);
			out.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});	
			
			JButton select = new JButton("CHOOSE");
			select.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new CheckList1();
					dispose();
				}
			});
			select.setForeground(Color.BLACK);
			select.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
			select.setBackground(Color.LIGHT_GRAY);
			select.setBounds(455, 174, 112, 46);
			p.add(select);
			
			out.setForeground(new Color(0, 0, 0));
			out.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 18));
			out.setBackground(new Color(192, 192, 192));
			p.add(out);
			
			add.setForeground(new Color(0, 0, 0));
			add.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 18));
			add.setBackground(new Color(192, 192, 192));
			p.add(add);
			
			JButton save=new JButton("SAVE");  //시간을 저장한다
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SaveStudy save=new SaveStudy();
					save.main(null);
					dispose();
				}
			});
			save.setBackground(new Color(192, 192, 192));
			save.setFont(new Font("Dialog", Font.PLAIN, 18));
			save.setBounds(322, 175, 112, 46);
			p.add(save);
			
			
			
			JLabel tdl = new JLabel("-----------------------To Do List-----------------------");
			tdl.setBounds(44, 262, 516, 24);
			tdl.setForeground(new Color(255, 255, 255));
			tdl.setHorizontalAlignment(SwingConstants.CENTER);
			tdl.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
			p.add(tdl);

			JButton see = new JButton("보기");
			see.setBounds(109, 321, 100, 50);
			see.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new CheckList3(listTxt);
					dispose();
				}
			});
			see.setForeground(new Color(0, 0, 0));
			see.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 18));
			see.setBackground(new Color(192, 192, 192));
			p.add(see);
			
			getContentPane().add(p);

			setSize(624, 515);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
}
