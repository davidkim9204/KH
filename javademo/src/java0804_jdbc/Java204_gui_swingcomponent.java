package java0804_jdbc;

import java.awt.BorderLayout;


//action은 그대로 쓰고
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * awt에서 제공된 컴포넌트를 swing으로 상속받아 사용할때: Button -> JButton
 * swing에서 제공된 컴포넌트들은 자바에서 구현된 클래스이고
 * awt에서 제공된 컴포넌트는 현재 실행중인 운영체제의 컴포넌트를 참조한다.
 */


class SwingComponent extends JFrame implements ActionListener { //j붙이고 컨트럴 스페이서
	JTextField inputTxt;
	JButton runBtn;
	JTextArea multiArea;

	public SwingComponent() {
		runBtn=new JButton("Run");
		inputTxt=new JTextField(2);
		multiArea=new JTextArea();
		//항상 이것들을 먼저 작업해야 한다.
		//보이지 않을 수 있다. 붙이고 나서 작업.
		//패널을 만들어서 붙이면 1개를 붙인것처럼 인식한다.
		JPanel p=new JPanel(); //FloewLayout(왼쪽-> 오른쪽)
		p.add(inputTxt);
		p.add(runBtn);
		
		this.add(p, BorderLayout.EAST);
		this.add(multiArea, BorderLayout.CENTER);
		
		runBtn.addActionListener(this);
		inputTxt.addActionListener(this);
		
		
		
		setSize(500, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {  //클래스가 상속을 많이 받아서 this라고 하면 상속받은 것도 자기 것이라서 헷갈리낟.
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}

		});
	}// end InputWin()

	@Override
	public void actionPerformed(ActionEvent event) {
		String mess = inputTxt.getText();
		//textfield에서 입력한 데이터를 textarea에 추가
		multiArea.append(mess+"\n");
		//textfield를 초기화한다.
		inputTxt.setText("");
		//TextField로 포커스를 이동
		inputTxt.requestFocus();
		//지금까진 awt로 썻고 요즘은 swing을 써서 다 봐꿔야한다.
		
		
		
		// TODO Auto-generated method stub
		
	}

}// end class

public class Java204_gui_swingcomponent {

	public static void main(String[] args) {
		new SwingComponent();
		
		
	}//end main()
}//end class
