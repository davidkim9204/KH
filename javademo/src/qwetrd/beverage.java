package qwetrd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Design extends JFrame implements ItemListener, ActionListener, MouseListener {

	JButton searchBtn;
	JTable table;
	JComboBox<String> locBox1, locBox2;
	DefaultTableModel model;

	JScrollPane scrollPane;
	ImageIcon icon, background;

	// public JButton dsfd(String img){
	// 버튼 = 경로/이름;
	//
	//
	// return 버튼;
	// }

	public Design() {

		searchBtn = new JButton("검색");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		// 버튼 부
		// login버튼
		searchBtn = new JButton(new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\finlog.png"));

		searchBtn.setBackground(Color.red);

		searchBtn.setBorderPainted(false);// 버튼 테두리 설정
		searchBtn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		searchBtn.setFocusPainted(false); // 포커스 표시 설정
		searchBtn.setContentAreaFilled(false);

	
	

		background = new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\back.png");

		setLayout(new BorderLayout());
		setContentPane(new JLabel(background));

		Object[] obj = { "카페이름", "음료명", "커피가격" };
		model = new DefaultTableModel(obj, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);

		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		model1.addElement("커피");
		model1.addElement("티");
		model1.addElement("주스");
		model1.addElement("기타");
		locBox1 = new JComboBox<String>(model1);
		jp1.add(new JLabel("음료명: "));
		jp1.add(locBox1);

		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>();
		model2.addElement("2000~3000");
		model2.addElement("3000~4000");
		model2.addElement("4000~5000");
		model2.addElement("5000~6000");
		model2.addElement("6000~7000");
		locBox2 = new JComboBox<String>(model2);
		jp2.add(new JLabel("가격: "));
		jp2.add(locBox2);
		jp2.add(searchBtn);

		locBox1.addItemListener(this);
		locBox2.addItemListener(this);

		add(BorderLayout.NORTH, jp1);
		add(BorderLayout.CENTER, new JScrollPane(table));
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());

		searchBtn.addActionListener(this);
		searchBtn.addMouseListener(this);

		/*
		 * DefaultComboBoxModel<BeverageDAO> model= new
		 * DefaultComboBoxModel<BeverageDAO>(); model.addElement();
		 * 
		 */

		locBox1.addActionListener(this);
		locBox2.addActionListener(this);

		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.getRowCount() != 0) {
			model.setRowCount(0);
		}

		BeverageDAO dao = BeverageDAO.getInstance();

		String s1 = (String) locBox1.getSelectedItem();
		String s2 = (String) locBox2.getSelectedItem();

		// ArrayList<BeverageDTO> arr = dao.searchmethod(s1, s2);
		//
		// for (BeverageDTO dto : arr) {
		// Object[] k = { dto.getCafe_id(), dto.getBeverage_name(),
		// dto.getBeverage_price() };
		// model.addRow(k);
		// }
	}

}// end class

public class beverage {

	public static void main(String[] args) {
		new Design();

	}

}
