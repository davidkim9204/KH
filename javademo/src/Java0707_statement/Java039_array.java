package Java0707_statement;
//객체 지향 언어 최소단위가 클래스 - 변수 배열 구조체 클래스라는 개념과 관련이 있다.
//값을 저장하는 방법
//하나의 값을 저장하는 것이 변수
//변수가 많으면 관리하기 어렵기때문에 같은 타입의 변수를 모아서 관리한다.

//기본데이터는 스택에 저장, 참조데이터는 힙에 생성. 주소를 활용한다.

public class Java039_array {

	public static void main(String[] args) {
		/*int ko=90;
		int en=80;
		int jp=40;*/
		
		
		//int jumsu[]; 참조 데이터를 쓰려면 new를 반드시 써야한다.
		int[] jumsu=new int[3]; //배열을 정의하는법2가지	 주소저장은 4바이트  점수가 스택을 4바이트로 관리하고 힙에 4바이트 짜리를 인덱스 0 1 2순으로 3개 만든다.
		/*
		 * new: 힙 메모리에 배열을 생성해주는 키워드이다.
		 * 배열에 저장된 값을 요소(element)라 한다.
		 * 배열은 생성될때 요소에 접근할 수 있도록 인덱스가 제공된다.
		 * (인텍스는 0부터 시작한다.)
		 * 
		 * 배열의 크기를 리턴해주는 키워드는 length이다.
		 * 주석한꺼번에 제거하기 컨트럴 시프트 역슬러쉬
		 */ 
		
		
		
		//메쏘드는 반드시 ()소괄호가 붙어야한다. 하지만 키워드는 붙지 않는다.
		
		
		
		for(int i=0;i<jumsu.length;i++){ //length 배열의 크기를 나타내는 keyword.
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);
		}
		
		jumsu[0]=90;
		jumsu[1]=80;
		jumsu[2]=40;
		
		for(int i=0;i<3;i++){
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);

		}
		
		String data="java" //문자열을 나타내는 class인 String
				System.out.println("문자열길이:"+data.length());//얘는 메소드 스트링이라는 클래스에서 제공해주는
		
		
		
		
	}//end main
}//end class
