package Java0706_statement;

public class Java025_switch {

	public static void main(String[] args) {
		int num=2;
		int DATA=2;
		switch(num){
		case 3:
			System.out.println(3);
			break;
		case 1: //이런것들이 리터널이다.
			System.out.println(1);
			break;
		case DATA:
			System.out.println(2);
			break;
	
		case 4:
			System.out.println(4);
			break;
		default : 
			System.out.println(5);
			break;
		
		}
		
		//실행 가능하지만 정렬해서 표현하는것이 가독성에 좋다.
		//DATA같은 상수값을 사용가능
		//case에 변수를 사용할 수 없다.
		
		
		/*
		 * case의 값은 정렬을 하지 않아도 되지만 가독성때문에 일반적으로
		 *   정렬을 해서 구현을 한다.
		 * case의 값에 변수를 사용할 수 없다.(리터널, 상수만 가능하다)
		 */
		
	}//end main()
	
}//end class
