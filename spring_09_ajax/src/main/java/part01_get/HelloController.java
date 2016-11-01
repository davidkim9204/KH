package part01_get;

/*전체 화면은 고정되어 있는데 특정 부분만 움직이고 싶은 경우 ajax를 사용.
ex) 네이버 지도 이용시 다른고 고정 지도만 움직이는거 or 검색어 작성할 때 연관검색어만 뜨게 하는 것*/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
//	ajax 사용 X -> 클라이언트와 서버 직접 연결
	@RequestMapping("/hello.do")
	public String form(){
		return "part01_get/start";
	}
	
//	ajax 사용 O -> 클라이언트와 XMLHttpRequest연결하고 서버와 연결. 처리되어도 주소가 변환 X
	@RequestMapping("/customer.do")
	public ModelAndView process(String name){
		ModelAndView mav=new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("part01_get/result");
		return mav;
	}
	
	
	
}//end class
