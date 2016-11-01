package java0726_collection;

import java.util.HashSet;

/*
 * HashSet
 * 1.set인터페이스를 구현한 클래스이다.
 * 2.중복하용안되고, 순서유지 안된다.
 */

public class Java183_HashSet {

	public static void main(String[] args) {
		HashSet<Integer> set=new HashSet<Integer>();
		set.add(new Integer(10));
		set.add(new Integer(20));
		set.add(new Integer(30));
		
		// db데이터를 가져온다던지 사용자 데이터를 가져올때 좋다. 중복된 값 제거에 사용.
		
		set.add(new Integer(30));
		for(Integer it: set)
			System.out.println(it);
			
	}// end main()

}// end class
