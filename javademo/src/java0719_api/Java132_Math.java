package java0719_api;

/*
 * 난수를 이용해서 소수점 첫째자리까지 반올림해서 구하시오.
 * ex) 0.5689...; => 5.7
 */


import static java.lang.Math.*;

public class Java132_Math {

	public static void main(String[] args) {
		
		double ran=random();
		ran=ran*100;
		long num=round(ran); //0~10미만
		double data=(double)num/10;
		
		System.out.println(data);
		
	}//end main()
	
}//end class
