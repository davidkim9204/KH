package java0808_network;

import java.net.ServerSocket;
import java.net.Socket;

public class Java218_ChatServer {

	public static void main(String[] args) throws Exception{
		ServerSocket server= new ServerSocket(7777);
		
		while (true){
			//클라이언트 대기상태
			Socket client = server.accept();
			//클라이언트작업을 받으면 다뤄야하는데 이것을 handler에 서 대룬다.
			Java218_ChatHandler handler = new Java218_ChatHandler(client);
			System.out.println("client가"+
			client.getInetAddress().getHostAddress()+"으로 접속하셨습니다.");
			
			handler.start();
			
		}
		
		
		
		//서버는 클라이언트가 언제 접속할지 모르기때문에 대기 하고 있어야한다.
		//서버는 여러개의 클라이언트를 받는다.
		//한번만 대기상태인게 아니라 계속 대기상태이어야한다.
		//언제 올지 모르고 여러명을 받아야하기 때문에
		//무한루프를 돌려서 클라이언트 정보를 받아야한다.
		
		
		
	}//end main()
}//end class


//http://justinkwony.github.io/ermaster-nhit/update-site/
