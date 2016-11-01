package java0725_collection;

import java.util.ArrayList;

/*
 * Vector와 ArrayList
 * 1 Vector은 동기화 처리가 되여 있고 ArrayList은 비동기화 처리한다.
 * 2 Vector와 ArrayList은 메모리에 요소를 처리할때 배열의 구조를 따른다.
 * 3 Vector와 ArrayList의 클래스는 처리방법이 비슷하다.
 * 4 Vector와 ArrayList으로 요소의  추가,삭제를 처리하는 것은
 *    좋은 방법이 아니다.
 */

//1. 배열: 순차에 유리(vector, arraylist등) , 2. 링크: 비순차 삽입 삭제에 유리 (linkedlist)
public class Java175_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> aList=new ArrayList<Integer>(); //마찬가직로 제네릭 명시
		aList.add(new Integer(10));
		aList.add(new Integer(20));
		aList.add(new Integer(30));
		
		for(int i=0; i<aList.size();i++)
			System.out.println(aList.get(i)); //해당 index를 복사해서 가져온다. 벡터사용방법과 같이 사용하면된다.
		
		
	}//end main()
}//end class
