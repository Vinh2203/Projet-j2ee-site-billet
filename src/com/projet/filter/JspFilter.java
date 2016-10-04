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
	 Filtre servant à rediriger les utilisateurs qui essaient d'accéder directement aux .jsp via url 
	 (ex : http://localhost:8080/Suptrip/front/auth/addCategory.jsp ne sera pas accéssible)
*/

@WebFilter("*.jsp")
public class JspFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// On récupere la request et response et on les caste en HTTP request et response.
		HttpServletRequest 	req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//On redirige l'utilisateur vers l'url "/" donc la racine de notre application
		res.sendRedirect(req.getContextPath() + "/");
	}

	@Override
	public void destroy() {}
	
}
