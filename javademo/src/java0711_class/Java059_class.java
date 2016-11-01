package java0711_class;

class Person{
	String name; //멤버변수
	int age;
	char gen;
	
	//메소드
	void eat(){
		System.out.println("eat");
	
	}
	
	void run(){
		System.out.println("run");
	}
	
	void stop(){
		System.out.println("stop");
	}
	
}//end class

public class Java059_class {
	
	public static void main(String[] args) {
		Person ps=new Person();
		//객체참조변수.멤버변수
	
		ps.name="홍길동";
		ps.age=30;
		ps.gen='남';
		System.out.printf("%s %d %c\n",
				ps.name, ps.age, ps.gen);
		
		//객체참조변수.메소드()
		ps.eat();
		ps.run();
		ps.stop();
		
		
		
		Person pp=new Person();
		pp.name="이영희";
		pp.age=25;
		pp.gen='여';
		System.out.printf("%s %d %c\n",
				pp.name, pp.age, pp.gen);
		pp.eat();
		pp.run();
		pp.stop();
		
//int처럼 우리가 정의하여 만든 데이터 타입이 "class"이다. 즉 새로운 정의를 하는것이다.
// 이것이 참조 데이터 타입이다. int같은 것은 기본 데이터 타입이다.
//int num;이런식으로도 메모리가 확보가 된다. (stack에 저장)
//하지만 객체를 만드는 경우에는 메모리 확보가 되지 않는다. Person ps 확보 불가. 메모리가 생성되는 곳이 다르다.
//ps=new person() 를 사용해야만 메모리 확보가 된다.(heap에 저장)
		
		
		
		
		
	}//end main

}//end class
