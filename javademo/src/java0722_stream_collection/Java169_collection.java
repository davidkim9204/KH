package java0722_stream_collection;

import java.util.Vector;

public class Java169_collection {

	public static void main(String[] args) {
		Vector v=new Vector();//결과값 안받으면 element로
		//Integer -> Object (업캐스팅)
		
//		int x=140;
//		Integer in =new Integer(x);
//		Object obj =(Object)in;
//		v.addElement(obj);
//		
//		v.addElement(x);
		
		
		v.addElement(new Integer(10));//0
		v.addElement(new Integer(20));//1
		v.addElement(new Integer(30));//2
		
		//모든 컬렉션에는 객체로만 저장이 이뤄짐
		
		//int -> Integer -> object (auto boxing -> upcasting) 
		int num=40;
		//jdk 5.0에서 추가된 auto boxing일어남
		v.addElement(num); //3
		
		
		//모든 컬렉션에 저장되는 것은 object로 저장
		
		//Object -< Integer (다운캐스팅)
		Integer it =(Integer)v.get(0); //object 로 저장
		System.out.println(it);
		
		//Object -> Integer -> int(다운캐스팅 ->auto unboxing)
		int data=(Integer)v.get(3);
		System.out.println(data);
		
		
		
		
	}//end main()
}//end class
