package part02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("part02/di.xml");
		Service svc=(Service)context.getBean("svc1");
		svc.prn1();
		
		Service svc2=(Service)context.getBean("svc2");
		svc2.prn2();
		
		Service svc3=(Service)context.getBean("svc3");
		svc3.prn3();
		
		
	}//end main()
}//end class
