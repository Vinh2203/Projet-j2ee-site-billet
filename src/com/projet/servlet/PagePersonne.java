package com.projet.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.projet.dao.DaoFactory;
import com.projet.model.Billet;
import com.projet.model.Places;
import com.projet.model.Reservation;
import com.projet.model.User;

/**
 * Servlet implementation class PagePersonne
 */
@WebServlet("/auth/page_personne")
public class PagePersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagePersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id_billet") != null){
			try {
					Long  id = Long.parseLong(request.getParameter("id_billet"));
					Billet billet = DaoFactory.getDaoFactory().getBilletDao().findBilletById(id);
					Document document = new Document(PageSize.A4);
					String path = System.getProperty("user.dir");
					String nom_billet = User.getMD5(billet.getNom_client()+ new Date()+Math.random() * 500 + 1);
					PdfWriter.getInstance(document, new FileOutputStream(path + "/"+nom_billet+".pdf"));
					document.open();
					StringBuilder sb = new StringBuilder();
					sb.append("<b>&nbsp;<font align=\"center\" color=\"black\">Billet Electronique</font></b>");
					sb.append("<div>\n<span align=\"left\">Date Depart : "+Billet.convertDate(billet.getDateDept())+"</span>");
					sb.append("\n<span align=\"right\">Voyageur : "+billet.getNom_client()+"</span>");
					sb.append("<br /><hr />");
					sb.append("\n<span align=\"right\">"+billet.getHeureDept()+" :"+billet.getVille_dept()+"</span><br />");
					sb.append("\n<span align=\"right\">"+billet.getHeureArrive()+" :"+billet.getVille_arrive()+"</span>");
					sb.append("\n<span align=\"right\">Classe : "+billet.getType_class()+"</span>");
					sb.append("\n<span align=\"right\">Prix : "+billet.getPrix()+" €</span>");
					sb.append("\n</div>");
		
					PdfPTable table = new PdfPTable(1);
					PdfPCell cell = new PdfPCell();
					ElementList list = XMLWorkerHelper.parseToElementList(sb.toString(), null);
					for (Element element : list) {
						cell.addElement(element);
					}
					table.addCell(cell);
					document.add(table);
					document.close();
					String file = path + "/"+nom_billet+".pdf";
					response.getWriter().write(file);
				
			} catch (DocumentException de) {
				de.printStackTrace();

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}else if(request.getParameter("email") != null){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			User u = (User) request.getSession().getAttribute("user");
			u.setEmail(email);
			u.setName(name);
			u.setPassword(User.getMD5(password));
			DaoFactory.getDaoFactory().getUserDao().updateUser(u);
			
		}
		else{
			User u = (User) request.getSession().getAttribute("user");
			List<Reservation> list = Reservation.searchReservationByUser(u.getId());
			
			request.setAttribute("list_reservation", list);
			RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/pagePersonne.jsp");
			rd.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id_reservation") != null){
			long id = Long.parseLong(request.getParameter("id_reservation"));
			List<Billet> list = Billet.searchBilletByIdReservation(id);
			for(Billet billet : list){
				response.getWriter().write("<div id='billet_"+billet.getId()+"' >");
				response.getWriter().write("<span> Date Depart :"+billet.convertDate(billet.getDateDept())+"</span>");
				response.getWriter().write("<div id='billet_info_left'>");
				response.getWriter().write("<span>"+billet.convertTime(billet.getHeureDept())+"</span>");
				response.getWriter().write("<span style='margin-left: 5px'>"+billet.getVille_dept()+"</span><br />");
				response.getWriter().write("<span>"+billet.convertTime(billet.getHeureArrive())+" </span>");
				response.getWriter().write("<span style='margin-left: 5xp'>"+billet.getVille_arrive()+"</span>");
				response.getWriter().write("</div>");
				response.getWriter().write("<div id='billet_info_right'>");
				response.getWriter().write("<span>Classe :"+billet.getType_class()+"</span><br>");
				response.getWriter().write("<span>"+billet.getPrix()+" &euro;</span><br>");
				response.getWriter().write("</div>");
				System.out.println(billet.timeIsPass());
				if(billet.timeIsPass() == false){
				response.getWriter().write("<button id='bSupprimer' onclick='supprimerBillet("+billet.getId()+")' "
						+ "type = 'button' class = 'btn btn-danger'>Supprimer</button>");
				}
				response.getWriter().write("<button type='button' class='btn btn-success' onclick='telechargerBillet("+billet.getId()+");'>Telecharger</button>");
				
				response.getWriter().write("<hr>");
				response.getWriter().write("</div>");
				
			}
		}
		
		if(request.getParameter("id_billet") != null){
			long id = Long.parseLong(request.getParameter("id_billet"));
			Billet billet = DaoFactory.getDaoFactory().getBilletDao().findBilletById(id);
			DaoFactory.getDaoFactory().getBilletDao().removeBillet(billet);
		}
	}

}
