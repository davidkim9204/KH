package java0725_collection;
/*
 * [프로그램 출력결과]
 * kim 56 78 12   ??
   hong 46 100 97 ??
   park 96 56 88  ??
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

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
		String sn = "./src/Java0725_collection/score.txt";
		Vector<Sawon> vt = lines(sn);
		prnDisplay(vt);

	}// end main()

	private static Vector<Sawon> lines(String strName) {
		// strName 매개변수의 값을 이용해서 Vector에 데이터를 저장한 후
		// 리턴하는 프로그램을 구현하시오.
		Vector<Sawon> v = new Vector<Sawon>();
		File file = new File(strName);
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()){
				String arr [] = sc.nextLine().split("[/:]");
				Sawon sn = new Sawon(arr[0],
						Integer.parseInt(arr[1]),
						Integer.parseInt(arr[2]),
						Integer.parseInt(arr[3]));
				
				v.add(sn);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		return v;
	}

	private static void prnDisplay(Vector<Sawon> vt) {
		// vt에 저장된 객체들을 출력하는 프로그램을 구현하세요.
		for(Sawon data : vt){
			System.out.println(data);
			System.out.println(data.toString());
		}

	}// end prnDisplay()

}// end class
