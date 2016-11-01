package java0712_static_access;

class StaticTest{
	
	
	int x;
	int y;
	static int k;
	static int m;
	
			
	public static void process(int x, int y){
		//this.x=x;   //static 때문에  this를 사용할 수 없다.
		//this.y=y;
		
		k=x;
		k=y;
		
		//x,y 멤버변수가 비-static이므로 static이 선언된 process()메소드에서
		//호출할 수 없다.
		
		
		
	}
}//end class

public class Java079_static {

	
	public static void main(String[] args) {
		
	}//end main()
	
}//end class
