package java0725_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * [프로그램 출력결과]
 * kim 56 78 12   ??
   hong 46 100 97 ??
   park 96 56 88  ??
 */

class Sawon {
	String name;
	int one;
	int two;
	int three;

	public Sawon(String name, int one, int two, int three) {
		super();
		this.name = name;
		this.one = one;
		this.two = two;
		this.three = three;
	}

	private int count() {
		return one + two + three;
	}

	public String toString() {
		return name + " " + one + " " + two + " " + three + " " + count();
	}

}// end Sawon




public class Java174_collection {
	public static void main(String[] args) {
		File file=new File("./src/java0725_collection/score.txt");
		Scanner sc =null;
		
		try {
			sc= new Scanner(file);
			while(sc.hasNextLine()){
				String[] line=sc.nextLine().split("[:/]"); //한라인 읽어서 스플릿으로 나눈것을 배열에 넣는다.
				Sawon sn= new Sawon(line[0], 
						Integer.parseInt(line[1]), 
						Integer.parseInt(line[2]), 
						Integer.parseInt(line[3])); //스트링은 앞이지만 뒤는 인트값이기 때문에 인트로 바꿔야한다.
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		
		}
	}//end main()
	
	
}//end class
