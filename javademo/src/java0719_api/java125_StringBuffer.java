package java0719_api;

/*
 * java.lang.String :불변
 * java.lang.StringBuffer : 가변, 비동기화
 * java.lang.StringBuilder : 가변, 동기화
 */


public class java125_StringBuffer {

	public static void main(String[] args) {
		String sg= new String ("java test");
		String ss= sg.replace("java", "jsp");   //String은 수정이 불가, 버퍼에서 변경 수정
		System.out.println(sg);
		System.out.println(ss);
		
		System.out.println("//////////////////////////");
		StringBuffer sb=new StringBuffer("spring test");
		sb.replace(0, 6, "framework");
		System.out.println(sb);
		
		
		
		
		
	}//end main()
	
	
}
