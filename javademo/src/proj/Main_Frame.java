package proj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



class Main_Frame extends JFrame implements ActionListener {
	MainPanel main;

	public Main_Frame() {
		this.setTitle("Beverage Program");

		main = new MainPanel();

		add("Center", main);

		main.memberJoinB.addActionListener(this);
		main.loginB.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int message = getConfirmMessage("정말로 종료하겠습니까?");
				if (message == 0)
					System.exit(0);
				else
					return;
			}
		});
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(400, 450);
		this.setVisible(true);
	}// end Main_Frame()

	public int getConfirmMessage(String message) {
		JLabel label = new JLabel(message);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0));
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}// end getConfirmMessage()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == main.memberJoinB)
			memberJoin();
		else if (obj == main.loginB)
			login();
	}// end actionPerformed()

	public void memberJoin() {
	}// end memberJoin()

	public void login() {
		MemberDAO dao = MemberDAO.getInstance();
		boolean check = false;
		if (!main.idT.getText().equals("") || !main.passwordT.getText().equals("")) {
			check = dao.getMember(main.idT.getText(), main.passwordT.getText());
			if (check == true) {

			} else {
				JOptionPane.showMessageDialog(this, "아이디 및 비밀번호가 맞지않습니다.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "아이디 및 비밀번호를 입력해주세요.");
		}

	}// end login()

}// end Main_Frame