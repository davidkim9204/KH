package guestdemo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class ViewAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		//파라미터값(웹 주소)은 전부다 문자열로 받아들임.
/*		String number = req.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();
		dao.readCountMethod(Integer.parseInt(number));
		BoardDTO dto = dao.viewMethod(Integer.parseInt(number));
		req.setAttribute("dto", dto);
*/		
		BoardDAO dao = BoardDAO.getInstance();
		int num = Integer.parseInt(req.getParameter("num"));
		dao.readCountMethod(num);
		BoardDTO dto = dao.viewMethod(num);
		req.setAttribute("dto", dto);
	}//end execute
}//end class
