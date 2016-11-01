package java0808_network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class Java218_ChatHandler implements Runnable {
	Socket socket;
	DataInputStream dataIn;
	DataOutputStream dataOut;
	Thread listener;
	private static Vector<Java218_ChatHandler> handlers = new Vector<Java218_ChatHandler>();
	
	public Java218_ChatHandler(Socket socket){
		this.socket=socket;
		
	
	}//end java
	
	public void start(){
		try {
			dataIn=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dataOut= new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			listener = new Thread(this);//현재 객체가 쓰레드이니깐 한단계 과정이 줄어든다.
			listener.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end start()

	
	//서버와 클라이언트가 있을때 한 클라이언트가 데이터를 보내면 다시 각 클라이언트에게 보내준다.
	//그러기위해서는 전부가 저장되어있다는 것을 배열로 만들어야한다.?
	@Override
	public void run() {
		//vector에 현재 서버에 접속한 클라이언트 정보 저장
		handlers.addElement(this);
		while(!Thread.interrupted()){//예기치 못한 인터럽트가 발생하지 않으면
			try {
				String message = dataIn.readUTF();// 메세지라는 변수에 넣는다.
				broadcast(message);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		
	}//end run()
	
	//현재 서버에 접속된 클라이언트 모두에 메시지를 전송
	public void broadcast(String message){
		synchronized (handlers) {
			Enumeration<Java218_ChatHandler> enu = handlers.elements();
			while(enu.hasMoreElements()){
				Java218_ChatHandler handler = enu.nextElement();
				try {
					handler.dataOut.writeUTF(message);
					handler.dataOut.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}//end broad
	
	
}//end java
