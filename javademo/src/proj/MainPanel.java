package proj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MainPanel extends JPanel {
	JLabel id, password;
	JTextField idT, passwordT;
	JButton memberJoinB, loginB, regiB;
	
	ImageIcon btn1, btn2, btn3, background;
	JScrollPane scrollPane;

	public MainPanel() {
		id = new JLabel(new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\finlog.png"));
		password = new JLabel(new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\finlog.png"));

		Font font = new Font("sanSerif", 0, 13);

		id.setFont(font);
		password.setFont(font);

		idT = new JTextField(20);
		passwordT = new JTextField(20);

//		memberJoinB = new JButton("회원가입");

		//버튼 부
		//login버튼
		loginB = new JButton(new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\finlog.png"));

		loginB.setBackground(Color.red);

		loginB.setBorderPainted(false);// 버튼 테두리 설정
		loginB.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		loginB.setFocusPainted(false); // 포커스 표시 설정
		loginB.setContentAreaFilled(false);
		
		//register버튼
		memberJoinB = new JButton(new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\regis.png"));

		memberJoinB.setBackground(Color.red);

		memberJoinB.setBorderPainted(false);// 버튼 테두리 설정
		memberJoinB.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		memberJoinB.setFocusPainted(false); // 포커스 표시 설정
		memberJoinB.setContentAreaFilled(false);
		
		
		

		//배경부
		background = new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\coffee.png");

		setLayout(new BorderLayout());
//		setContentPane(new JLabel(background));
	
		
		
		memberJoinB.setFont(font);
		loginB.setFont(font);

		JPanel labelP = new JPanel(new GridLayout(2, 1));
		labelP.add(id);
		labelP.add(password);

		JPanel idText = new JPanel(new FlowLayout(FlowLayout.CENTER));
		idText.add(idT);

		JPanel passwordText = new JPanel(new FlowLayout(FlowLayout.CENTER));
		passwordText.add(passwordT);

		JPanel top = new JPanel(new GridLayout(2, 1));
		top.add(idText);
		top.add(passwordText);

		JPanel north = new JPanel(new BorderLayout());
		north.setBorder(new TitledBorder("로그인"));
		north.add("West", labelP);
		north.add("Center", top);

		JPanel buttonP = new JPanel();
		buttonP.add(memberJoinB);
		buttonP.add(loginB);

		JPanel up = new JPanel(new BorderLayout(0, 5));
		up.add("Center", north);
		up.add("South", buttonP);

		JPanel center = new JPanel(new BorderLayout(0, 5));
		center.add("North", up);

		setLayout(new BorderLayout());
		add("Center", center);
		add("East", new JLabel("  "));
		add("West", new JLabel("  "));
		add("South", new JLabel("  "));
		add("North", new JLabel("  "));

	}// end MainPanel()
}// end class
