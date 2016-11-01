package part11_listener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("part11_listener/di.xml");
		Service svc=(Service)context.getBean("svc");
		svc.prn();
		
		//컨테이너를 소멸 시켜라.
		context.destroy();
		
	}//end main()

}//end class
