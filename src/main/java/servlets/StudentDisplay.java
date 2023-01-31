package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import details.Student;
import helper.Helper;

@WebServlet("/studentDisplay")
public class StudentDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Query q=Helper.em.createQuery("select a from Student a");
		List<Student>s=q.getResultList();
		
		HttpSession hs=req.getSession();
		hs.setAttribute("Student", s);
		
		RequestDispatcher rd=req.getRequestDispatcher("StudentDisplay.jsp");
		rd.forward(req, resp);
	}
}
