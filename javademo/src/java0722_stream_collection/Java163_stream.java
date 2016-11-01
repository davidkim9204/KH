package java0722_stream_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Java163_stream {
	public static void main(String[] args) {

		File file = new File("./src/java0722_stream_collection/song.txt");
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(file, "rw");
			//파일의 끝으로 포인터 위치를 변경한다.
			raf.seek(raf.length()); //위치를 변경하기 위해 랭스를 이용하는 방식이 있다.
			String stn=new String("Maron5 - Daylight, Sunday Moring\r\n");
			raf.writeBytes(stn);
			raf.writeChar(97); //'a'
			raf.writeBytes("\r\n");
			System.out.println("program end");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}// end main()
}// end class
