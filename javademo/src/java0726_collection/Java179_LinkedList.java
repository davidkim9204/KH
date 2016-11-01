package java0726_collection;

import java.util.LinkedList;

/*
 * 배열구조로 데이터 관리 : Vector, ArrayList - 추가-(순차적으로 처리할때 사용한다.)
 * 링크로 데이터 관리 : LinkedList-삽입, 삭제 -(비순차적으로 처리할때 사용한다.)
 * 
 * 리스트를 구현해 놓은 컬렉션
 * Vector, ArrayList, LinkedList은 add()해준 순서대로 인덱스가 제공이 된다.
 */
public class Java179_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> nList = new LinkedList<String>();
		//추가
		
		nList.add(new String("java"));
		nList.add(new String("jsp"));
		nList.add(new String("spring"));
		
		//삽입
		nList.add(1, new String("ajax"));
		
		//삭제
		nList.remove(2);		
		
		for(int i=0; i<nList.size();i++)
			System.out.println(nList.get(i));
		
		for(String sn: nList)
			System.out.println(sn);
		
		//둘의 결과값은 같다.
		
		
		//키워드 좌우로 null값을 가지고 시작하여 null에 주소를 넣는다.
		//링키드 리스트는데이터를 처리할띠ㅐ 링크를 가지고 처리한다.
		//비순차적 데이터에 편한다.
		
		
	}//main()
	
}//end class
