package com.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RechercheBilletDetail
 */
@WebServlet("/RechercheBilletDetail")
public class RechercheBilletDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheBilletDetail() {
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
		String id_places = (String) request.getParameter("id_places");
		
		response.getWriter().write("<form action="+request.getContextPath()+"/reservation method='POST'>");
		response.getWriter().write("<img alt='' src='./webroot/image/person.png' /><a id='add_person' title='ajouter voyageur' href='javascript:void(0);' onclick='addPerson();'>(+1)</a>");
		response.getWriter().write("<input name='id_places' type='hidden' value="+id_places+" />");
		response.getWriter().write("<input name='number_person' id='number_person' type='hidden' value='1' /><br>");
		response.getWriter().write("<input id='delete_espace' type='hidden' style='margin-left:30px' /><br>");
		response.getWriter().write("<button type='submit' id='button_choisir'>Choisir cet aller</button>");
		response.getWriter().write("</form>");
	}

}
