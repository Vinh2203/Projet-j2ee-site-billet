package com.projet.restful;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.projet.dao.DaoFactory;
import com.projet.model.Billet;
import com.projet.model.Comparator;
import com.projet.model.Places;
import com.projet.model.Reservation;
import com.projet.model.Trajet;
import com.projet.model.User;
import com.projet.model.Ville;


@Path("/resources")
public class ResourcesWebServices {

	@GET
	@Path("/listTrajet")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trajet> getListTrip(@QueryParam("id_dept") Long idVille_dept,
											@QueryParam("id_dest") Long idVille_des,
											@QueryParam("heureDept") String heureDept,
											@QueryParam("type") int typeDate){
		List<Trajet> list = Trajet.searchTrajetSimple(idVille_dept, idVille_des, heureDept, typeDate);
		return list;
	}
	
	@GET
	@Path("/listTrajetMobile")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Places> getListTripByMobile(@QueryParam("id_dept") Long idVille_dept,
											@QueryParam("id_dest") Long idVille_des,
											@QueryParam("heureDept") String heureDept,
											@QueryParam("type") int typeDate,
											@QueryParam("dateDept") String  dateDept,
											@QueryParam("type_class") String typeClass ){
		
		
		
		List<Trajet> list = Trajet.searchTrajetSimple(idVille_dept, idVille_des, heureDept, typeDate);
		List<Places> list_places = searchPlaces(list, dateDept, typeClass);
		
		return list_places;
	}
	
	@GET
	@Path("/listVilleMobile")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ville> getListVilleByMobile(){
		List<Ville> list_ville = DaoFactory.getDaoFactory().getVilleDao().getAllVille();
		Comparator compare = new Comparator();
		Collections.sort(list_ville,compare);
		
		return list_ville;
	}
	
	@POST
	@Path("/loginMobile")
	@Produces(MediaType.APPLICATION_JSON)
	public User check(@FormParam("email") String email,
			@FormParam("passowrd") String passowrd){
		User u = User.check(email, passowrd);
		
		return u;
	}
	
   @PUT
   @Path("/reservationMobile")
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public void reservation(@FormParam("id_user") String id_user,
      @FormParam("list_places") String text) {
	   String[] list = text.split("_");
	   ArrayList<Long> array = new ArrayList<Long>();
	  for(int cpt = 0 ; cpt < list.length;cpt++){
		  array.add(Long.parseLong(list[cpt]));
	  }
     addReservation(id_user, array);
   }
   
   protected void addReservation(String id_user,ArrayList<Long> list){
		if(id_user != ""){
			Reservation  reservation = new Reservation();
		    Date aujourdhui = new Date();
		    reservation.setDate_reservation(aujourdhui);
		    reservation.setNombre_client(1);
		    reservation.setId_user(Long.parseLong(id_user));
		    DaoFactory.getDaoFactory().getReservationDao().addReservation(reservation);
		    
		    for(Long id : list){
		    	Places p = DaoFactory.getDaoFactory().getPlacesDao().findPlacesById(id);
		    	Trajet trajet = p.getTrajet();
				
		    	Billet billet = new Billet();
		    	billet.setDateDept(p.getDateDept());
		    	billet.setHeureArrive(trajet.getHeureArrive());
		    	billet.setHeureDept(trajet.getHeureDept());
		    	billet.setReservation(reservation);
		    	billet.setNom_client("");
		    	billet.setPrix(p.getPrix());
		    	billet.setType_class(p.getType_class());
		    	billet.setVille_arrive(trajet.getVille_arrive().getNomVille());
		    	billet.setVille_dept(trajet.getVille_dept().getNomVille());
		    	
		    	DaoFactory.getDaoFactory().getBilletDao().addBillet(billet);
		    }
		    
		}
	}
   
   public  List<Places> searchPlaces(List<Trajet> list, String dateDept, String type) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		String list_id_trajet = "(";
		String virg = "";
		for (Trajet t : list) {
			list_id_trajet += virg;
			list_id_trajet += t.getId();
			virg = ",";
		}
		
		if(list.size()==0){
			list_id_trajet = "('')";
		}

		list_id_trajet += ")";
		Query q = em.createQuery("SELECT p FROM Places AS p WHERE id_trajet IN " + list_id_trajet + " AND date_dept = '"
				+ dateDept + "' AND type_class =" + type);

		@SuppressWarnings("unchecked")
		List<Places> list_places = (List<Places>) q.getResultList();
		em.close();
		emf.close();
		
		return list_places;
	}
}
