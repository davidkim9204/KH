package Java0706_statement;

/*
 * if(조건식){
 *    if(조건식){
 *     수행할문장;
 *    }else{
 *     수행할문장;
 *    }
 * }else{
 *    수행할 문장;
 * }
 * 
 */
public class Java019_if {

	public static void main(String[] args) {
		boolean member=true; //회원 or 비회원 //1 a
		String grade="VVIP"; //회원임때 등급 //2 b
		
		if(member){ //3 c
			if (grade=="VVIP"){ //d
				System.out.println("30%적립");
			}else{ 
				System.out.println("10%적립"); //e
			}
		}else{ 
			System.out.println("비회원"); //4
		}
		
		System.out.println("고객님감사합니다."); //5 f
		
		//기본타입이 아니라 참조데이터 타입인 클래스에 해당 문자열에 사용할려고
		
		
		
	}// end main()
}// end class
