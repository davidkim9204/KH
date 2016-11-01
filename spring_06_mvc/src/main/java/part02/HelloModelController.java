package part02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/springmvc/view/part02/helloModel.htm이 호출되면 search() 실행.
// search()가 실행되면 /view/part02/helloModel.htm 실행.

@Controller
public class HelloModelController {
	
	@RequestMapping("/view/part02/helloModel.htm")
	public Model search(){
		/*실제로 사용할 일 없음.*/
		Model model=new ExtendedModelMap();
		model.addAttribute("id","korea");
		
		return model;
		
	}

}//end class
