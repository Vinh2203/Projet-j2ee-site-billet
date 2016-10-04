<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>VoyageBsc</title>
	<link rel="shortcut icon" href="./webroot/image/title.png" type="image/x-icon">
	<!-- <link type="text/css" rel="stylesheet"href="${pageContext.request.contextPath}/front/css/base.css" /> -->
	<script type="text/javascript" src="./webroot/js/jquery/jquery.js"></script>
	<script type="text/javascript" src="./webroot/js/jquery/vegas.js"></script>
	<script type="text/javascript" src="./webroot/js/jquery/jquery-ui.js"></script>
	<script type="text/javascript" src="./webroot/js/jquery/chosen.jquery.js"></script>
	<script type="text/javascript" src="./webroot/js/jquery/jquery.masonry.js"></script>
		<script type="text/javascript" src="./webroot/js/index.js"></script>
	<link rel="stylesheet" type="text/css" href="./webroot/css/jquery/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="./webroot/css/jquery/vegas.css">
	<link rel="stylesheet" type="text/css" href="./webroot/css/jquery/chosen.css">
	<link rel="stylesheet" type="text/css" href="./webroot/css/formBillet.css">
		
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
	   
	});
</script>