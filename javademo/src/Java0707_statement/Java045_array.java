package Java0707_statement;


public class Java045_array {
	public static void main(String[] args) {
		int[][] num = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		for (int row = 0; row < num.length; row++) { // 2차원에서는 행을 의미, 3차원에서는 면

			// num.length:행의 크기를 리턴한다.
			// num[row].length: row행에 해당하는 열의 크기를 리턴한다.
			for (int col = 0; col < num[row].length; col++) { // 지정 행의 열의 크기를
																// 리턴한다.
				System.out.printf("%d\t", num[row][col]);

			}
			System.out.println();
		}

		
		//메모리 손실을 최소화 시켜주기 위해서 가변행렬을 사용할 수 있다. 
	}// end main()
}// end class
