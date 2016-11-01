package java0808_network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Java218_ChatClient implements Runnable, ActionListener,WindowListener{

	private String host;
	private int port;

	private String userName;
	private JFrame frm;
	private JPanel pan;
	private JTextArea taOutput;
	private JLabel lbName;
	private JTextField  tfInput;
	
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private Thread listener;
		
	public Java218_ChatClient(String host, int port){
		
		System.out.println("사용자 이름을 입력하세요 : ");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader out = new BufferedReader(in);
		
		try{
			userName = out.readLine();
		} catch(IOException e){
			userName = "guest";
		}
		this.host = host;
		this.port = port;
		initComponent(); //대화창을 띄워주기 위해서
		
	}//end Java218
	
	private void initComponent() { 
		frm = new JFrame("채팅 프로그램 [" + host + ":" + port + "]");
		
		taOutput = new JTextArea();
		taOutput.setEditable(false);
		
		tfInput = new JTextField(10);
		pan = new JPanel();
		lbName = new JLabel("입력 :");
		frm.add("Center", new JScrollPane(taOutput));
		frm.add("South", pan);
		
		pan.setLayout(new BorderLayout());
		pan.add(lbName, BorderLayout.WEST);
		pan.add(tfInput, BorderLayout.CENTER);
		frm.setSize(300,400);
		frm.setVisible(true);
		
//		frm.addWindowListener(this);
		tfInput.addActionListener(this);
	}
	
	
	
	public String getUserName() {
		return this.userName;
	}
	
	
	//서버 연결 및 입출력 스트림 연결
	public void start(){  //서버와 연결하는 작업
		if(listener==null){ //한번만 연결하려고 
		try {
			Socket socket = new Socket(host, port); //서버 연결
			dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //데이터 주고받기 위해 스트림 연결
			dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listener= new Thread(this); //따로 돌아가야해서 쓰레드로 돌아가야한다.
		listener.start();
		frm.setVisible(true);
		}
	}//end start()
	
	
	public static void main(String[] args) {
		
		Java218_ChatClient client = new Java218_ChatClient("192.168.10.119", 7777);
		//호스트와 포트버노를 넘겨준다.
		
		
	}//end main()

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("메시지 수신 대기중\n");
		while(!Thread.interrupted()){
			try {
				String line=dataIn.readUTF();
				taOutput.append(line+"\n");
				System.out.println("server>"+line+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//end run()
	
	synchronized public void stop(){
		if(listener!=null){
			listener.interrupt();
			listener=null;
			try {
				dataOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frm.setVisible(false);
			frm.dispose();
			System.exit(0);//안전하게 하기 위해서 한것뿐이다.
			
		}
	}//end stop()

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String message=e.getActionCommand();
		try {
			dataOut.writeUTF(getUserName()+":"+message);
			dataOut.flush();
			tfInput.setText("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		tfInput.setText("");
		
	}//end actionPerformed()

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		stop();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}//end class
