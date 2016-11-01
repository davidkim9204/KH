package part04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloCommandController {
	
	@RequestMapping(value="/mem.htm",method=RequestMethod.GET)
	public String form(){
		return "view/part04/memForm";
	}//end form()
	
	/*@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public ModelAndView submit(String name, int age){
		ModelAndView mav=new ModelAndView();
		mav.addObject("name",name);
		mav.addObject("age", age);
		mav.setViewName("view/part04/memPro");
		return mav;
		
	}//end submit()
*/	
	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public String submit(@ModelAttribute("dto") MemDTO dto){
		return "view/part04/memPro";
	}//end submit()
	
/*	
  	멤버변수가 같으면 객체로 받을 수 있음. dto 객체로받았는데 MemDTO에 있는 멤버변수와 같으면 받을 수 있음.
	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public String submit(MemDTO dto){
		return "view/part04/memPro";
	}//end submit()
*/	
}//end class
