<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../include/header.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/pagePersonne.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/jquery-confirm.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/jquery/jquery-confirm.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/pagePersonne.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/bootstrap-social/assets//css/bootstrap.css">
<script type="text/javascript">
		$(window).load(function(){
			$('.grid').masonry({
				  itemSelector: '.grid-item',
				  columnWidth: 140
				});
		});	
		</script>
</head>		
<c:import url="../include/body.jsp" />
<div id="center">
	<div  class="grid" style="position: relative; ">
		<div id="liste_reservation" class="grid-item grid-item--width3">
			<div id="liste_reservation_item">
				<span style="margin-left: 20px;margin-top: 10px;">Votre Reservation</span>
				<img alt="" src="${pageContext.request.contextPath}/webroot/image/train.png" style="margin-left: 330px;margin-top:-9px;">
			<br>
			<hr>
			</div>	
				<c:forEach items="${list_reservation}" var="c" >
					<c:set var="date_reservation" value="${c.date_reservation}" />
					<div id="reservation_item_${c.id}" onclick="selectReservation(${c.id})">
						Date Reservation : <fmt:formatDate pattern="d/MM/YYYY" value="${date_reservation}" /> 
						<span id="nombre_client">
						<c:out value="${c.nombre_client}" ></c:out>	
						</span> 
					</div>
					 <div id="reservation_detail_${c.id }"></div>
					 <br>	
					<hr id="hr_${c.id}">
				</c:forEach>	
			
		</div>	
		
		<div id="information_personnel" class="grid-item grid-item--width3">
			<div id="information_item">
				<span style="margin-left: 20px;margin-top: 10px;">Votre Information</span>
				<img alt="" src="${pageContext.request.contextPath}/webroot/image/person_information.png" style="margin-left: 330px;margin-top:-9px;">
			<br>
			<hr>
			</div>
			<input type="email" id="email" class="form-control" id="exampleInputEmail3" value="${user.email }" />
			<hr>
			<input type="text" id="name" class="form-control" value="${user.name }" />
			<hr>
			<input type="password" id="password" class="form-control" placeholder="password"/>
			<br />
			 <button type="submit" class="btn btn-primary" style="margin-left: 20px;" onclick="enregristrerInfo();">Valider</button>
		</div>	
	</div>	
</div>		
<c:import url="../include/footer.jsp" />