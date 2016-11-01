package java0721_exception_stream;

import java.io.IOException;
import java.io.InputStream;

/*
 * read+
 * 
 * 엔터하게 되면
 * carriage return : 줄의 처음으로 이동 (13)
 * line feed : 다음줄로 이동(10)
 * 
 */


public class Java155_stream {

	public static void main(String[] args) {
		InputStream is=System.in;
		System.out.print("이름:");
		int data;
		
		try {
			while((data=is.read())!= 10){
				//System.out.println(data);
				System.out.println((char)data);
				
			}
			//is.close();  이유 쳐 조느라 못들음.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}//end main()
	
}//end class
