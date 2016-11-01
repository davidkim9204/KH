package picturePreview;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@WebServlet("/uploadMain")
public class TestUploadControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis= req.getRequestDispatcher("picturePreview/insert.jsp");
				dis.forward(req,resp);
	}//end doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println(req.getParameter("filepath"));  파일 선택하고나면 콘솔창에서 확인하면 null이 나옴. 파일명이 나오는 것이 아니고. 이유는 쉬는시간에 다시 물어보자
		MultipartRequest multi=null;
		
		//String saveDirectory="c:/temp/";
		String root=req.getRealPath("/");
		String saveDirectory=root+"temp";
		
		File file=new File(saveDirectory);
		if(!file.isDirectory())
			file.mkdir();
		int maxPostSize=1*1000*1000*1000; //1GB
		String encoding="UTF-8";
		//defaultfilerenamepoilicy() : 중복된 파일 이름을 피하게해줌.
		multi=new MultipartRequest(req, saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());
		//System.out.println(multi.getFilesystemName("filepath"));
		TestDAO dao=TestDAO.getInstance();
		dao.insertMethod(multi.getFilesystemName("filepath"));
		resp.sendRedirect("previewList");
	}//end doPost
}//end class
