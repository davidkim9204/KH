package java0720_api;
//가장 기본적인것.
import java.text.SimpleDateFormat;

public class Java143_System {

	public static void main(String[] args) {
		//currentTimeMillis() :1970.1.1부터 초단위로
		//누적한 값을 밀리세컨드로 리턴한다.
		
		
		//하루는 86400s이다. 1s는 1ms이다.
		
		long curr =System.currentTimeMillis();
		
		//날짜 시간형식의 패턴을 제공해주는 클래스이다. 
		//MM:월, mm:분
		//hh:12시간, HH:24시간
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date=sdf.format(curr);
		System.out.println(date);
		
		
		
		
	}
}
