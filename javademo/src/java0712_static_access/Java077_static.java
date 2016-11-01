package java0712_static_access;

class OrderStatic{
	
	static{  //1
		System.out.println("static");
	}
	
	public OrderStatic(){ //2
		System.out.println("constructor");
	}
	
	public void prn(){ //3
		System.out.println("prn");
	}
	
}//end class


public class Java077_static {

	public static void main(String[] args) {
		OrderStatic ss=new OrderStatic();
		ss.prn();
		
		
	}//end main()
	
	
}//end class
