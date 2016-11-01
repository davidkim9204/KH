package part01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 
  di는 객체들간의 의존 관계를 느슨하게 하기 위한 목적으로 사용.
  ServiceOracleImp를 직접 호출해서 사용하지 않고 환경설정에 등록해서 사용.
  
  참조가 되는 객체들을 정의할 때는 interface를 상속받아 오버라이딩+무인자 생성자를 정의함. -> 환경설정에서 정의함.
  
  
  스프링에서 환경설정을 잡는 방법 -> container에 생성해서 저장.
  1. xml (bean이라는 요소를 이용해서 적용)
  2. annotation
  환경설정에서 사용하는 상수값은 properties 확장자(파일)에 저장. 
  
  환경설정에 선언되어 있는(part01/di.xml) bean들을 생성해주고 관리해주는 객체를 컨테이너라고 부름.
  컨테이너(container) - 컨테이너에 bean들이 생성되는 시점이 다름.
  1. BeanFactory container							: getBean()을 호출 할 때 bean생성됨.
  2. ApplicationContext container					: 컨테이너가 생성이 될 때 bean들도 같이 생성됨.
  3. WebApplication Context container (웹에서 사용) : was(Tomcat)이 실행이 될 때 bean들이 생성됨.
 
*/
public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("part01/di.xml");
		//getBean은 Object라서 Service로 다운캐스팅 작업 필요.
		/*Service svc=(Service)context.getBean("svc");
		svc.prn();*/
		
		
	}//end main()

}//end class
