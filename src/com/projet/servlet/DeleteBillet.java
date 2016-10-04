package com.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.dao.DaoFactory;
import com.projet.model.Places;

/**
 * Servlet implementation class DeleteBillet
 */
@WebServlet("/deleteBillet")
public class DeleteBillet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBillet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("id");
		Long id_places = Long.parseLong(id);
		Places p = DaoFactory.getDaoFactory().getPlacesDao().findPlacesById(id_places);
		System.out.println(p.getPrix());
		@SuppressWarnings("unchecked")
		ArrayList<Places> panier = (ArrayList<Places>) request.getSession().getAttribute("panier");
		
		
		System.out.println(panier);
		request.getSession().setAttribute("panier", panier);

		int number_panier = Integer.parseInt(request.getSession().getAttribute("number_panier").toString());
		number_panier--;
		request.getSession().setAttribute("number_panier", number_panier);
		response.getWriter().write(""+number_panier);
	}

}
