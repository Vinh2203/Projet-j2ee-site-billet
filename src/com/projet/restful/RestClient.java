package com.projet.restful;

import java.util.ArrayList;
import java.util.List;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.projet.model.Trajet;
public class RestClient {
	protected Client client;

	protected WebResource webResource;

	public RestClient(long idVille_dept,long idVille_des,String heureDept,
			int typeDate,String dateDept) {
		ClientConfig clientConfig = new DefaultClientConfig();
		
		client = Client.create(clientConfig);
		webResource = client.resource("http://localhost:8080/ProjetBsc/rest/resources/listTrajet?id_dept="+idVille_dept
				+"&id_dest="+idVille_des+"&heureDept="+heureDept+"&type="+typeDate+"&dateDept="+dateDept);
	}

	public List<Trajet> getTrajets() {
		List<Trajet> list = new ArrayList<Trajet>();

		list = webResource.accept("application/json").get(new GenericType<List<Trajet>>() {
		});
		return list;
	}
}