<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="modal_billet" title="Commander Billet">
		<form action="${pageContext.request.contextPath}/rechercheBillet" method="post">
		
			<select class="chosen" name="villeDept">
				<c:forEach items="${listVille}" var="c">
					<c:if test="${c.idVille == ville_dept}">
						<option selected="selected" value='${c.idVille}' ><c:out value="${c.nomVille}"></c:out></option>
					</c:if>	
					<c:if test="${c.idVille != ville_dept}">
						<option  value='${c.idVille}' ><c:out value="${c.nomVille}"></c:out></option>
					</c:if>					</c:forEach>
			</select>
		
			<select class="chosen" name="villeDest">
				<c:forEach items="${listVille}" var="c">
					<c:if test="${c.idVille == ville_dest}">
						<option selected="selected" value='${c.idVille}' ><c:out value="${c.nomVille}"></c:out></option>
					</c:if>	
					<c:if test="${c.idVille != ville_dest}">
						<option  value='${c.idVille}' ><c:out value="${c.nomVille}"></c:out></option>
					</c:if>	
				</c:forEach>
			</select>
			<hr>
			<br /><br/>
			<input type="text" placeholder="Depart" value="${dateDept}" name="dateDept" id="dateDept" required /> 
			<select id="heureDep" name="heureDept">
				<% for(int cpt = 0 ; cpt < 24 ; cpt++){ %>
					<c:if test="${heureDept == cpt }">
						<option selected="selected" value=<%=cpt %>><%=cpt %> h</option>
					</c:if>
					<c:if test="${cpt != heureDept}">
						<option value=<%=cpt %>><%=cpt %> h</option>
					</c:if>	
				<% }%>		
			</select>
			<hr>
			<br /><br/>
			<c:if test="${type_trajet == 1 || empty type_trajet }">
			<input style="display: none" type="text" placeholder="Retour" value="${dateRetour}" name="dateRetour" id="dateRetour" />
			<select style="display: none" id="heureRetour" name="heureRetour">
				<% for(int cpt = 0 ; cpt < 24 ; cpt++){ %>
						<option value=<%=cpt %>><%=cpt %> h</option>
				<% }%>		
			</select>
			</c:if>
			
			<c:if test="${type_trajet == 2}">
			<input  type="text" placeholder="Retour" value="${dateRetour}" name="dateRetour" id="dateRetour" required  />
			<select  id="heureRetour" name="heureRetour">
				<% for(int cpt = 0 ; cpt < 24 ; cpt++){ %>
						<option value=<%=cpt %>><%=cpt %> h</option>
				<% }%>		
			</select>
			</c:if>
			
			<br><br>
			<div id="radio">
				<c:if test="${typeClass == 1}">
			    	<input type="radio" id="radio1" value="1" checked="checked" name="typeClass"><label for="radio1">1ere Classe</label>
			   	 <input type="radio" id="radio2" value="2"  name="typeClass"><label for="radio2" style="margin-right: 3px;">2e Classe</label>
				</c:if>
				<c:if test="${typeClass == 2}">
			    	<input type="radio" id="radio1" value="1" name="typeClass"><label for="radio1">1ere Classe</label>
			   	 <input type="radio" id="radio2" value="2" checked="checked"   name="typeClass"><label for="radio2" style="margin-right: 3px;">2e Classe</label>
				</c:if>
				<c:if test="${typeClass != 2 && typeClass != 1}">
			    	<input type="radio" id="radio1" value="1" name="typeClass"><label for="radio1">1ere Classe</label>
			   	 <input type="radio" id="radio2" value="2" checked="checked"   name="typeClass"><label for="radio2" style="margin-right: 3px;">2e Classe</label>
				</c:if>
				<c:if test="${type_trajet == 2}">
					<input type="radio" id="radio3"  class="type_trajet" onclick="selectTrajetSimple();" value="1" name="type_trajet" ><label for="radio3">Aller Simple</label>
			   	 <input type="radio" id="radio4" class="type_trajet" onclick="selectTrajetRetour();" value="2" checked="checked" name="type_trajet"  ><label for="radio4">Aller Retour</label>
				</c:if>
				<c:if test="${type_trajet == 1}">
					<input type="radio" id="radio3"  class="type_trajet" onclick="selectTrajetSimple();" checked="checked" value="1" name="type_trajet" ><label for="radio3">Aller Simple</label>
			   	 <input type="radio" id="radio4" class="type_trajet" onclick="selectTrajetRetour();" value="2"  name="type_trajet"  ><label for="radio4">Aller Retour</label>
				</c:if>
				<c:if test="${type_trajet != 1 && type_trajet != 2}">
					<input type="radio" id="radio3"  class="type_trajet" onclick="selectTrajetSimple();" checked="checked" value="1" name="type_trajet" ><label for="radio3">Aller Simple</label>
			   	 <input type="radio" id="radio4" class="type_trajet" onclick="selectTrajetRetour();" value="2"  name="type_trajet"  ><label for="radio4">Aller Retour</label>
				</c:if>
			</div>
			
			<hr>
			<br /><br/>
			<button type="submit">Recherche</button>
		</form>
		
	</div>