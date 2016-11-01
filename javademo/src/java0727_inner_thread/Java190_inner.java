package java0727_inner_thread;
/*
 * 지역클래스에서 외부클래스 메서드의 매개변수, 지역변수를
 * 호출하기 위해서는 final이 선언되여 있어야 한다.
 * 하지만, jdk8버전부터는 final이 선언되여 있지 않아도 호출이 가능하다.
 */


class OuterLocal{
	private int x;
	static int y;
	final private int z=10;
	
	
	public void call(final int a){ //여기서 final은 8.0부터 자동으로 붙여서 사용한다.
		final int b=20; //여기서도 final을 알아서 붙여서 처리함. 하지만 7.0을 쓰는 안드로이드는 반드시 필요함.
		int c=30;
		c=50; //final없으면 일반변수처럼 처리 하지만 inner에 들어가면 자동으로 final붙여 사용한다.
		class InnerLocal{
			void prn(){
				x=5;
				y=150;
				System.out.println("x="+x);
				System.out.println("y="+y);
				System.out.println("z="+z);
				System.out.println("a="+a);
				System.out.println("b="+b);
				c=40;
				System.out.println("c="+c);
			}
			
		}//end InnerLocal
		
		InnerLocal inner= new InnerLocal();
		inner.prn();
		
		
		
		
	}//end call()
	
}//end OuterLocal

public class Java190_inner {

	public static void main(String[] args) {
		OuterLocal outer = new OuterLocal();
		outer.call(100);
		
		
	}//end main()
}//end class
