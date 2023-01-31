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

@WebServlet("/studentAdd")
public class StudentRegister extends HttpServlet{

	private static final long serialVersionUID = -8622931692206298515L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String yop=req.getParameter("yop");
		
		Student s=new Student();
		s.setName(name);
		s.setStream(stream);
		s.setYop(yop);
		
		Helper.tx.begin();
		Helper.em.persist(s);
		Helper.tx.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Student.html");
		rd.forward(req, resp);
	}
}
