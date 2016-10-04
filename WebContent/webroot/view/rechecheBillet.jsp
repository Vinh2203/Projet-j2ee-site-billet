<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../include/header.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/rechercheBillet.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/chercheBillet.css">

</head>		
<c:import url="../include/body.jsp" />
<c:import url="../include/formBillet.jsp" />

	<div id="liste_trajet" >
		<div id="titre_liste_trajet">
			SELECT VOTRE TRAJET
			<img alt="" src="${pageContext.request.contextPath}/webroot/image/train.png" style="margin-left: 330px;">
		</div>
		<%@page import="java.util.List" %>
		<%@ page language="java" import="com.projet.model.Places"%>

		
		<div id="liste_trajet_item">
			
			<c:forEach items="${liste_trajet}" var="c" >
				<div id="trajet_item_${c.id}" onclick="selectTrajet(${c.id})">
					<c:set var="heure_dept" value="${c.heureDept}" />
					<c:set var="heure_arrive" value="${c.heureArrive}" />
				
					<fmt:formatDate pattern="HH:mm" value="${heure_dept}" /> 
	           		<c:out value="${c.ville_dept.nomVille}" ></c:out>	
	           		<br>
	           		<fmt:formatDate pattern="HH:mm" value="${heure_arrive}" /> 
	           		<c:out value="${c.ville_arrive.nomVille}"></c:out>				 		 
	          	 	<br>
	         	
	        	  <div id="liste_trajet_item_prix">
			    	<c:set var="liste_places" value="${liste_places}" />
			    	<c:out value="${liste_places[c.id].prix } €"></c:out>
			    	<input type="hidden" id="places_id_${c.id}" value="${liste_places[c.id].id}">
	         	 </div>	
	          </div>
	          <div id="billet_detail_${c.id }"></div>	 
	          <hr id="hr_${c.id }">		 
			</c:forEach>
		</div>	

	</div>
<c:import url="../include/footer.jsp" />