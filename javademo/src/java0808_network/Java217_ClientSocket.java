package java0808_network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Java217_ClientSocket {

	public static void main(String[] args) {
		//클라이언트가 서버에 접속해야 하기 때문에
		
		try {
			Socket socket = new Socket("127.0.0.1", 7777);
			
			OutputStream os =socket.getOutputStream();
			OutputStreamWriter ow = new OutputStreamWriter(os);
			ow.write("정보요청");
			ow.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//end main()
}//end class
