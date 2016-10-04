package com.projet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Filtre qui v�rifie que les utilisateurs voulant acc�der aux urls pr�c�d�es de /auth/ soient bien loggu�s sur l'application
 * 
 * */

@WebFilter("/auth/*")
public class AuthenticateFilter implements Filter {


	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// On r�cupere la request et response et on les caste en HTTP request et response.
		HttpServletRequest 	req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(req.getSession().getAttribute("test") == null){
			res.sendRedirect(req.getContextPath() + "/home");
			return;
		}
		Boolean test =  (Boolean) req.getSession().getAttribute("test");
		
		// Si le nom d'utilisateur est null, c'est que l'utilisateur ne s'est pas loggu� donc on le redirige vers la racine du projet
		if (test == false) {
			res.sendRedirect(req.getContextPath() + "/home");
			return;
		}
		// Si on est pas pass� dans le if, on ne fait rien puisque l'utlisateur est bien loggu�, donc on appelle la fonction chain qui va 
		// juste appeler l'action correspondant � l'url de l'�toile dans /auth/*
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {}

}
