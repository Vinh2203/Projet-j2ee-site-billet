<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/index.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/jquery-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/jquery/jquery-confirm.css">

</head>
<c:import url="../include/body.jsp" />
<input type="hidden" id="email_user" value='<c:out value="${email_passager}"></c:out>'>
<c:if test="${validPaiement == 1 }">
	<script>
	var email = $("#email_user").val();
	$.alert({
	    title: '',
	    content: 'Votre reservation a été effectuée , votre bille est envoyé à votre email '+ email,
	    animation: 'rotate'
	});
	window.location
	.assign("http://www.voyage-supinfo.com:8080/ProjetBsc/Index")
	</script>
</c:if>

<c:if test="${validPaiement == 0 }">
	<script>
	$.alert({
	    title: '',
	    content: "Votre reservation est refusé",
	    animation: 'rotate'
	});
	window.location
	.assign("http://www.voyage-supinfo.com:8080/ProjetBsc/Index")
	</script>
</c:if>
<c:import url="../include/footer.jsp" />