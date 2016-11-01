package Java0707_statement.prob;
/*
 * 
 * 2001부터 2012년사이에서 윤년을 구하시오 
 * 출력결과
 2004
 2008
 2012
 */

public class Prob_02 {

	public static void main(String[] args) {
		int million=2000;
		
		for(int i=1; i<=12 ; i++){
			if((i+million)%4!=0){
				continue;
			}
			System.out.println(i+million);
		}
      
		
		솔루션
		/*
		for(int year=2001; year<=2012; year++){
			if(year%4==0 && year%100 !=0 || year%400==0)
				System.out.println(year);
		}
		*/
       
	}//end main()

}//end class













