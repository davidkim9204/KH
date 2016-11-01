package Java0707_statement;

/*
 * while(조건식){
 * 	수행할 문장;
 * }
 */

public class Java036_while {

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}

		System.out.println("///////////////////////////////////////");

		int j = 1;
		while(j<=5){
			System.out.println(j);
			j++;//기본 증감을 처리하는 장소
		}
		
		//조건문을 활용하여 1씩 감소시키거나 1씩 증가시킬때
		int k = 0;
		while(k++<=5){ //++k과 k++은 끝값이 달라진다 분석이 필요하다.
			System.out.println(j);
			j++;
		}
		
		
		
		
	}// end main()
}// end class
