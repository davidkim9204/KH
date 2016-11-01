package java0721_exception_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Java156_stream {

	public static void main(String[] args) {
		//바이트 스트림 //콘솔창은 바이트밖에안되서  바이트와 문자 스트림을 바로 연결안되서
		InputStream is=System.in; //스트림과 콘솔창을 연결한다.
		
		
		//직접 연결을 못해서 
		//바이트 스트림과 문자 스트림 연결
		InputStreamReader ir=new InputStreamReader(is);
		
		//문자스트림
		BufferedReader br=new BufferedReader(ir);
		
		//String line="";
		
		int x=0;
		int y=0;
		try{
			System.out.print("x:"); //스트링값을 인트값으로 바꿔서 처리 jdk5.0부터는 이런 작업을 하는 것이 있는데 그것이 바로scanner라는 class이다.
			x= Integer.parseInt(br.readLine()); //한 라인으로 읽어들이지 않으면 반복해서 하던지 한자리만 해야하기때문에
			System.out.print("y:");
			y=Integer.parseInt(br.readLine()); //
			System.out.printf("x+y=%d\n",x+y);
		
//			line=br.readLine();
//			System.out.println(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try {
				br.close(); //스트림 연결을 끊어준다. 안전하게 자원들이 반납이 될 수 있도록 close해주는 것이 좋다.
				ir.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}//end main()

}//end class
