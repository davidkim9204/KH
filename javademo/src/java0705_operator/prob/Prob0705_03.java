package java0705_operator.prob;
/*
 * num변수의 절대값을 출력하는 프로그램을 구현하시오.
 * [실행결과]
 * 10
 */

public class Prob0705_03 {
	
	public static void main(String[] args) {
		int num=-20;
		int   result = num>=0 ? num : -num;
		System.out.println(result);

		
	}// end main()

}//end class
