package Final_javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

//맨처음 회원가입과 로그인 중 무엇을 할 건지 물어보는 창
public class ChooseButton extends JFrame {

	private JPanel firstpage;
	Color c1 = new Color(70, 130, 180);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseButton frame = new ChooseButton();
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
	public ChooseButton() {
		setTitle("회원가입&로그인 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		firstpage = new JPanel();
		firstpage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(firstpage);
		firstpage.setLayout(null);
		firstpage.setBackground(c1);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup P1=new Signup();
				P1.main(null);
				dispose();
			}
		});
		
		btnSignUp.setFont(new Font("돋움", Font.PLAIN, 25));
		btnSignUp.setBounds(230, 147, 159, 74);
		firstpage.add(btnSignUp);
		
		JButton btnSignIn = new JButton("로그인");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signin p1=new Signin();
				p1.main(null);
				dispose();
			}
		});
		btnSignIn.setFont(new Font("돋움", Font.PLAIN, 25));
		btnSignIn.setBounds(40, 147, 140, 74);
		firstpage.add(btnSignIn);
		
		JLabel lblChoosesignIn = new JLabel("회원가입과 로그인 중 골라주세요");
		lblChoosesignIn.setFont(new Font("돋움", Font.BOLD, 25));
		lblChoosesignIn.setBounds(24, 30, 394, 33);
		firstpage.add(lblChoosesignIn);
		
		
	}

}

