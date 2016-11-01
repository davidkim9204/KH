package part06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cityList")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
cityDAO dao = new cityDAO();
		
		req.setAttribute("aList", dao.printMethod());
		RequestDispatcher dis = req.getRequestDispatcher("/view/list3.jsp");
		dis.forward(req, resp);	
		
	}
}