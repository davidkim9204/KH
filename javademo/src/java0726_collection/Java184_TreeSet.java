package java0726_collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Java184_TreeSet {

	public static void main(String[] args) {
		TreeSet<Integer>tree=new TreeSet<Integer>();
		tree.add(new Integer(10));
		tree.add(new Integer(20));
		tree.add(new Integer(15));
		tree.add(new Integer(20));
		
		
		//트리셋은 정렬시킬때 사용된다.
		
		
		System.out.println("오름차순");
		
		Iterator<Integer> ite = tree.iterator();
		
		//다음에 가져올 요소가 있으면 true 없으면 false를 리턴
		while(ite.hasNext())
			//요소를 가져온다.
			System.out.println(ite.next());
		
		
		System.out.println("내림차순");
		ite=tree.descendingIterator();
		while(ite.hasNext())
			System.out.println(ite.next());
				
		
		//느림, 정렬이 필요할때만 사용.
		
	}//end main()
}//end class
