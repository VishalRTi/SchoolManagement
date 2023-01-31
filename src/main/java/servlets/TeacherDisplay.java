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

import details.Teacher;
import helper.Helper;

@WebServlet("/teacherDisplay")
public class TeacherDisplay extends HttpServlet {
	private static final long serialVersionUID = -2759277361511943895L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Query q=Helper.em.createQuery("select a from Teacher a");
		@SuppressWarnings("unchecked")
		List<Teacher>t=q.getResultList();
		HttpSession hs=req.getSession();
		hs.setAttribute("teacher", t);
		
		RequestDispatcher rd=req.getRequestDispatcher("TeacherDisplay.jsp");
		rd.forward(req, resp);
		
	}
}
