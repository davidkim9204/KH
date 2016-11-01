package java0720_api;

import java.util.Calendar;

/*
 * 2016년 2월 마지막과 요일을 구하는 프로그램을 구현하세요.
 * [출력결과]
 * 2016-2-29 월요일
 */



public class Java145_Calendar {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		cal.set(2016, 1, 1);
		int date=cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE,date);
		String day="";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1: day="일"; break;
		
		}
		System.out.printf("%d-%d-%d %s요일\n",2016,2,date,day);
		
		
		
		
		
//		int year=cal.get(Calendar.YEAR);
//		int month=cal.get(Calendar.MONTH)+1;
//	
//		int wek=cal.get(Calendar.DAY_OF_WEEK);
//		String week="";
//		switch (wek) {
//		case 0:week="토요일";break;
//		case 1:week="일요일";break;
//		case 2:week="월요일";break;
//		case 3:week="화요일";break;
//		case 4:week="수요일";break;
//		case 5:week="목요일";break;
//		case 6:week="금요일";break;
//		
//		}
//		
//		
//		
//		System.out.printf("%d-%d-%d %s\n",
//				year,month,date,week);
		
		
		
		
	}//end main()
}//end class
