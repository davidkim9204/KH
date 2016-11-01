package java0721_exception_stream;

import java.util.Scanner;

public class Java157_stream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // ,최종 목적지를 왼쪽괄호에 넣는다. 여기서는 콘솔창.

		int x = 0;
		int y = 0;
		
			System.out.print("x:"); 
//			x = Integer.parseInt(sc.nextLine()); 
			x=sc.nextInt();
			System.out.print("y:");
			y=sc.nextInt();
//			y = Integer.parseInt(sc.nextLine()); //
			System.out.printf("x+y=%d\n", x + y);

		sc.close();

		
	}// end main()
}
