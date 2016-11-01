package java0715_abstract_interface;

/*
 * 클래스 : 일반 클래스, 추상클래스, 인터페이스, (공식아님 이해를 위한)
 * 
 * 
 * 
 * 
 * 메소드 정의 : 메소드 선언부 + 메소드 구현부
 * void prn()     선언부   ///  구현부     {}
 * 
 * 추상메소드 : 구현부가 없는 메소드이다.
 *  abstract void prn();
 *  
 *  추상클래스 : 추상메소드를 가지고 있는 클래스이다.
 *   abstract class Test{ }
 *   
 *  추상클래스 제공 목적 : 추상메소드를 강제적으로 오버라이딩하고 
 *                   객체생성을 할 수 없도록 하기 위해서
 */

//class명은 한글을 쓰지 않는 것이 좋다. 다른 프로그램과 혼용해서 사용하므로.

//override,overloading은 다양성을 제공해준다.

abstract class CarAbs{  //완전하지 않아서 객체를 생성하지 않ㄷ로고 한다. 추상메소드를 강제적으로 오버라이딩하게 하는게 추상클래스이다.
	//객체하나당 클래스가 하나씩이면 너무 많은데 상속으로 사용. 그래서 기본적으로 메소드를 상속받는다. 
	int speed=0;
	String color;
	
	void upSpeed(int speed){
		this.speed=speed;
	}
	
	abstract void work();
	
}// 추상크라스는 불완전한다.


class SendaAbs extends CarAbs{
	
	@Override
	void work() {
		System.out.println("승용차가 사람을 태우고 있습니다."); //하는 행위는 비슷해서 묶음.
		
	}
}//end SendaAbs///////////////

class TruckAbs extends CarAbs{
	
	@Override
	void work() {
		System.out.println("트럭이 집을 싣고 있습니다.");
		
	}
}// end TruckAbs////////////////


public class java096_abstract {

	public static void main(String[] args) {
		//추상클래스는 객체생성을 할 수 없다.
		//CarAbs cs=new CarAbs();
		
		SendaAbs sedan=new SendaAbs();
		sedan.work();
		
		TruckAbs truck=new TruckAbs();
		truck.work();
		
		
	}//end main()
	
}//end class
