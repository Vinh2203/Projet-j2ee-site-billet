package com.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.dao.DaoFactory;
import com.projet.model.Places;
import com.projet.model.Train;
import com.projet.model.Trajet;
import com.projet.model.User;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			@SuppressWarnings("unchecked")
			ArrayList<Places> panier = (ArrayList<Places>) request.getSession().getAttribute("panier");
			User u = (User) request.getSession().getAttribute("user");
			int cpt =0;
			if (panier.size() > 0) {
				double somme = (double) request.getSession().getAttribute("somme_panier");
				response.getWriter().write("<div id='information_passager'>");
				response.getWriter().write("<div id='span_passager'><span >Information Passager</span><br><hr>");
				response.getWriter().write("<form action='https://www.sandbox.paypal.com/cgi-bin/webscr' method='post'>");
				for(Places p : panier){
					response.getWriter().write("<div id='information_passager_item_"+cpt+"'>");	
					response.getWriter().write("<label>Passager "+(cpt+1)+"</label><br /><br />");
					response.getWriter().write("<label>Nom </label>");
					response.getWriter().write("<input style='color:black' id='nom_passager_"+cpt+"' type='text' value='' required /><br><br>");
					response.getWriter().write("<label>Prenom</label>");
					response.getWriter().write("<input style='color:black'  id='prenom_passager_"+cpt+"' required type='text' value=''  />");
					response.getWriter().write("<input  id='places_"+cpt+"' type='hidden' value='"+p.getId()+"'  /><br /><br /><hr>");
					response.getWriter().write("</div>");
					cpt++;
				}
				response.getWriter().write("<label>Email</label>");
				response.getWriter().write("<input style='color:black' name='email' type='text' id='email' required value='' /><br /><hr />");
				response.getWriter().write("<input type='hidden' value=" + somme + " name='amount' />");
				response.getWriter().write("<input name='currency_code' type='hidden' value='EUR' />");
				response.getWriter().write("<input name='shipping' type='hidden' value='0.00' />");
				response.getWriter().write("<input name='tax' type='hidden' value='0.00' />");
				response.getWriter().write(
						"<input name='return' type='hidden' value='http://89.36.213.141:8080/Easyrainway/validationPaiement?' />");
				response.getWriter()
						.write("<input name='cancel_return' type='hidden' value='http://89.36.213.141:8080/Easyrainway/>");
				response.getWriter()
						.write("<input name='notify_url' type='hidden' value='http://89.36.213.141:8080/Easyrainway' />");
				response.getWriter().write("<input name='cmd' type='hidden' value='_xclick' />");
				response.getWriter()
						.write("<input name='business' type='hidden' value='vinh.lkn-facilitator@gmail.com' />");
				response.getWriter().write("<input name='item_name' type='hidden' value='Billet Train' />");
				response.getWriter().write("<input name='no_note' type='hidden' value='1' />");
				response.getWriter().write("<input name='lc' type='hidden' value='FR' />");
				response.getWriter().write("<input name='bn' type='hidden' value='PP-BuyNowBF' />");
				response.getWriter().write("<input name='custom' type='hidden' value='ID_ACHETEUR' />");
				response.getWriter().write("<input id='nombrePassager' type='hidden' value='"+panier.size()+"' />");
				response.getWriter().write("<button type = 'button' id='bEnregristrer' class = 'btn btn-primary' onclick='enregristrerPassager();'>Ok</button>");
				response.getWriter().write("<input id='bPaypal' alt='Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée'  name='submit' style='display:none' src='https://www.paypal.com/fr_FR/FR/i/btn/btn_buynow_LG.gif' type='image' />");
				response.getWriter().write("</form>");
				response.getWriter().write("</div>");
				response.getWriter().write("</div>");

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/reservation.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int number_person = Integer.parseInt((String) request.getParameter("number_person"));
		String id_places = (String) request.getParameter("id_places");
		int nombre_personne = Integer.parseInt((String) request.getParameter("number_person"));
		Long id = Long.parseLong(id_places);
		Places p = DaoFactory.getDaoFactory().getPlacesDao().findPlacesById(id);
		
		
		if (request.getSession().getAttribute("number_panier") == null) {
			request.getSession().setAttribute("number_panier", nombre_personne);
		} else {
			int number_panier = Integer.parseInt(request.getSession().getAttribute("number_panier").toString());
			number_panier = number_panier+nombre_personne;
			request.getSession().setAttribute("number_panier", number_panier);
		}

		if (request.getSession().getAttribute("panier") == null) {
			ArrayList<Places> panier = new ArrayList<Places>();
			for(int cpt = 0 ; cpt < nombre_personne ; cpt++){
				panier.add(p);
			}
			request.getSession().setAttribute("panier", panier);
		} else {
			ArrayList<Places> panier = (ArrayList<Places>) request.getSession().getAttribute("panier");
			for(int cpt = 0 ; cpt < nombre_personne ; cpt++){
				panier.add(p);
			}
			request.getSession().removeAttribute("panier");
			request.getSession().setAttribute("panier", panier);
		}

		if (request.getSession().getAttribute("somme_panier") == null) {
			double somme = p.getPrix()*number_person;
			request.getSession().setAttribute("somme_panier", somme);
		} else {
			double somme = (double) request.getSession().getAttribute("somme_panier");
			somme += p.getPrix()*number_person;
			request.getSession().setAttribute("somme_panier", somme);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/reservation.jsp");
		rd.forward(request, response);
	}

}
