package java0718_api;

/*
 * 
 * JAVA API(Application Programming INterface)
 * Object
 * 1 클래스 중에서 최상의 클래스이다.
 * 2 Object을 제외한 모든 클래스들은 Object을 상속받고 있다.
 * 3 java.lang패키지에서 제공하는 클래스이다.
 * - 많이 사용되는 것을 모아두었기 때문에 jvm에 이미 설치 되어있다.
 * 별도로 import하지 않아도 사용할 수 있다.
 * 
 * 
 */





public class Java112_Object {

	
	public static void main(String[] args) {
		Object obj=new Object();
		//java.lang.Object@15db9742
		System.out.println(obj.toString());
		
		int x=5;
		int y=5;
		
		//==값 비교 (기본데이터)
		System.out.printf("x=%d y=%d x==y:%b\n",x,y,x==y);
		
		
		Object ojt=new Object();
		//==주소비교(참조데이터)
		System.out.printf("obj==ojt:%b\n",obj==ojt);  //값이 아닌 주소를 비교하기 때문에 false가 나온다.
		
		//equals 주소비교 - 객체비교에만 사용 한다.
		System.out.printf("obj.equals(ojt)=%b\n",obj.equals(ojt)); //상속받은것을 그냥 사용하는지 override해서 사용하는지 알아야한다.
		//class java.lang.Object
		System.out.println(obj.getClass());
		
		//java.lang.Object
		System.out.println(obj.getClass().getName());
		
		System.out.println(obj);
		System.out.println(obj.toString());
		
		
		
	}//end main
	
}//end class
