package java0711_class;

/*
 * this:객체 자신을 의미한다.
 * this.멤버변수
 * this.메소드()
 * this()
 * 
 */

class CustomerList{
	String name;
	char gen;
	String addr;
	
	public CustomerList() { //생성자 안에서 다른 생성자를 호출.
		this("홍길동",'남', "충청남도");
		
	} 
	//new 객체 지정을 해야 this를 사용할 수 있다.
	
	public CustomerList(String name, char gen, String addr) { //2
		this.name=name; //멤버 변수인지 매계변수인지 파악하기 위해서 this를 멤버변수로 생각하면 된다.
		this.gen=gen;
		this.addr=addr;
		//멤버변수와 매개변수가 다를때는 멤버변수에 this키워드를 사용하지 않아도 된다.
		//멤버변수와 매개변수가 같을 때는 멤버변수에this키워드를 사용한다.
		
		//name=n; //멤버변수와 매계 변수가 다를때는  this 필요없다. 
		
	}
	
	public void prn() {
		System.out.printf("%s %c %s\n", name, gen, addr);
		
	}
	
	public void call() {
		this.prn();
		//prn(); //결과는 같다. 일반적으로는 붙이지 않고 호출한다
	}
	
	
	
	
}//end class


public class Java063_constructor {

	public static void main(String[] args) {
		CustomerList cm=new CustomerList("이도룡", '남', "서울 종로구 가산동");
		cm.prn();
		
		
		CustomerList cs=new CustomerList();
		cs.prn();
		
		System.out.println("/////////////////////////////////////////////////");
		
		CustomerList[] cc =new CustomerList[2];
		// cc[0]=cm;
		cc[0]=new CustomerList("이도룡", '남', "서울 종로구 가산동");//바로 이런방식도 가능.
		cc[1]=new CustomerList();
		
		for(int i=0;i<cc.length;i++)
			cc[i].prn();
		
		
		//cs.call();
	
	
	}//end main()
	
}//end class
