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

@WebServlet("/tupdate")
public class TeacherUpdate extends HttpServlet {
	private static final long serialVersionUID = -1468767919022480124L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String subject=req.getParameter("subject");
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("sal"));
		
		Teacher t=new Teacher();
		t.setSal(sal);
		t.setName(name);
		t.setId(id);
		t.setSubject(subject);
		
		Helper.tx.begin();
		Helper.em.merge(t);
		Helper.tx.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.forward(req, resp);
	}
}
