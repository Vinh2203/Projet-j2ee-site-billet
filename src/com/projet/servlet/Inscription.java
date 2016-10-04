package com.projet.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.dao.DaoFactory;
import com.projet.model.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password =(String) request.getParameter("password");
		String nom = (String) request.getParameter("name_user");
		String email = (String) request.getParameter("email");
		
		if(User.existEmail(email)){
			request.setAttribute("login", "1");
			RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/inscription.jsp");
			rd.forward(request, response);
		}else{
			User u = new User(null, nom, email,User.getMD5(password), "", 1);
			DaoFactory.getDaoFactory().getUserDao().addUser(u);
			request.getSession().setAttribute("user", u);
			request.getSession().setAttribute("test", true);
			RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/index.jsp");
			rd.forward(request, response);
		}
	}

}
