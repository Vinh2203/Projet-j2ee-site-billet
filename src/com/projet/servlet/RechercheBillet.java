package com.projet.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.model.Places;
import com.projet.model.Trajet;
import com.projet.restful.RestClient;

/**
 * Servlet implementation class rechercheBillet
 */
@WebServlet("/rechercheBillet")
public class RechercheBillet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheBillet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/rechecheBillet.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long villeDept = Long.parseLong((String) request.getParameter("villeDept"));
		long villeDest = Long.parseLong((String) request.getParameter("villeDest"));
		String dateDept = (String) request.getParameter("dateDept");
		String dateRetour = (String) request.getParameter("dateRetour");
		String heureDept = (String) request.getParameter("heureDept");
		String heureRetour = (String) request.getParameter("heureRetour");
		String type_class = (String) request.getParameter("typeClass");
		String type_trajet = (String) request.getParameter("type_trajet");
		String[] tabDateDept = dateDept.split("/");
		String[] tabDateRetour = dateRetour.split("/");
		
		GregorianCalendar myCal = new GregorianCalendar(Integer.parseInt(tabDateDept[2]),
									Integer.parseInt(tabDateDept[1])-1,Integer.parseInt(tabDateDept[0]));
        String date = tabDateDept[2]+"-"+tabDateDept[1]+"-"+tabDateDept[0];
        int typeDate = 0;
        if(myCal.get(Calendar.DAY_OF_WEEK)== 7){
        	typeDate = 1 ;// 1 is samedi
        }else   if(myCal.get(Calendar.DAY_OF_WEEK)== 1){
        	typeDate = 2; // 2 is Dimanche
        }
		RestClient rc = new RestClient(villeDept,villeDest,heureDept,typeDate,date);
		List<Trajet> list = rc.getTrajets();
		HashMap<Long,Places> list_places = Places.searchPlaces(list,date,type_class);
		request.setAttribute("liste_places",list_places);
		request.setAttribute("liste_trajet",list);
		request.getSession().setAttribute("ville_dept", villeDept);
		request.getSession().setAttribute("ville_dest", villeDest);
		request.getSession().setAttribute("dateDept", tabDateDept[1]+"/"+tabDateDept[0]+"/"+tabDateDept[2]);
		request.getSession().setAttribute("heureDept", Integer.parseInt(heureDept));
		if(tabDateRetour.length > 1){		
			request.getSession().setAttribute("heureDept", Integer.parseInt(heureDept));
			request.getSession().setAttribute("dateRetour", tabDateRetour[1]+"/"+tabDateRetour[0]+"/"+tabDateRetour[2]);
		}
		request.getSession().setAttribute("heureRetour", Integer.parseInt(heureRetour));
		request.getSession().setAttribute("typeClass", Integer.parseInt(type_class));
		request.getSession().setAttribute("type_trajet", Integer.parseInt(type_trajet));
		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/rechecheBillet.jsp");
		rd.forward(request, response);
	}

}
