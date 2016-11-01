package java0721_exception_stream;

import java.util.Scanner;

public class Java158_stream {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in); //스캐너는 자바.유틸에서 제공된다.
		String name="";
		int x=0;
		int y=0;
		double key=0.0;
//		System.out.print("데이터 입력:");  //공백이 데이터를 구분해주는 역할을 한다. 한 라인에 입력해야하면
		System.out.print("데이터 입력 name x y key:"); //,를 넣으면 오류
		name=sc.next();
		x=sc.nextInt();
		y=sc.nextInt();
		key=sc.nextDouble();
		
		System.out.printf("%s %d %d %.1f\n",name,x,y,key); //기본적으로 입력값은 string으로 받아들인다. nextint 등등은 알아서 바꿔서 리턴//
		//네트워크를 보통 왔다갔다하는것은 전부 스트링이다.
		//System.out.println(x+y);
		
		sc.close();
		
	}//end main()

}//end class
