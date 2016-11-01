package java0721_exception_stream;

import java.io.IOException;
import java.io.InputStream;

public class Java154_stream {

	public static void main(String[] args) {
		System.out.print("데이터입력");
		
		//콘솔창 목적지에 InputStream으로 연결
		InputStream is=System.in;
		
		try {
			//한바이트를 읽어와 유니코드로 리턴한다.
			int line = is.read(); //throw가 선언되어 있다. oracle java.io패키지에서 확인
			System.out.println(line);
			System.out.println((char)line);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//end main()
}//end class
