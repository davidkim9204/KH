package java0712_static_access;
/*
 * 프로그램의 실행과정
 * 1. 소스 코드 작성     Java076_static.java
 * 2. 클래스 파일 생성(컴파일) javac Java026_static.java
 * 3. 클래스 파일 실행(run)  java Java026_static
 * 4. 클래스 로딩 -메모리로 읽어온다.
 *       static키워드를 사용한 변수와 메소드를 자동으로 메모리에 로딩한다
 * 5. main()메소드 실행-main스레드에서 main()메소드를 호출한다.
 * 6. 객체생성(new)
 * 7. 변수,메소드를 호출
 * 8. main()메소드 종료-프로그램 종료
 * 
 * static
 * 1. 같은 데이터 타입으로 생성된 객체끼리는 서로 공유한다.
 * 2. 클래스가 로딩되는 시점에 메모리에 저장된다.
 * 3. static키워드가 선언된 메소드에서는 this,super키워드를 사용할 수 없
 * 다. 
 * 생성 시점 차이로 인한?
 */

class StaticEx{
	int x=5;
	static int y=10;
	public StaticEx(){
		
	}
	
	public void prn(){
		System.out.printf("%2d %2d\n",x,y);
	}
	
}//end class
public class Java076_static {

	public static void main(String[] args) {
		StaticEx se=new StaticEx();
//		se.prn();
		
		se.x=20;
		StaticEx.y=30; // 공유되기 때문에(static이 붙은 (클래스.변수)로 호출해도 상관이 없다.(권장사항
		System.out.printf("se.x=%2d StaticEx.y=%2d\n", se.x, StaticEx.y);
		
		StaticEx ss=new StaticEx();
//		ss.prn();
		System.out.printf("ss.x=%2d StaticEx.y=%2d\n",ss.x, ss.y);
	
	
	}//end main()
	
}//end class

//객체는 new로 실행 시킬 수 있다.

