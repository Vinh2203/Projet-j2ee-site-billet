package com.projet.servlet;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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
import com.projet.model.Trajet;
import com.projet.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.*;

/**
 * Servlet implementation class ValidationPaiement
 */
@WebServlet("/validationPaiement")
public class ValidationPaiement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationPaiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		redigerBillet(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/webroot/view/validationPaiement.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom_passager");
		String prenom = request.getParameter("prenom_passager");
		String places = request.getParameter("places");
		String email_passager = request.getParameter("email");
		ArrayList<String> passagers = new ArrayList<String>();
		String[] nom_passager = nom.split("@_@");	
		String[] prenom_passager = prenom.split("#_#");
		String[] places_passager = places.split("&_&");
		System.out.println(places_passager.length);
		System.out.println(nom);
		for (int cpt = 0; cpt < nom_passager.length; cpt++) {
			passagers.add(nom_passager[cpt] + " " + prenom_passager[cpt]+"_/_"+places_passager[cpt]);
		}
		request.getSession().setAttribute("passagers", passagers);
		request.getSession().setAttribute("email_passager", email_passager);
		System.out.println(passagers);
		
	}

	protected void sendEmail(ArrayList<String> fichiers, String destination) {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		final String login = "supinfo.groupe@gmail.com";
		final String pwd = "12345678.";
		Authenticator pa = null;
		if (login != null && pwd != null) {
			props.put("mail.smtp.auth", "true");
			pa = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(login, pwd);
				}
			};
		}

		// Get the default Session object.
		Session session = Session.getDefaultInstance(props, pa);
		String text = "Nous avons bien pris en compte votre commande, merci pour votre confiance"
				+ "voici le recu de votre paiement"
				+ "suite à l'article de la loi française vous avez le droit a 7 jours de retractation";
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(login));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destination));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText(text);

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			for(String fichier : fichiers){
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(fichier);
				messageBodyPart.setDataHandler(new DataHandler(source));
				String[] nom = fichier.split("/");
				messageBodyPart.setFileName(nom[nom.length-1]);
				multipart.addBodyPart(messageBodyPart);
			}
			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	protected void redigerBillet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Places> panier = (ArrayList<Places>) request.getSession().getAttribute("panier");
		@SuppressWarnings("unchecked")
		ArrayList<String> passagers = (ArrayList<String>) request.getSession().getAttribute("passagers");
		String email =  (String) request.getSession().getAttribute("email_passager");
		
		try {
			ArrayList<String> fichies = new ArrayList<String>();
			for(String passager : passagers ){
				Document document = new Document(PageSize.A4);
				String[] passager_item = passager.split("_/_");
				Places p = DaoFactory.getDaoFactory().getPlacesDao().findPlacesById(Long.parseLong(passager_item[1]));
				String path = System.getProperty("user.dir");
				String nom_billet = User.getMD5(passager+ new Date()+Math.random() * 500 + 1);
				PdfWriter.getInstance(document, new FileOutputStream(path + "/"+nom_billet+".pdf"));
				document.open();
				StringBuilder sb = new StringBuilder();
				sb.append("<b>&nbsp;<font align=\"center\" color=\"black\">Billet Electronique</font></b>");
				sb.append("<div>\n<span align=\"left\">Date Depart : "+Billet.convertDate(p.getDateDept())+"</span>");
				sb.append("\n<span align=\"right\">Voyageur : "+passager_item[0]+"</span>");
				sb.append("<br /><hr />");
				sb.append("\n<span align=\"right\">"+p.getTrajet().getHeureDept()+" :"+p.getTrajet().getVille_dept().getNomVille()+"</span><br />");
				sb.append("\n<span align=\"right\">"+p.getTrajet().getHeureArrive()+" :"+p.getTrajet().getVille_arrive().getNomVille()+"</span>");
				sb.append("\n<span align=\"right\">Classe : "+p.getType_class()+"</span>");
				sb.append("\n<span align=\"right\">Prix : "+p.getPrix()+" €</span>");
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
				fichies.add(file);
			}	
			sendEmail(fichies, email);

			if (request.getSession().getAttribute("panier") != null) {
				User u = (User) request.getSession().getAttribute("user");
				addReservation(u, panier,passagers);
			}
			request.getSession().setAttribute("validPaiement", 1);
			request.getSession().removeAttribute("panier");
			ArrayList<Places> list_panier = new ArrayList<Places>();
			request.getSession().setAttribute("panier", list_panier);
			request.getSession().removeAttribute("number_panier");
			request.getSession().removeAttribute("somme_panier");
			request.getSession().removeAttribute("passagers");

		} catch (DocumentException de) {
			de.printStackTrace();
			request.getSession().setAttribute("validPaiement", 0);

		} catch (IOException ioe) {
			ioe.printStackTrace();
			request.getSession().setAttribute("validPaiement", 0);
		}
	}

	protected void addReservation(User u, ArrayList<Places> list,ArrayList<String> passagers) {
		if (u != null) {
			Reservation reservation = new Reservation();
			Date aujourdhui = new Date();
			reservation.setDate_reservation(aujourdhui);
			reservation.setNombre_client(1);
			reservation.setId_user(u.getId());
			DaoFactory.getDaoFactory().getReservationDao().addReservation(reservation);
			
			for (Places p : list) {
				String[] passager = passagers.get(list.indexOf(p)).split("/");	
				Trajet trajet = p.getTrajet();
				Billet billet = new Billet();
				billet.setDateDept(p.getDateDept());
				billet.setHeureArrive(trajet.getHeureArrive());
				billet.setHeureDept(trajet.getHeureDept());
				billet.setReservation(reservation);
				billet.setNom_client(passager[0]);
				billet.setPrix(p.getPrix());
				billet.setType_class(p.getType_class());
				billet.setVille_arrive(trajet.getVille_arrive().getNomVille());
				billet.setVille_dept(trajet.getVille_dept().getNomVille());

				DaoFactory.getDaoFactory().getBilletDao().addBillet(billet);
			}

		}
	}
}
