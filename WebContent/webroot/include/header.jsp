<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>Easyrainway</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/webroot/image/title.png" type="image/x-icon">
	<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/jquery.blockui.js"></script>
	 <script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/vegas.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/jquery-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/chosen.jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/jquery/jquery.masonry.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/webroot/js/index.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/jquery/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/jquery/vegas.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/jquery/chosen.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webroot/css/formBillet.css">
		
		<script>
	$(function() {
		jQuery(document).ready(function(){
			$(".chosen").chosen({width: "210px"});
		});
		var dateToday = new Date();
		 $( "#dateDept" ).datepicker({minDate: dateToday,});
		 $("#dateDept").datepicker("option", "dateFormat", "dd/mm/yy");

		 $( "#dateRetour" ).datepicker({minDate: dateToday,});
		 $("#dateRetour").datepicker("option", "dateFormat", "dd/mm/yy");
		  
		 $( "#radio" ).buttonset();
		 
		 $( "#radio-trajet" ).buttonset();
		
		 $( "input[type=submit], button" )
	      .button()
	      {
	      };
		$("#panier").text("Panier ("+$("#number_panier").val()+")");	
		var currentLocation = window.location;
		
	    $("body").vegas({
	        slides: [
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/bacthang.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/voi.jpg',fade:1000 },
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/tuyet.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/1.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/2.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/4.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/5.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/6.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/7.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/8.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/9.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/10.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/11.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/12.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/tuyet.jpg' ,fade:1000},
	            { src: 'http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/slide/tuyet.jpg' ,fade:1000},
	        ]
	    });
	});
</script>