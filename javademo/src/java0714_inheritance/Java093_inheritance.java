package java0714_inheritance;

/*
 * [출력결과]
 * 1000량의 물을 뿌린다
 * 8인승 차량입니다.
 */
class Car{
	int speed;
	String color;
	void setSpeed(int speed) {
		this.speed = speed;
	}

	void stop() {
		speed = 0;
	}
}

class FireEngine extends Car {	
	private long water;
	
	public void setWater(long water) {
		this.water = water;
	}

	void waterSpread() {
		System.out.println(water + "량의 물을 뿌린다");
	}	
}

class OwnerEngine  extends Car{	
	private int seat;
	
	  public void setSeat(int seat) {
		this.seat = seat;
	}
	
	void prn(){
		System.out.println(seat+"인승 차량입니다.");
	}
}
public class Java093_inheritance {

	public static void main(String[] args) {
		//여기를 구현하세요
		FireEngine water=new FireEngine(); 
		water.setWater(1000);
		water.waterSpread();
		
		OwnerEngine ol=new OwnerEngine();
		ol.setSeat(8);
		ol.prn();
		
		
	}//end main()

}

//객체 중심언어는 확장성을 가진다. class를 상속을 활용하여 묶는다.?
