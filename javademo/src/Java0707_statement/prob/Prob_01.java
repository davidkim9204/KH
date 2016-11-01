package Java0707_statement.prob;

/*
for문을 이용해서 12의 약수를 구하시오
약수 : 어떤 수를 나누어서 0으로 떨어진 수
1
2 
3 
4 
6 
12
*/

public class Prob_01 {

	public static void main(String[] args) {
		int num=12;
		
		for(int i=1; i<=12 ; i++){
			if(num%i!=0){
				continue;
			}
			System.out.println(i);
		}
		
		
		
		/*솔루션
		 * 문제
		 * int num=12;
		 * -----------
		 * 
		 * 
		 */
		/*
		for(int i=1; i<=num;i++){
			if(num%i==0){
				System.out.println(i);
			}
		}
		*/
		

	}//end main()

}//end class













