package Java0706_statement;

/*
 * 
 * i=1 sum1
 * i=2 sum3
 * i=3 sum6
 * i=4 sum
 * 
 * i=8 sum36
 */


public class Java030_for {

	public static void main(String[] args) {
		
		int sum = 0;
		int i;
		//for 문에서 조건식을 생략할때는 종료되는 값을 정확히 모를때 생략한다.
		for(i=1; ; i++){
			
			sum+=i; //1 3
			System.out.printf("i=%d sum=%d\n", i, sum);
			if(sum>=30)
				
			break;// 현재 수행중인 반복문을 빠져나온다.
		}	
		
		
	}//end main()
	
}//end class
