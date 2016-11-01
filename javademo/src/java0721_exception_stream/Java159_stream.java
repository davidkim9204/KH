package java0721_exception_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//목적지가 파일일때
public class Java159_stream {

	public static void main(String[] args) {
		File file=new File("sample.txt"); //파일이라는 클래스는 실제로 작용하는 것이 아닌 보통 윈도우에서 속성을 볼때 같은 것을 보는 것으로 구성
		
//		System.out.println(file.exists()); //없으니깐 false
//		System.out.println(file.isFile()); //
//		System.out.println(file.canWrite()); //쓸수있느냐. 파일이 없어서
		//이러한 정보들을 알 수 있다. file이라는 class에서 제공되는 자원들
		FileWriter fw=null;  //fw를 일단 만들었지만 아무것도 들어있지 않을 수 있다. 때문에 null을 넣는다. 이것이 무엇이든 그래서 오류가 없어진것이다. null을 기재하지 않은 경우는 텅비어있는 상태가 되어있는 것이다.
		try {
			/*
			 *FileWriter("대상파일",mode)
			 *mode의 앖이 true이면 append이고, false이면 update이다.
			 *생략하면 mode의 값은 false이다.(기본값) 
			 *
			 */	
//			FileWriter fw=new FileWriter(file); //fw는 try 영역에서만 사용가능하다.
			fw=new FileWriter(file,true); //모드값 기본이false 없으면 이것으로// true면 append된다
			fw.write("java\r\n"); //write는 없으면 만든다.  - \r 13 \n 10
			fw.flush();//buffer의 내용을 대상file에 보내고 buffer를 clear한다.//일단 write에 하라고하면 바로 대상이 아니라 buffer에 작성한다. buffer에 있는 것을 파일(대상)에 보내고 버퍼에 남은것을 지운다.
			fw.write("test\r\n");
			System.out.println("저장종료");
//			fw.close(); //flush 연결종료까지 한다. 버퍼에 있는 것을 보내고 연결을 끊어 버린다.
//			fw.write(97); //여기서 인트는 유니코드값
//			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}//end main()
	
}//end class
