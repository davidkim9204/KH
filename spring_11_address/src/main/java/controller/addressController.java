package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addressController {
	
	@RequestMapping("/add.do")
	public String addressForm(){
		return "address";
	}
	
}
