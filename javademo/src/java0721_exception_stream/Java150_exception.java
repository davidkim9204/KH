package java0721_exception_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Java150_exception {

	public static void main(String[] args) {
		File file =new File("sample.txt");
		
		try {
			FileReader fr=new FileReader(file);
			//FileNotFoundException은 checked exception이므로
			//반드시 try~catch~finally(예외처리)를 해줘야한다.
			
			//java lang, io에서 하드웨어적 인 것은 제공한다.
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		//커서를 가져가면 볼 수 있따.
	}
}
