package com.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.model.Places;
import com.projet.model.User;
import com.projet.dao.DaoFactory;

/*
 * Controller qui s'execute quand on est � la racine du contexte, donc au lancement de l'application (http://localhost:port/suptrip/)
 * Chemin a pr�ciser dans le fichier web.xml
 * 
 */

@WebServlet("/deconnecter")
public class Deconnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Deconnecter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("test");
		request.getSession().removeAttribute("user");
		ArrayList<Places> list = new ArrayList<Places>();
		request.getSession().setAttribute("panier", list);
		request.getSession().removeAttribute("number_panier");
		request.getSession().removeAttribute("somme_panier");
		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
