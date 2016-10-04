function selectTrajetSimple(){

		 $("#dateRetour").hide();
		 $("#dateRetour").prop('required',false);
		 $("#heureRetour").hide();

}
function selectTrajetRetour(){
	 $("#dateRetour").show();
	 $("#dateRetour").prop('required',true);
	 $("#heureRetour").show();
}