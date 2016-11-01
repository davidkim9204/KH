package simple03;

/*
 * factory를 이용하면 결합도가 인터페이스를 사용 하는 것 보다는 낮기는 하지만 
 * Factory가 정확히 구현되어 있지 않으면 참조하는 객체에 영향을 끼친다.
 */

public class HelloSpring {
	//새로운 객체 new MessageFactory를 사용X. 결합도를 낮추기 위해.
	public static void main(String[] args) {
		MessageBean bean = MessageFactory.getInstance("ko");
		bean.sayHello("스프링");

		bean = MessageFactory.getInstance("en");
		bean.sayHello("spring");
	}// end main()

}// end class
