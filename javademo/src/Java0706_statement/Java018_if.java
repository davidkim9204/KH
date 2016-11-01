package Java0706_statement;
/*
 * /*
 * 제어문(control statement)
 *  : 문장의 흐름을 제어해주는 기능이다.
 *  1 종류 
 *    조건문 : if~else, switch~case
 *    반복문 : for, while, do~while
 *    기타 : break, continue, (label)
 *    
 *   if (조건식){
 *     수행할 문장;
 *    }else{
 *     수행할 문장;
 *    }
 *
 * 
 * 
 * 
 * 
 * 
 * 
 * 조건식을 만족할때만 수행할 문장이 있는 경우
 * if(조건식){
 *   수행할 문장;
 * }
 */

public class Java018_if {

	public static void main(String[] args) {
		int num=-9; //1
		if(num>0){ //2
			System.out.println("자연수"); //3
		}
		
		System.out.println("program end"); //4		3
		
		//조건이 다르면 수행 안하고 끝 
		
	}//end main()
}//end class
