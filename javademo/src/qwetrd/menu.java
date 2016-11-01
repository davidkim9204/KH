//package qwetrd;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//class Design extends JFrame implements ItemListener, ActionListener, MouseListener {
//	JScrollPane scrollPane;
//	ImageIcon icon;
//
//	JButton searchBtn;
//	JTable table;
//	JComboBox<String> locBox;
//	DefaultTableModel model;
//
//	
//	
//	public Design() {
//		searchBtn = new JButton("검색");
//		JPanel jp = new JPanel();
//		jp.add(searchBtn);
//		
//		icon = new ImageIcon("C:\\Users\\user1\\Desktop\\javagraphics\\caffee.png");
//	       
//        //배경 Panel 생성후 컨텐츠페인으로 지정     
//        /////////////////
//        JPanel background = new JPanel() {
//        	@Override
//            public void paintComponent(Graphics g) {
//                g.drawImage(icon.getImage(), 0, 0, null);
//                setOpaque(false); 
//                super.paintComponent(g);
//            }
//        };//이미지 부분
//       ////////////////////////
//       
//       
//        
//		background.add(searchBtn);
//		scrollPane = new JScrollPane(background);
//		setContentPane(scrollPane);
//
//		Object[] obj = { "카페이름", "음료명", "커피가격" };
//		model = new DefaultTableModel(obj, 0) {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
//		table = new JTable(model);
//		table.getTableHeader().setReorderingAllowed(false);
//		table.setRowHeight(20);
//		
//		add(BorderLayout.NORTH, jp);
//		add(BorderLayout.CENTER, new JScrollPane(table));
//
//		searchBtn.addActionListener(this);
//		searchBtn.addMouseListener(this);
//
//		/*
//		 * DefaultComboBoxModel<BeverageDAO> model= new
//		 * DefaultComboBoxModel<BeverageDAO>(); model.addElement();
//		 * 
//		 */
//
//		setSize(1000, 600);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	}
//
//	@Override
//	public void itemStateChanged(ItemEvent arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//}// end class
//
//public class menu {
//
//	public static void main(String[] args) {
//		new Design();
//	
//	}
//
//}
