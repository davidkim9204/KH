package java0708_method;
/*
 * 입사총점 : 815점
 * 입사결과 : 합격입니다.
 */


public class Java059_method {

	public static int total(int toeic, int it){
		//두 매개변수의 합계를 계산하여 리턴한다.
		
		
		
		return toeic +it;
	
	}//end total()
	
	public static String rs(int tot) { //tot = 815
		//총점이 800이상이면 합격, 미만이면 불합격
		if (tot>=800)
			return "합격";
			
		else
			return "불합격";
				
		
		
		
		
	}//end rs
	
	public static void main(String[] args) { //항상 소스 분석은 메인 method를 확인
		int toeic =750, it =65;
		
		System.out.println("입사총점:"+ total(toeic, it)+"점");
		System.out.println("입사결과:"+ rs(total(toeic,it))+"입니다.");
	}//end main()
	
	
}//end class
