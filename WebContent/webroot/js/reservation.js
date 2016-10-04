function selectReservation(element){
	$.ajax({
		type: "POST",
		url: "http://www.voyage-supinfo.com:8080/ProjetBsc/auth/page_personne?",
		data :{
			id_reservation : element
		},
		success: function(msg){
			$("#reservation_detail_"+element).empty();
			
			$("div[id^='reservation_detail_']").slideUp();
			$("#reservation_detail_"+element).append(msg);
			$("#reservation_detail_"+element).slideDown();
			
		      $( "#button_choisir, button" )
		      .button()
		      {
		      };
		}
	});
}

function supprimerBillet(id){
	
}