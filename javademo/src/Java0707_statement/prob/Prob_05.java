package Java0707_statement.prob;

/*
 * 1. 이중 for문을 이용해서 1부터 20사이의 정수에서 2,3,4,5의 배수를 수행하는 
 *    프로그램을 구현하시오.
 * 2. 출력결과
 *    2의 배수 :    2   4   6   8  10  12  14  16  18  20
 *    3의 배수 :    3   6   9  12  15  18
 *    4의 배수 :    4   8  12  16  20
 *    5의 배수 :    5  10  15  20
 *     
 */
public class Prob_05 {

	public static void main(String[] args) {
	
		int sum = 0;

		for (int i = 2; i <= 5; i++) {
			
			for (int j = 1; sum <= 20; j++) {
				sum = i * j;
				

			}	
			System.out.printf("%d의 배수:		%d\n",i,sum);
		
		}

		
		
		
		
		/*
		
		for (int j=2; j<=5;j++){
			System.out.printf("%의 배수:",j);
			for(int i=1; i<=20;i++){
				
				if(i%j==0){
					System.out.println("%3d",i);
				}
			}
			System.out.println();
		}
		
		*/
		
		
		
		
		
		
	}// end main()

}// end class
