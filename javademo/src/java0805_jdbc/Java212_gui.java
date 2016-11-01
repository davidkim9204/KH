package java0805_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class DesignTest extends JFrame implements ActionListener {
	JTextField inputTxt;
	JButton searchBtn;
	JTable table;
	DefaultTableModel model;

	public DesignTest() {
		inputTxt = new JTextField(20);
		searchBtn = new JButton("검색");

		JPanel jp = new JPanel(); // 프로젝트시에는 따로 먼저 선언하는 것이 좋다. 지금까지는 직관적으로 보여주려고
									// 그런것이다.
		jp.add(inputTxt);
		jp.add(searchBtn);

		// 테이블 헤드
		Object[] obj = { "사원번호", "사원명", "급여", "부서번호" };
		model = new DefaultTableModel(obj, 10) {
			
			
			//셀 편집 불가능
			
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false; //셀편집을 막기위해서
			}
		};

		table = new JTable(model);

		// 컬럼이동 불가능
		table.getTableHeader().setReorderingAllowed(false);
		// 라인의 높이
		table.setRowHeight(20);

		add(BorderLayout.NORTH, jp);
		add(BorderLayout.CENTER, new JScrollPane(table));
		
		//이벤트 리스너 연결
		searchBtn.addActionListener(this);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end DeisignTest()

	@Override
	public void actionPerformed(ActionEvent e) {
		//add row는 obj배열 또는 벡터로.
		model.add( )
		
		// TODO Auto-generated method stub
		
	}

}

public class Java212_gui {

	public static void main(String[] args) {
		new DesignTest();
	}
}
