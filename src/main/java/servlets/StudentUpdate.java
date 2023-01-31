package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import details.Student;
import helper.Helper;

@WebServlet("/updatet")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 965473228621690785L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String yop=req.getParameter("yop");
		
		Helper.tx.begin();
		
		Student s=Helper.em.find(Student.class,id);
		s.setId(id);
		s.setName(name);
		s.setStream(stream);
		s.setYop(yop);
		
		Helper.em.merge(s);
		Helper.tx.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Student.html");
		rd.forward(req, resp);
		
	}
}
