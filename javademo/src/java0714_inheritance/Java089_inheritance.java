package java0714_inheritance;

class Parent {
	String name;
	int age;
	
	public Parent(){
		
	}

	public Parent(String name, int age) { //4
	
		this.name = name; //5
		this.age = age; //6
	}//7
	
}//end class

class Sun extends Parent {
	String dept;
	public Sun(){
		
	}	
	
	public Sun(String name, int age, String dept){ //2
		super(name,age); //자손은 부모꺼 받아야함. 뒤에 있으면 안됨. //3 
		this.dept=dept; //8
		
	}//9
	
	public void prn() { //11
		System.out.printf("%s %d %s\n", name, age, dept); //12
		
	} //13
	
}//end class




public class Java089_inheritance {
	public static void main(String[] args) {
		Sun ss=new Sun("홍길동",50,"기획부");  //1
		ss.prn(); //10
	
	}//end main //14
	
}//end class





//오버라이딩이 되려면 상속이 되어야한다.
