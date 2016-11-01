package java0805_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

class MenuTest extends JFrame implements ActionListener{
	
	JMenu file, edit;
	JMenuItem fopen, fsave ,fexit, ecopy, epaste;
	JToolBar toolBar;
	JMenuBar menuBar;
	JButton openBtn, saveBtn, helpBtn;
	JTextArea multiArea;
	
	
	public MenuTest(){
		fopen = new JMenuItem("open");
		fsave = new JMenuItem("save");
		fexit = new JMenuItem("exit");
		
		//단축키
		fopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		fsave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		ecopy=new JMenuItem("copy");
		epaste=new JMenuItem("past");
		
		file=new JMenu("File");
		edit=new JMenu("Edit");
		
		//add로 붙여주면 된다.
		
		file.add(fopen); file.add(fsave); file.add(fexit); edit.add(ecopy); edit.add(epaste); 
		
		menuBar=new JMenuBar();
		menuBar.add(file); menuBar.add(edit);
		
		//add와 다르다.
		setJMenuBar(menuBar);
		
		
		
		String path="src/java0805_gui/images/";
		openBtn=new JButton(new ImageIcon(path+"open.gif"));
		saveBtn=new JButton(new ImageIcon(path+"save.gif"));
		helpBtn=new JButton(new ImageIcon(path+"help.gif"));
		
		//풍선말
		openBtn.setToolTipText("열기");
		saveBtn.setToolTipText("저장");
		helpBtn.setToolTipText("도움말");
		
		
		//테두리
		//top,left,bottomm,right
		openBtn.setBorder(new EmptyBorder(0, 5, 0, 5));
		saveBtn.setBorder(new EmptyBorder(0, 5, 0, 5));
		helpBtn.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		
		toolBar=new JToolBar();
		toolBar.add(openBtn);
		toolBar.add(saveBtn);
		toolBar.add(helpBtn);
		
		multiArea=new JTextArea();
		
		
		add(BorderLayout.NORTH, toolBar);
		add(BorderLayout.CENTER, multiArea);
		
		fsave.addActionListener(this);
		fopen.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
		
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생된 객체 리턴
		Object obj=e.getSource();
		
		if(obj==fopen || obj==openBtn){
			JFileChooser jc=new JFileChooser(new File("C:\\")); //합쳐서 위로 빼도된다. //열기 지점을 바꾼다. 이 항목에서.
			int chk=jc.showOpenDialog(this);
			if(chk==JFileChooser.APPROVE_OPTION){
				File file =jc.getSelectedFile();
				Scanner sc=null;
				try {
				 sc = new Scanner(file);
				 multiArea.setText("");
				 while(sc.hasNextLine()){
					 multiArea.append(sc.nextLine()+"\r\n");
				 }
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					sc.close();
				}
				
				
			}
		}else if(obj==fsave || obj==saveBtn){
			JFileChooser jc=new JFileChooser();
			int chk=jc.showSaveDialog(this);//여기까지가 gui 밑으로는 입출력
			if(chk==JFileChooser.APPROVE_OPTION){
				File file=jc.getSelectedFile();
				FileWriter fr=null; //finally영역에서 사용해야하기때문에 fr을
				try {
					fr = new FileWriter(file);
					fr.write(multiArea.getText()); //write하면 버퍼에 써진다. 이것을 해당에 있는 목적지에 보내려면  flush해야한다.
					fr.flush();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						fr.close(); //db에 접속을 막기 위해서
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		}
		
		// TODO Auto-generated method stub
		
	}
	
	
}//end class

public class Java211_gui {

	public static void main(String[] args) {
		new MenuTest();
	}//end main()
}//end class
