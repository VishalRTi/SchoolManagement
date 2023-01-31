package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import details.Principal;
import helper.Helper;

@WebServlet("/register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 6326673919060115261L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		int age=Integer.parseInt(req.getParameter("age"));
		long phno=Long.parseLong(req.getParameter("phno"));
		
		Principal u=new Principal();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		u.setAge(age);
		u.setPhno(phno);
		
		Helper.tx.begin();
		Helper.em.persist(u);
		Helper.tx.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
	}
}
