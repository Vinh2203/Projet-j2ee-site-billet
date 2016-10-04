
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<body>

	<div class="menu">
		<div id="menu-home">
			<a href="${pageContext.request.contextPath}/home">
				<img alt="" src="${pageContext.request.contextPath}/webroot/image/home.png">
			</a>
		</div>
		
		<c:if test="${test == true}">
			<div id="personne">
				<img src="${user.url}">
				<a id="name_personne" href="${pageContext.request.contextPath}/auth/page_personne">BIENVENUE ! ${user.name}</a>
			</div>
		</c:if>
		
		<div id="menu-item">
			<c:if test="${test == true}">
				<a href="${pageContext.request.contextPath}/deconnecter">DECONNECTER</a>
			</c:if>
			
			<c:if test="${test != true}">
				<a href="${pageContext.request.contextPath}/home">CONNECTER</a>
			</c:if>	
			
			<a href="">ABOUT US</a>
		</div>
		
		<div id="menu-panier">
			<input id="number_panier" type="hidden" value='<c:out value="${number_panier}"></c:out>'>
			<a id="panier" href=${pageContext.request.contextPath}/panier></a>
		</div>
	</div>