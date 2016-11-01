package java0719_api;

import java.util.StringTokenizer;

public class Java128_StringTokenizer {

	public static void main(String[] args) {
		//StringTokenzier(문자열,구분자)
		//문자열의 구분자가 공백일때는 2번째 인자값은 생략 할 수 있다.
		
		StringTokenizer st=new StringTokenizer("java,jsp",",");  //구분자에 의해 나눠진 문자열을 token이라 부른다.
		System.out.println(st.countTokens());
		
//		for(int i=0;i<st.countTokens();i++)
//			System.out.println(st.nextToken());  //nextToken은 메모리에저장된 토큰을 완전히 꺼내와버림!!
		
		
		
		//메모리에 저장된 토큰을 가져올 수 있으면 true 아니면 false를 리턴한다.
		while(st.hasMoreTokens())
			
			//메모리에 저장된 토큰을 가져온다.
			System.out.println(st.nextToken());
		
		
		
		
		
		
	}//end main()

}//end class
