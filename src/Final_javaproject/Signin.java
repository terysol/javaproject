package Final_javaproject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Signin extends JFrame {

	private JPanel signin;
	private JTextField textID;
	private JTextField textPassword;
	
	Color c1 = new Color(70, 130, 180);

	/**
	 * Launch the application.
	 */

		java.sql.Connection conn;
		java.sql.Statement stmt;
		java.sql.ResultSet rs;
	 
	    String url = "jdbc:mysql://127.0.0.1:3306/customer_signup?characterEncoding=UTF-8&serverTimezone=UTC";
	    String dbID="root";
		String dbPW="solmin1129";
		
	    String sql = null;
	    Properties info = null;
	    Connection cnn = null;
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
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
	public Signin() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		signin = new JPanel();
		signin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(signin);
		signin.setLayout(null);
		signin.setBackground(c1);
		
		JLabel lblSignIn = new JLabel("로그인");
		lblSignIn.setFont(new Font("돋움", Font.BOLD, 30));
		lblSignIn.setBounds(153, 47, 109, 35);
		signin.add(lblSignIn);
		
		textID = new JTextField();
		textID.setBounds(130, 139, 255, 35);
		signin.add(textID);
		textID.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(130, 219, 255, 35);
		textPassword.setColumns(10);
		signin.add(textPassword);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.BOLD, 20));
		lblId.setBounds(67, 148, 34, 18);
		signin.add(lblId);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblPassword.setBounds(28, 225, 109, 18);
		signin.add(lblPassword);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idTxt=textID.getText();
				String passwordTxt=textPassword.getText();
				int result;
				
				try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		    		conn=java.sql.DriverManager.getConnection(url,dbID,dbPW);
		    		stmt=conn.createStatement();
		            
		 
		            sql = "select * from signup_infotb";
		            rs = stmt.executeQuery(sql); // 읽어오는거라 다르다 비교해    //리턴타입이 ResultSet
		            
		          
		           while(rs.next()) {
		        	   String id=rs.getString("ID");
			           String password=rs.getString("password");
			           
		        	   if(id.equals(idTxt)==true  && password.equals(passwordTxt)==true) {
		        		   JOptionPane.showMessageDialog(null,"로그인 성공");  break;
		        	   }else if(id.equals(idTxt)==true && password==passwordTxt) {
		        		   JOptionPane.showMessageDialog(null,"로그인 성공");  break;
		        	   }else if(id.equals(idTxt)==false || password.equals(passwordTxt)==false || password!=passwordTxt) {
		        		   JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 틀렸습니다.");  
		        		   Signin p1=new Signin();
		   				   p1.main(null);
		   				   dispose();
		        		   break;
		        	   }
		           }
		           rs.close();
		            stmt.close();
		            conn.close();
		        }catch (Exception ee) {
		            System.out.println("문제있음" + ee.getMessage());
		            
		        }
				main1 m=new main1();
				m.main(null);
				dispose();
			}
		});
		btnLogin.setFont(new Font("돋움", Font.BOLD, 20));
		btnLogin.setBounds(157, 316, 109, 41);
		signin.add(btnLogin);
		
		JButton button = new JButton("←");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseButton cb1=new ChooseButton();
				cb1.main(null);
				dispose();
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 17));
		button.setBounds(0, 0, 55, 27);
		signin.add(button);
	}
}
