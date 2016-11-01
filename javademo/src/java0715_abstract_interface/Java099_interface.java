package java0715_abstract_interface;

import java.io.Serializable;  //ctrl shift o사용하면 바로 임폴트 된다.

/*
 * 인터페이스(interface)
 * 1 추상메소드와 상수만 가지고 있는 형태이다.
 * 2 클래스 작성에 도움을 줄 목적으로  제공이 되는 표준 명세서이다.
 * 3 implements : 클래스에 인터페이스를 상속할때 사용되는 키워드이다.
 * 4 인터페이스는 다중상속이 된다.
 * 5 인터페이스는 접근제어자로 public, protected만 제공된다.
 *   default로 선언된 멤버변수,메소드는 컴파일러에서 public으로 처리한다.
 * 6 인터페이스에서는 추상메소드에 abstract키워드는 명시 하지 않으면
 *   컴파일러가 abstract키워드를 붙여 처리한다.
 */


interface CarRun{
	int car_count=0; //public static final을 붙여서 처리. final 이 붙기 때문에 반드시 값을 부여해야한다.
	void work();	//public abstract
}



class TrunkRun implements CarRun, Serializable{ //뒤에서 ctrl enter도 가능하다.

	@Override
	public void work() {
		System.out.println("트럭이 짐을 싣고 있다.");
		
	}
	
	
}

public class Java099_interface {

	public static void main(String[] args) {
		//인터페이스는 객체생성을 할 수 없다.
		//CarRun cr=new CarRun();  불완전하기 때문에 객체생성불가.
		TrunkRun tr=new TrunkRun();
		tr.work();
		
		//자바와db연동 처리를 할때 인터페이스로 한다??
		
		
	}
	
}
