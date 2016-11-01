package part05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sawonList")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SawonDao dao = new SawonDao();
		
		req.setAttribute("aList", dao.showMethod());
		RequestDispatcher dis = req.getRequestDispatcher("/view/list2.jsp");
		dis.forward(req, resp);	
	}
}
