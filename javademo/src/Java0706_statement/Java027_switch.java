package Java0706_statement;

public class Java027_switch {

	public static void main(String[] args) {
		
		char ope = '*';
		int numX = 10;
		int numY = 5;
		int res = 0;

		
		if (ope == '+') {
			res = numX + numY;
		} else if (ope == '-') { 
			res = numX - numY; 
		} else if (ope == '*') { 
			res = numX * numY; 
		} else if (ope == '/') { 
			res = numX / numY; 
		} else {
			System.out.println( "사칙연산이 아닙니다."); 
		}	
			System.out.printf("%d %c %d = %d\n",numX,ope,numY,res);
			
	
		switch(ope){
		case '+':
			res = numX + numY;
		case '-'
		
		
		default
		System.out.println("사칙연산아냐");
		 	return; //현재 수행중인 메소드를 빠져나온다.
			
		}
		System.out.println(위에거랑 같음.);
			
			
			
			
		
		
		
	}//end main()
	
}// end class
