package part06_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바코드에서 이노테이션을 이요한 스프링 환경설정

//현재 클레스(Config)를 스프링 환경설정으로 사용하겠다는 의미.
@Configuration
public class Config {

	public Config(){
		
	}
	
	// xml이용해서 user()표현한 방법. 
	// <bean id="user" class="part6_annotation.User">
	//  <constructor-age value="kim" />
	//  <constructor-age value="a1234" />
	// </bean>
	public User user(){
		return new User("kim","1234");
	}
	
	// xml이용해서 svc()표현했던 방법.
	// <bean id="svc" class="part6_annotation.ServiceImp">
	//	<constructor-args ref="user"/>
	// </bean>
	@Bean
	public ServiceImp svc(){
		return new ServiceImp(user());
	}
	
	//serviceImp()메소드를 사용 할때 ss라는 이름으로 호출해서 사용이 가능.
	//@Bean을 선언할 때 name속성을 지정하면 name속성의 값이 빈ID가 된다. 
	@Bean(name="ss")
	public ServiceImp serviceImp(){
		return new ServiceImp(user());
	}
}//end class
