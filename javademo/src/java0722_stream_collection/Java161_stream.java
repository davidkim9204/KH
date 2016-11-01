package java0722_stream_collection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Java161_stream {
	public static void main(String[] args) {
		FileReader fr=null;
		LineNumberReader nr=null;
		try {
			fr=new FileReader("./src/java0722_stream_collection/score.txt");
			//라인번호를 출력할 수 있는 메소드를 제공해주는 스트림이다.
			//스트림은 그냥 입출력에 관련된 클래스이구나라고 받아들이면된다.
			nr=new LineNumberReader(fr); //스트림을 열었으면 final에서 닫는다. fr을 호출못하므로 밖으로 뺀다.
			
			String line="";
			while((line=nr.readLine())!=null){
				System.out.printf("%d : %s\n",nr.getLineNumber(),line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}catch (IOException e){
			e.printStackTrace();
			
		} finally{
			try {
				nr.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			//경로명 복사한다.
		}
		
		
	}// main()
	
}// class
