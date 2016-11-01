package java0721_exception_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Java160_stream {

	public static void main(String[] args) {
		File file=new File("sample.txt");
		FileReader fr =null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String line="";
			while((line=br.readLine())!=null){  //file의 끝이면 null을 리턴
				System.out.println(line);
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("//////////////////////////////");
		Scanner sc=null;
		try {
			
			sc=new Scanner(file);
			while (sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			sc.close();
		}
		
		
		
		
		
	}//end main()
	
}//end class
