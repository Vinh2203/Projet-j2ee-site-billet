package com.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.model.Places;

/**
 * Servlet implementation class Panier
 */
@WebServlet("/panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("panier") == null){
			RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/index.jsp");
			rd.forward(request, response);
		}else{
			@SuppressWarnings("unchecked")
			ArrayList<Places> panier = (ArrayList<Places>) request.getSession().getAttribute("panier");
			if(panier.size() > 0){
				RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/reservation.jsp");
				rd.forward(request, response);
			}else{	
				RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/index.jsp");
				rd.forward(request, response);
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
