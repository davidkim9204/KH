package Java0706_statement;

public class Java017_statement {
	public static void main(String[] args) {
		int num = 7; // 1
		if (num % 2 == 0) {// 2

			System.out.printf("%d는 %s입니다.\n", num, "짝수");// 3
		} else {
			System.out.printf("%d는 %s입니다.\n", num, "홀수");// 3
		}
		System.out.println("program end");// 4

	}
}
//byte<short,char < int < long < float < double
//*다른 타입끼리 데이터를 주고 받아야 할 때