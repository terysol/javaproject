package Final_javaproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

import javax.swing.*;
//리스트 쓰기 
public class CheckList3 extends JFrame {
	JPanel p = new JPanel();
	
	Color c1 = new Color(70, 130, 180);
	
	private String[] list;
	private int numberOfStrings;
	private static final int DEFAULT_INITIAL_CAPACITY = 25;
	
	/*public void add(String task) {
		ensureCapacity();
		list[numberOfStrings] = task; //할당
		numberOfStrings++; 
	}
	
	  public void ensureCapacity() {
	    	if(numberOfStrings == list.length)
	    		list = Arrays.copyOf(list, 1 + list.length);    
	  }
	  public void display() {
	     for(int index=0; index< numberOfStrings; index++) {
	       System.out.println(index + 1 + ". " + list[index]); 
	     }
	     
	      System.out.println();
	   }*/

	    
	public CheckList3(String list) {
		p.setLayout(null);
		p.setVisible(true);
		setBackground(Color.white);
		
		p.setBackground(c1);
		

		JButton tdl = new JButton(list);
		tdl.setBackground(new Color(70, 130, 180));
		tdl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Timer(list);
				dispose();
			}
		});
//		tdl.add(list);
//		tdl.display();
		tdl.setHorizontalAlignment(SwingConstants.LEFT);
		tdl.setForeground(new Color(255, 255, 255));
		tdl.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 23));
		tdl.setBounds(32, 72, 245, 24);
		p.add(tdl);
		
		JButton bt = new JButton("나가기");  //추가한 리스트를 쓰고 나간다
		bt.setBackground(new Color(192, 192, 192));
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Timer(list);  //타이머 창으로 돌아온다.
				dispose();
			}
		});
		bt.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		bt.setBounds(335, 217, 83, 24);
		p.add(bt);
		
		
		
		getContentPane().add(p);
		
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
}