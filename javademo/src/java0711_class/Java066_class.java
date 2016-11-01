package java0711_class;

/*피자의 반지름을 10, 도넛의 반지름은 2로 한다.
 * 
 * [실행결과]
 * 자바피자의 면적은 314.0
 * 자바도넛의 면적은 12.56
 */

 class Circle {
	int radius; // 원의 반지름을 저장하는 멤버 변수	
	String name; // 원의 이름을 저장하는 멤버 변수

	public double getArea() { // 멤버 메소드
		return 3.14*radius*radius;
	}
}//end class////////////////////////


public class Java066_class {

	public static void main(String[] args) {
	  //여기를 구현하세요.////////////////////	
		Circle pz=new Circle(); //생성자. 데이터 형성이 다른것을 이해한다. bk는 객체참조변수
		pz.name="피자";
		pz.radius=10;
		System.out.printf("자바%s의 면적은 %f.1\n", pz.name, pz.getArea());
		
		Circle dn=new Circle();
		dn.name="도넛";
		dn.radius=2;
		System.out.printf("자바%.2s의 면적은 %f.2\n", dn.name, dn.getArea());

		
		
		///솔루션
		
		Circle pizza;
		pizza=new Circle();
		pizza.radius =10;
		pizza.name="자바피자";
		double area = pizza.getArea();
		System.out.println(pizza.name+"의 면적은"+area);
		
		Circle donut = new Circle();
		pizza.radius =10;
		pizza.name="자바피자";
		area = donut.getArea();
		System.out.println(donut.name+"의 면적은"+area);
		
		
		
		
	}//end main()

}//end class







