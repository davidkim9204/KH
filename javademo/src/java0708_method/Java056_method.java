package java0708_method;
/*
 * [실행결과]
 * 문자열의 길이:4
 * 2인덱스의 요소값 가져오기:V
 */
public class Java056_method {
	static char[] data = new char[] {'j', 'A', 'v', 'a'};//질문
	
	
	
	public static void main(String[] args) {
		System.out.println("문자열의 길이:"+ length());
		System.out.println("2인덱스의 요소값 가져오기:"+charAt(2));
		
	}//end main()
	
	public static int length() {
		//data배열의 크기를 리턴하는 프로그램을 구현하세요
		return data.length;
	}
	
	
	public static char charAt(int index){ //리턴 값이 캐릭터.
		//data배열에서 index에 해당하는 문자를 리턴하는 프로그램을 구현하세요.
		
		return data[index];
	
	}
	
	
	
	
}//end class
