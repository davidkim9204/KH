package java0708_method;
//2. 리턴값이 없고 매개변수는 있다.
public class Java049_method {

	public static void main(String[] args) {
		//매개변수가 선언된 메소드를 호출할 때 매개변수에 정의된 데이터 타입과 일치하는 값을 넘겨준다.
		process("홍길동"); //public static void process(String name에 맞춰서 값을 써줌)  //1
		test(3000); //public static void test(int point값에 맞춰서 값을 써줌) //3
		 
		
	}//end main()

	public static void test(int point){
		System.out.println(point+"포인트 적립되었습니다."); //4
	}//end test()
	
	public static void process(String name){ 
		System.out.println(name+"님은 회원입니다."); //2
	}//end process()
	
	
	}//end class
