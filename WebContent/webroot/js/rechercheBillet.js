function selectTrajet(element){
	var id_places = $("#places_id_"+element).val();
	$.ajax({
		type: "POST",
		url: "http://www.voyage-supinfo.com:8080/ProjetBsc/RechercheBilletDetail?",
		data :{
			id_trajet : element,
			id_places : id_places
		},
		success: function(msg){
			$("#billet_detail_"+element).empty();
			$("hr").css("margin-top", "");
			$("div[id^='billet_detail_']").slideUp();
			$("#billet_detail_"+element).append(msg);
			$("#billet_detail_"+element).slideDown();
			$("#hr_"+element).css("margin-top", "106px");
		      $( "#button_choisir, button" )
		      .button()
		      {
		      };
		}
	});
}

function reservation(){
	$.ajax({
		type: "GET",
		url: "http://www.voyage-supinfo.com:8080/ProjetBsc/reservation?",
		data :{
		},
		success: function(msg){
			$("#affBillet").after(msg);
			var dateToday = new Date();
			 $( "#date_naissance" ).datepicker({minDate: dateToday,});
			 $("#date_naissance").datepicker("option", "dateFormat", "dd/mm/yy");
		}
	});
}


function supprimer(id,index){
	
	$.confirm({
	    title: 'Supprimer!',
	    content: 'Etes-vous sûr de vouloir supprimer cette billet?!',
	    confirm: function(){
	    	$.ajax({
	    		type: "POST",
	    		url: "http://www.voyage-supinfo.com:8080/ProjetBsc/deleteBillet?",
	    		data :{
	    			id : id
	    		},
	    		success: function(msg){
	    			if(msg == 0){
	    				window.location.assign("http://www.voyage-supinfo.com:8080/ProjetBsc/Index")
	    			}
	    			$("#billet_detail_"+index+"_"+id).hide();
	    			$("#panier").html("Panier ("+msg+")");
	    			
	    		}
	    	});
	    	
	    },
	    cancel: function(){
	     
	    }
	});
}

function enregristrerPassager(){
	var nombre = parseInt($("#nombrePassager").val());
	var nom_passager ="";
	for(var cpt = 0 ; cpt < nombre ; cpt ++){
		nom_passager += $("#nom_passager_"+cpt).val()+"@_@";
	}
	
	var prenom_passager = "";
	for(var cpt = 0 ; cpt < nombre ; cpt ++){
		prenom_passager += $("#prenom_passager_"+cpt).val()+"#_#";
		
	}
	
	var places = "";
	for(var cpt = 0 ; cpt < nombre ; cpt++){
		places += $("#places_"+cpt).val()+"&_&";
		
	}

	$.blockUI({ message: '<br /><b>Enregristrement en cours</b><br /><br /><img src="./webroot/image/train-gif.gif" alt="Chargement..."/><br /><br />Merci de patienter<br /><br />'});       
	$.ajax({
		type: "POST",
		url: "http://www.voyage-supinfo.com:8080/ProjetBsc/validationPaiement?",
		data :{
			nom_passager : nom_passager,
			prenom_passager : prenom_passager,
			places : places,
			email : $("#email").val()
		},
		success: function(msg){
			$.unblockUI();
			$("#bPaypal").show();
			$("#bEnregristrer").hide();
			$("input[id^='nom_passager_']").prop('disabled', true);
			$("#email").prop('disabled', true);
			$("input[id^='prenom_passager_']").prop('disabled', true);

		}
	});
}

function addPerson(){
	var nombre = parseInt($("#number_person").val());
	nombre++;
	$("#number_person").val(nombre);
	var tag = "<img id='persone_"+nombre+"' alt='' src='./webroot/image/person.png' style='margin-left:5px;margin-right:5px;' />";
	$("#add_person").before(tag);
	if(nombre == 2){
	tag = "<a id='remove_persone_"+nombre+"'  title='remove voyageur' href='javascript:void(0);' onclick='removeVoyageur();'>" +
			"<img alt='' src='./webroot/image/remove.png' style='margin-left:43px;' /></a>";
	$("#delete_espace").after(tag);
	}else{
		tag = "<a id='remove_persone_"+nombre+"'  title='remove voyageur' href='javascript:void(0);' onclick='removeVoyageur();'>" +
		"<img alt='' src='./webroot/image/remove.png' style='margin-left:27px;' /></a>";
		$("#remove_persone_"+(nombre-1)).after(tag);
	}
	
}

function removeVoyageur(){
	var nombre = parseInt($("#number_person").val());
	$("#persone_"+nombre).remove();
	$("#remove_persone_"+nombre).remove();
	nombre--;
	$("#number_person").val(nombre);
	
	
}