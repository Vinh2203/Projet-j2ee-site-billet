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
	$.confirm({
	    title: 'Supprimer!',
	    content: 'Etes-vous sûr de vouloir annuler cette billet?!',
	    confirm: function(){
			$.ajax({
				type: "POST",
				url: "http://www.voyage-supinfo.com:8080/ProjetBsc/auth/page_personne?",
				data :{
					id_billet : id
				},
				success: function(msg){
					$("#billet_"+id).remove();
				}
			});
	    },
	    cancel: function(){
	     
	    }
	});	
}

function telechargerBillet(id){
	$.ajax({
		type: "GET",
		url: "http://www.voyage-supinfo.com:8080/ProjetBsc/auth/page_personne?",
		data :{
			id_billet : id
		},
		success: function(msg){
			window.location.href  = msg;
		}
	});
}

function enregristrerInfo(){
	$.blockUI({ message: '<br /><b>Enregristrement en cours</b><br /><br /><img src="http://www.voyage-supinfo.com:8080/ProjetBsc/webroot/image/train-gif.gif" alt="Chargement..."/><br /><br />Merci de patienter<br /><br />'});       
	$.ajax({
		type: "GET",
		url: "http://www.voyage-supinfo.com:8080/ProjetBsc/auth/page_personne?",
		data :{
			email : $("#email").val(),
			name : $("#name").val(),
			password : $("#password").val()
		},
		success: function(msg){
			$.unblockUI();
			$.alert({
			    title: '',
			    content: 'La mise a jour est effectue!'
			});
			$("#name_personne").html("BIENVENUE ! "+ $("#name").val());
		}
	});
}
