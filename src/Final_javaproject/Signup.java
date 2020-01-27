package Final_javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTabbedPane;
 //회원가입
public class Signup extends JFrame {

	private JPanel contentPane_1;
	private JLabel password;
	private JLabel lblOneMoreTime;
	private JTextField textPassword;
	private JTextField textID;
	private JTextField textPassword2;
	private JTextField textname;
	private JLabel lblName;
	private JButton button;
	private JButton btnDwfwfe;
	Color c1 = new Color(70, 130, 180);

	/**
	 * Launch the application.
	 */
	public static void main (String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		DBsignup customor=new DBsignup();
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 485);
		contentPane_1=new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		contentPane_1.setBackground(c1);
		
		
		textID = new JTextField();
		textID.setFont(new Font("Arial", Font.PLAIN, 17));
		textID.setBounds(182, 100, 260, 35);
		contentPane_1.add(textID);
		textID.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Arial", Font.PLAIN, 17));
		textPassword.setBounds(182, 156, 260, 35);
		contentPane_1.add(textPassword);
		textPassword.setColumns(10);
		
		textPassword2 = new JPasswordField();
		textPassword2.setFont(new Font("Arial", Font.PLAIN, 17));
		textPassword2.setBounds(182, 238, 260, 35);
		contentPane_1.add(textPassword2);
		textPassword2.setColumns(10);
		
		password = new JLabel("password");
		password.setBounds(28, 163, 98, 18);
		contentPane_1.add(password);
		password.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel password2 = new JLabel("password");
		password2.setBounds(28, 245, 98, 18);
		contentPane_1.add(password2);
		password2.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel id = new JLabel("ID");
		id.setBounds(63, 107, 26, 18);
		contentPane_1.add(id);
		id.setFont(new Font("Arial", Font.BOLD, 20));
		
		lblOneMoreTime = new JLabel("한 번 다시 쳐주세요");
		lblOneMoreTime.setBounds(184, 216, 153, 18);
		contentPane_1.add(lblOneMoreTime);
		lblOneMoreTime.setFont(new Font("돋움", Font.PLAIN, 14));
		
		JLabel lblSignUp = new JLabel("회원가입");
		lblSignUp.setBounds(195, 35, 210, 40);
		contentPane_1.add(lblSignUp);
		lblSignUp.setFont(new Font("돋움", Font.BOLD, 40));
		
		button = new JButton("←");
		button.setBounds(0, 0, 57, 27);
		contentPane_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseButton cb1=new ChooseButton();
				cb1.main(null);
				setVisible(false);
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 17));
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//boolean temp=textPassword.equals(textPassword2);
				String idTxt=textID.getText();
				String passwordTxt2=textPassword2.getText();
				String passwordTxt=textPassword.getText();
				String nameTxt=textname.getText();
				
				if(passwordTxt.equals(passwordTxt2)) {
					DBsignup.createCustomer(idTxt, passwordTxt, nameTxt);
					JOptionPane.showMessageDialog(null,"회원가입 되었습니다. 로그인 해주세요.");
					
					Signin signin=new Signin();
					signin.main(null);
					setVisible(false);
				}else if(passwordTxt!=passwordTxt2) {
					JOptionPane.showMessageDialog(null,"입력하신 비밀번호가 일치하지 않습니다. 다시 한번 확인 해주시길 바랍니다.");
					Signup P1=new Signup();
					P1.main(null);
					setVisible(false);
				}
			}
		});
		
		btnNewButton.setBounds(236, 367, 117, 39);
		contentPane_1.add(btnNewButton);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("돋움", Font.BOLD, 20));
		
		textname = new JTextField();
		textname.setFont(new Font("굴림", Font.PLAIN, 17));
		textname.setBounds(182, 294, 260, 35);
		contentPane_1.add(textname);
		textname.setColumns(10);
		
		lblName = new JLabel("name");
		lblName.setFont(new Font("Arial", Font.BOLD, 20));
		lblName.setBounds(56, 301, 62, 18);
		contentPane_1.add(lblName);
		
		btnDwfwfe = new JButton("아이디 중복 확인");
		btnDwfwfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idTxt=textID.getText();
				int dowhilenum=0;
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/customer_signup?characterEncoding=UTF-8&serverTimezone=UTC";
					Connection con = DriverManager.getConnection(url, "root", "solmin1129");
					
				
					do {
						
						String sql = "SELECT Count(*) FROM signup_infotb where ID = " + "\'"+idTxt+"\'";
						java.sql.Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(sql);
						rs.last();
						//rs.beforeFirst();
						int rowcnt = rs.getInt(1);
						
						if(rowcnt == 0){//값이 없으면
							dowhilenum = 1;//while문을 빠져나오고
							st.close();//mysql문을 닫는다
							JOptionPane.showMessageDialog(null,"사용가능한 아이디입니다."); break;
							
						}else if(rowcnt!=0){//rs에 값이 하나라도 있으면
							JOptionPane.showMessageDialog(null,"중복된 아이디 입니다. 다시 입력해주세요"); break;
							/*Signup P1=new Signup();
							P1.main(null);
							dispose();*/
						}
					} while(dowhilenum == 0);//다시 while문을 돌린다
				}catch(Exception e1) {
					System.out.println("Got an exception!");
					System.out.println(e1.getMessage());
				}
			}
		});
		btnDwfwfe.setFont(new Font("굴림", Font.BOLD, 12));
		btnDwfwfe.setBounds(457, 103, 140, 30);
		contentPane_1.add(btnDwfwfe);
	}
}
