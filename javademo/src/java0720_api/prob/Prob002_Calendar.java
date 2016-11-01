package java0720_api.prob;

import java.util.Calendar;

/*
 * [출력결과]
 * <4보다크고 12시 미만일때>
 * 지금은 5시 35분입니다.
 * Good Morning
 * 
 * <12시부터 18시 미만일때>
 * 지금은 16시 49분입니다.
 * Good Afternoon
 * 
 * <18시부터 22시 미만일때>
 * 지금은 20시 30분입니다.
 * Good Evening
 * 
 *  <그외 일때>
 *  Good Night
 */


public class Prob002_Calendar {
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		
		System.out.println(hour);
		System.out.printf("지금은 %d시 %d분입니다.",hour,minute);
		System.out.println();
		
		if(hour>4 || hour<12){
			System.out.println("Good Morning");
		}else if(hour>=12 || hour<18){
			System.out.println("Good Afternoon");
		}else if(hour>=18 || hour<22){
			System.out.println("Good Evening");
		}else{
			System.out.println("Good Night");
		}
			
			
			
			
		
			
			
	
		
	
			
	}//end main()
}//end class