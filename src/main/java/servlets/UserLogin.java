package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import details.Principal;
import helper.Helper;

@WebServlet("/login")
public class UserLogin extends HttpServlet{
	private static final long serialVersionUID = 8308754123199425401L;

	
	@SuppressWarnings("unchecked")
	protected void ProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		
		Query q=Helper.em.createQuery("select a from Principal a where a.email=?1 and password=?2 ");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<Principal>p=q.getResultList();
		if(p.size()>0) {
			RequestDispatcher rd=req.getRequestDispatcher("Second.html");
			rd.forward(req, resp);
		}
		else {
			pw.println("Invalid Credintials !");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req, resp);
	}
}
