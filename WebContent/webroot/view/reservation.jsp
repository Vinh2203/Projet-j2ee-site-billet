<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../include/header.jsp" />
<script type="text/javascript" src="./webroot/js/rechercheBillet.js"></script>
<script type="text/javascript" src="./webroot/js/jquery/jquery-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="./webroot/css/jquery/jquery-confirm.css">

<link rel="stylesheet" type="text/css" href="./webroot/css/index.css">
<link rel="stylesheet" type="text/css" href="./webroot/css/reservation.css">

<link rel="stylesheet" type="text/css" href="./webroot/css/bootstrap-social/assets//css/bootstrap.css">
	
<script>
	$(function() {
		$("#bValider, button").button()
		{
		}
		;
	})
</script>
</head>
<c:import url="../include/body.jsp" />
<div id="affBillet" >
	<c:forEach items="${panier}" var="c" varStatus="count">
		<c:set var="heure_dept" value="${c.trajet.heureDept}" />
		<c:set var="heure_arrive" value="${c.trajet.heureArrive}" />
		<c:set var="date_dept" value="${c.dateDept }" />
		<div id="billet_detail_${count.index }_${c.id}">
			<span id="spanName">${user.name}</span> <span id='spanDate'>Date
				Depart : <fmt:formatDate pattern="dd/MM/yyyy" value="${date_dept}" />
			</span>

			<hr>
	
			<span><c:out value="${c.trajet.ville_dept.nomVille }"></c:out></span>
			<span><fmt:formatDate pattern="HH:mm" value="${heure_dept}" />
			</span> <span id="span_train">Train : <c:out
					value="${c.trajet.train.numero_train}"></c:out></span>
			<hr id="hr_billet">
			<span><c:out value="${c.trajet.ville_arrive.nomVille }"></c:out></span>
			<span><fmt:formatDate pattern="HH:mm" value="${heure_arrive}" />
			</span>
			<c:if test="${c.type_class == '1' }">
				<span id="span_train">1ere classe</span>
			</c:if>
			<c:if test="${c.type_class == '2' }">
				<span id="span_train">2eme classe</span>
			</c:if>
			<br>
			<hr>
			<span id="span_prix"><c:out value="${c.prix }"></c:out> €</span>
			<button id="bSupprimer" onclick="supprimer(${c.id},${count.index })" type = "button" class = "btn btn-danger">Supprimer</button>
			
		</div>
		
	</c:forEach>
	<div id="billet_general">
		<button type = "button" id="bValider" class = "btn btn-primary" onclick="reservation()">Valider</button>
	</div>
</div>
<c:import url="../include/footer.jsp" />