package java0711_class;

class Rect{
	int width;
	int height;
	
	public Rect() {
		
	}
	
	int girth() {
		//사각형의 둘레를 구하는 로직
		return (width+height)*2;
		
		
	}
	
	//사각형의 넓이를 구하는 로직
	int area(){
		return width*height;
	}
	
	
	
	
	
}//end class


public class Java064_class {

	public static void main(String[] args) {
	
		Rect rt=new Rect();
		rt.width=5;
		rt.height=3;
		System.out.printf("둘레:"+rt.girth());
		System.out.printf("넓이:"+rt.area());
	
	
	
}//end main()
	
	
}//end class
