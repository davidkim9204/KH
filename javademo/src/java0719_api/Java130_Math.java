package java0719_api;

//class.메소드 넘불편데스.

import static java.lang.Math.E;
import static java.lang.Math.sqrt;
import static java.lang.Math.*;



/*수학관련 클래스
 * java.lang.Math
 * 
 */




public class Java130_Math {

	public static void main(String[] args) {
		System.out.println(Math.PI); //원주율
		System.out.println(Math.max(10, 20)); //최대값
		System.out.println(Math.min(10, 20)); //최소값
		
		System.out.println(E);
		System.out.println(sqrt(25)); //제곱근
		System.out.println(pow(2,3)); //거듭제곱
		
		
		
		
		
		//final이 있어서 상속 불가. obj에게서 상속받는다.
		//모든 메소드에static이 붙어있다.
		
	}//end main()
	
}//end class
