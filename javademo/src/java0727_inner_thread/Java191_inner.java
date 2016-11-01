package java0727_inner_thread;

abstract class InnerAnonymous{
	abstract void prn();
	
}//end InnerAnonymous

class Test extends InnerAnonymous{
	void prn(){}
}//익명클래슨느 이것처럼 클래스명을 가지고 있지않다.


class OuterAnonymous{
	private int x;
	
	public void call(){
		InnerAnonymous tt= new InnerAnonymous(){
			@Override
			void prn(){
				x=5;
				System.out.println(x);
			}
		}; //세미콜론 반드시 해야한다.
		
		tt.prn();
		
	}//end call()
}//end OuterAnonymous

public class Java191_inner {

	public static void main(String[] args) {
		OuterAnonymous outer = new OuterAnonymous();
		outer.call(); 
		
		
		
	}//end main()
}//end class
