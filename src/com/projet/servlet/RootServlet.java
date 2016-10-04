package com.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.model.Comparator;
import com.projet.model.Places;
import com.projet.model.User;
import com.projet.model.Ville;
import com.projet.dao.DaoFactory;

/*
 * Controller qui s'execute quand on est � la racine du contexte, donc au lancement de l'application (http://localhost:port/suptrip/)
 * Chemin a pr�ciser dans le fichier web.xml
 * 
 */

@WebServlet("/home")
public class RootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RootServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean test =  (Boolean) request.getSession().getAttribute("test");
		List<Ville> list_ville = DaoFactory.getDaoFactory().getVilleDao().getAllVille();
		Comparator compare = new Comparator();
		Collections.sort(list_ville,compare);
		request.getSession().setAttribute("listVille", list_ville);
		
		if(test == null){
			RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/login.jsp");
			rd.forward(request, response);
		}else{
			if(test == false){
				RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/login.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/index.jsp");
				rd.forward(request, response);
			}	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
