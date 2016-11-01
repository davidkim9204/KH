package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu1Controller {
	
	@RequestMapping("/menu1.do")
	public String process(){
		return "menu1";
	}
	
	@RequestMapping("/menu2.do")
	public String process2(){
		return "menu2";
	}
	
	
}//end class
