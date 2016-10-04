package com.projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.dao.DaoFactory;
import com.projet.model.User;
import com.projet.model.Ville;

import sun.invoke.empty.Empty;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("email_passager");
		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/index.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String type = (String) request.getParameter("type");
		String id = (String) request.getParameter("id");
		String picture = (String) request.getParameter("picture");

		int type_int = Integer.parseInt(type);

		if (type_int == 1) {// connect facebook
			String name = (String) request.getParameter("name");
			User u = User.checkFacebook(email);
			if (u == null) {
				u = new User();
				u.setEmail(email);
				u.setName(name);
				u.setUrl("https://graph.facebook.com/" + id + "/picture");
				u.setPassword("");
				u.setRole(1);
				DaoFactory.getDaoFactory().getUserDao().addUser(u);
			}
			request.getSession().setAttribute("user", u);
			request.getSession().setAttribute("test", true);
		} else if (type_int == 2) {// connect noraml
			User u = User.check(email, password);
			if (u == null) {
				request.setAttribute("test", false);
				RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/login.jsp");
				rd.forward(request, response);
			} else {
				request.getSession().setAttribute("user", u);
				request.getSession().setAttribute("test", true);
			}
		}else if (type_int == 0) {// connect google
			String name = (String) request.getParameter("name");
			User u = User.checkGoogle(email);
			if (u == null) {
				u = new User();
				u.setEmail(email);
				u.setName(name);
				u.setUrl(picture);
				u.setPassword("");
				u.setRole(0);
				DaoFactory.getDaoFactory().getUserDao().addUser(u);
			}
			request.getSession().setAttribute("user", u);
			request.getSession().setAttribute("test", true);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/index.jsp");
		rd.forward(request, response);
	}

}

