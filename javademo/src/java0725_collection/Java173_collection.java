package java0725_collection;

import java.util.Vector;

public class Java173_collection {
	public static void main(String[] args) {
		Vector<Integer>v= new Vector<Integer>();
		v.add(new Integer(10));
		v.add(new Integer(20));
		v.add(new Integer(30));
		
		
		//1인덱스의 요소가 제거된다.
		//컬렉션의 인덱스 또한 0부터 시작
		v.remove(1);
		
		//0인덱스에 40요소를 삽입한다.
		v.add(0,new Integer(40));
		
		for(Integer it: v)
			System.out.println(it);
		
		
		
		//여기서 integer는 object이다. //컬렉션에 들어가는 모든 데이터는 전부 객체이다. //벡터의 패기지는 java.util에서 제공 //제너릭을 쓰면 컬렉션에서 꺼내올때 다운케스팅을 안해도 되기때문에 편리하다.
			
	}//end main()
	
}//end class
