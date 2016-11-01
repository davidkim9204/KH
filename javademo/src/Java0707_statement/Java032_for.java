package Java0707_statement;

//3의 배수만 제외하고 출력하는 프로그램을 구현하세요.
public class Java032_for {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) { // 3 c
			if (i % 3 == 0) {// 1 a
				// 반목문에서만 continue키워드를 사용한다
				continue; // b (컨티뉴를 수행하면 바로 증감식으로 간다. continue는 반복문에서 조건식으로
							// 이동한다. 증감식으로 무조건 이동한다.
			} // 수행 조건문이 하나면 생략가능.
			System.out.println(i);// 2
		}

	}// end main()

}// end class
