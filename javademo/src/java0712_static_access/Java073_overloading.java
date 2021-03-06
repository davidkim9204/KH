package java0712_static_access;
/*
 * 오버로딩(overloading)
 * 1 하나의 클래스에 같은 이름의 메서드를 여러 개 정의 하는 것을 오버로딩이라한다.
 * 2 오버로딩의 조건
 *  1) 메서드의 이름이 같아야 한다.
 *  2) 매개변수의 개수 또는 타입이 달라야 한다.
 *  3) 매개변수는 같고 리턴타입이 다른 경우는 오버로딩이 성립되지 않는다.
 *     (즉 리턴타입은 오버로딩을 구현하는데 아무런 영향을 주지 않는다.)
 */

//비슷한 것을 처리하는 것 끼리는 통합적으로 활용하자.?
class Calculator{
	
	void addValue(double x, double y){
		double res=x+y;
		System.out.println("double값 계산=>"+(x+y));
}
	
//	double addValue(double x, double y){
//		double res=x+y;
//		System.out.println("double값 계산=>"+(x+y));
//		return 0;
//} 리턴 타입은 오버로드에 영향을 주는 요소가 아니다.
	
	

	void addValue(int x, int y){
		System.out.println("int값 계산=>"+(x+y));
		int res=x+y;
	}
	
	void addValue(int x, int y, int z){
		System.out.println("int값 계산=>"+(x+y+z));
	}
	
	
	
//	void sumValue(int x, int y){
//		int res=x+y;
//	}
}//end class
public class Java073_overloading {
	
	public static void main(String[] args) {
		Calculator cal=new Calculator();
		cal.addValue(1.0, 2.0);
		cal.addValue(4, 8);
		cal.addValue(2, 7, 5);
		
		
	}//end main
	
	

}//end class
