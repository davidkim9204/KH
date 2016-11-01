package java0715_abstract_interface;

abstract class Shape{
	int width;
	int height;
	
	public Shape(int width, int height){
		this.width =width;
		this.height=height;
		
	}
	
	
	void prn(){
		System.out.printf("width=%d height=%d\n",width,height);
	}
	
	abstract double getArea();
	
	
	
	
}

 class Rect extends Shape {
	 int width;
	 int height;
	 
	 public Rect(int width, int height){
		 super(width,height);
		 
	 }
	 
	 double getArea(){
		 return width*height;
	 }
	 
	 

	 
 }//end Rect//////////////////////
 
 class Tri extends Shape {
	 
	 int width;
	 int height;
	 
	 public Tri(int width, int height){
		super(width, height);
		 
	 }
	 
	 double getArae(){
		 return width*height*0.5;
	 }
	 
	 
	
	 
 }//end Tri





public class Java097_abstract {

	public static void main(String[] args) {
		
		//shape 은 추상클래스이므로 객체 생성을 할 수 없다.
		//shape se = new Shape (10,20);
		
		Rect rr=new Rect(10,20);
		System.out.printf("사각형 넓이:",+rr.getArea());
		
		Tri tt= new Tri(10,20);
		System.out.printf("삼각형 넓이:"+tt.getArea());
		
		
		
	}//end main()
	
}//end class
