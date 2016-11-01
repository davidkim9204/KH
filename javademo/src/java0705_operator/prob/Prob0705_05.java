package java0705_operator.prob;

/*
 * 동전교환프로그램
 * 1 가장적은 동전으로 교환할 수 있는 프로그램작성하시오
 * 2 [출력결과]
 *   500원: 15개
     100원: 2개
     50원: 1개
     10원: 2개
     1원: 7개
 */

public class Prob0705_05 {

	public static void main(String[] args) {
		int money = 7777;
		int mok=money/500;
		
		/*여기에 작성하시오
		int w1 = money/500;
		int z1 = money%500;
		int w2 = z1/100;
		int z2 = z1%100;		
		int w3 = z2/50;
		int z3 = z2%50;
		int w4 = z3/10;
		int z4 = z3%10;
		
				
				
		System.out.println(w1);		
		System.out.println(w2);
		System.out.println(w3);
		System.out.println(w4);
		System.out.println(z4);
		*/		
		
		//솔루션
		System.out.printf("500원:%d개\n", mok);
		
		money = money %500;
		mok = money / 100 ;
		System.out.printf("100원:%d개\n", mok);
		
		
		money = money %100;
		mok = money / 50 ;
		System.out.printf("50원:%d개\n", mok);
		
		money = money % 50;
		mok = money / 10;
		System.out.printf("10원:%d개\n", mok);

		money = money % 10;
		System.out.printf("1원:%d개\n", mok);

	
		
		
		
		
	}//end main()

}//end class



