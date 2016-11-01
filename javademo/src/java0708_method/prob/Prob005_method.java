package java0708_method.prob;

/*
 * <<프로그램 실행결과 >>
 * 2 or 5의 배수가 아닌 갯수 : 7
 * 2 or 5의 배수가 아닌 합계 : 107
 */
public class Prob005_method {
	public static void main(String[] args) {
		int[] data = { 1, 3, 5, 8, 9, 11, 15, 19, 18, 20, 30, 33, 31 };
		result(data);
	}// end main()
	
	public static void result(int[] data){
		// 여기에 2 or5배수가 아닌 갯수와합계를 구하는 코드를 작성하세요.
		
		int cnt=0;
		int sum=0;
		
		for(int i=0; i<data.length;++i){
			if (data[i]%2==0 || data[i]%5==0){
			}else{
				++cnt;
				sum+=data[i];
			}
		}
		System.out.println("주어진 배열에서 3의 배수의 개수=>" + cnt);
		System.out.println("주어진 배열에서 3의 배수의 합=>" + sum);
		
		
		
	/*	int cnt = 0; // 3의 배수 개수
		int sum = 0; // 3의 배수 합
		// 여기에 3의 배수의 개수와 합을 구하는 코드를 작성하세요.
		
		//요소들을 
		for(int i=0; i<data.length;++i){
			if (data[i]%3==0){
				++cnt;
				sum+=data[i];
			}
		}
		System.out.println("주어진 배열에서 3의 배수의 개수=>" + cnt);
		System.out.println("주어진 배열에서 3의 배수의 합=>" + sum);
	*/	
		
				
	}//end result()
	
	
}// end class

