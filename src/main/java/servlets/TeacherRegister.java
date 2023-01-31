package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import details.Teacher;
import helper.Helper;
@WebServlet("/teacherRegister")
public class TeacherRegister extends HttpServlet{
	private static final long serialVersionUID = -995071416538274040L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		double sal=Double.parseDouble(req.getParameter("sal"));
		int id=Integer.parseInt(req.getParameter("id"));
		
		Teacher t=new Teacher();
		t.setId(id);
		t.setName(name);
		t.setSal(sal);
		t.setSubject(subject);
		
		Helper.tx.begin();
		Helper.em.persist(t);
		Helper.tx.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.forward(req, resp);
	}

}
