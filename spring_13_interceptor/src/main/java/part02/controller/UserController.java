package part02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import part02.dto.PersonDTO;

@Controller
public class UserController {
	public UserController() {

	}

	@RequestMapping("/login.do")
	public String loginProcess() {
		return "part02/loginForm";
	}

	@RequestMapping("/logpro.do")
	public String logCheckProcess(String returnUrl, PersonDTO dto, HttpSession session) {
		System.out.println("url:" + returnUrl);

		if (dto.getId().equals("kim") && dto.getPass().equals("1234")) {
			session.setAttribute("chk", dto.getId());
			if (returnUrl != "") {
				return "redirect:/" + returnUrl;
			} else {
				return "redirect:/index.do";
			}
		} else {
			return "redirect:/index.do";
		}
	}// end logCheckProcess()

	@RequestMapping("/logout.do")
	public String logoutProcess(HttpSession session) {
		session.removeAttribute("chk");
		return "redirect:/index.do";
	}

}// end class()
