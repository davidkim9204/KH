package java0715_abstract_interface;

/*
 * instaceof 객체를 비교하기 위한 연산자이다.
 * a instacneof A
 * a객체가 A타입이면 true 아니면 false를 리턴한다.
 */





public class Java110_binding {

	public static void main(String[] args) {
	Tv tv=new LgTv2();
	process(tv);
	
	//tv=new SamsungTv2();	
		
	}//end main()
	
	public static void process(Tv tv){
		
		if (tv instanceof LgTv2){
		
		LgTv2 lg=(LgTv2)tv;
		System.out.println(lg.toMessage());
		
		//lg.toMessage();
		}else{
			
			SamsungTv2 ss= (SamsungTv2) tv;
			//ss.toHello();
			System.out.println(ss.toHello());
			
			
		}
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
		
	}
		

	
	
	
}//end class
