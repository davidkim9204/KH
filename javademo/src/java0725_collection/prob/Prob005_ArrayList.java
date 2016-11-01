package java0725_collection.prob;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
 /*
       [프로그램 실행결과]
		 *   [MBC]
		 *   4  오로라 공주      MBC   13.0
		 *   [KBS1]
		 *   1  지성이면 감천    KBS1  22.6 
		 *   2  KBS 뉴스 9     KBS1  19.0
		 *   5  인간극장         KBS1  12.4  
		 *   6  KBS 뉴스 7     KBS1  11.6  
		 *   7  KBS 뉴스광장    KBS1  10.4 
		 *   10 가요무대        KBS1  10.2 
		 *   [KBS2]
		 *   3  굿 닥터         KBS2  17.9 
		 *   8  TV소설 은희     KBS2  10.3   
		 *   [SBS]
		 *   8 황금의 제국      SBS   10.3
		 */


public class Prob005_ArrayList {

	public static void main(String[] args) {
		ArrayList<Television> aList=new ArrayList<Television>();
     /*
      * tv.txt파일의 데이터를 ArrayList에 저장하는 프로그램을 구현하시오.
      */
		
		File file=new File("./src/java0725_collection/score.txt");
		Scanner sc =null;
		try{
			sc=new Scanner(file);
			while(sc.hasNextLine()){
				String arr [] = sc.nextLine().split(":");
				System.out.println(arr[0]);
				
				
				
				
				
			}
		
		
//		}catch()
		
	
		
		
		prnDisplay(aList,"MBC");
		prnDisplay(aList,"KBS1");
		prnDisplay(aList,"KBS2");
		prnDisplay(aList,"SBS");

	}//end main()
	
	public static void prnDisplay(ArrayList<Television> aList, String channel){
		//channel매개변수에 해당하는 프로그램이 출력되도록 구현하시오.
		
		
	}//end prnDisplay()

}//end class








