package java0705_operator;


/*
 * 자바에서 문자를 표현하기 위해 유니코드를 사용한다.
 * '0' => 48
 * 'a' => 97
 * 'A' => 65
 * 
 * 
 */



public class java006_casting {

	public static void main(String[] args) {
		char data = 'Z';
		int asc = data;
		System.out.println(asc);
		
		
		
		//data -32의 결과 리턴 데이터 타입은 int이다.
		
		//char alpaUpper=data-32;//연산되는 데이터 타입이 다르면 크타입으로 리턴한다.
		char alpaUpper=(char)(data-5);
		System.out.println(alpaUpper);
		
		
		short num =128;
		byte one=(byte)num;
		System.out.println(one);
		
		
		
		
		
	}//end main()
	
	
}//end class
