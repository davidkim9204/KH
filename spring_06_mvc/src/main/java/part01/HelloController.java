package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://127.0.0.1:8080/springmvc/hello.htm이 호출되면 search()실행
//search()가 실행되면 view/part01/hello경로에 있는것을 리턴


@Controller
public class HelloController {

	@RequestMapping("/hello.htm")
	public String search(){
		return "view/part01/hello";
		
	}//end search()
	
}//end class
