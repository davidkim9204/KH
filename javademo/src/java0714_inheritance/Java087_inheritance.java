package java0714_inheritance;

class MyGrand{
	public MyGrand(){
	
	System.out.println("조상생성자");
	}
}
class MyFather extends MyGrand{
	public MyFather(){ //4
		super(); 
		System.out.println("부모생성자"); //5
	}//6
}

class My extends MyFather{
	//자손생성자에서는 반드시 조상생성자를 호출해야 한다.
	//조상생성자 호출이 생략되어 있으면 JVM에서 super()로 호출한다.
	
	public My(){ //2
		super(); //조상 클래스를 의미??	//3 조상객체? 부모객체? 생성자를 호출? 메모리에 형성이된 조상객체?
		System.out.println("자손생성자"); //7
	}//8
}//end My class



public class Java087_inheritance {
	public static void main(String[] args) {
		My mm=new My();	//1
	
	}//end main	//9
	
	
	
}
