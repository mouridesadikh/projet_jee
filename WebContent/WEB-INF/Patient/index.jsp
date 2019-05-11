<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/inc/header.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Patient</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row" id="info">
			<div class="col-lg-12">
				<h1 class="page-header">Patient</h1>
			</div>
			<c:choose>
				 <c:when test="${empty message}">
   						
 				 </c:when>
 				 <c:otherwise>
 			    	 <div class="alert alert-success">${message}</div>
 				 </c:otherwise>
			</c:choose>
			
		</div>
          

				
			
		
		<div class="row">
			<div class="col-lg-12">
			   <div class="col-md-2"></div>
			   <div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">Ajouter Patient</div>
					<div class="panel-body">
						


							   <form  action="/ges_consultation/PatientServlet" method="post" >
							        <input type="hidden" name="id" value="0">
									<div class="form-group">
										<label>Matricule</label>
										<input class="form-control"   name="matricule" require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Prenom et Nom </label>
										<input class="form-control"  name="nom"  require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Date de Naissance</label>
										<input type="date" class="form-control"  name="dateNaisse"  require
										value="">
										 
									</div>
									<div class="form-group">
										<label>Telephone</label>
										<input class="form-control"  name="tel"  require
										value="">
										 
									</div>
									<div class="form-group">
										<label>Sexe</label>
										<select name="sexe" class="form-control">
										      <option value="M">M</option>
										      <option  value="F">F</option>
										</select>
					 
									</div>
									<div class="form-group">
										<label>Groupe Sanguin</label>
										<select name="gs" class="form-control">
										      <option value="Oplus">Oplus</option>
										      <option  value="Onegatif">Onegatif</option>
										      <option  value="ABnegatif">ABnegatif</option>
										      <option  value="ABplus">ABplus</option>
										      <option  value="Anegatif">Anegatif</option>
										      <option  value="Bplus">Bplus</option>
										      <option  value="Bnegatif">Bnegatif</option>
										</select>
					 
									</div>
								
								<input type="submit" id="creer_client" class="btn btn-primary" value="Valider">
								<button type="reset" class="btn btn-default">Annuler</button>
							  </form>
								
						 </div>
						
				    </div>
			   </div>
			  <div class="col-md-2"></div>
			   
			   
			 </div>
	  </div>
<!-- 	fin form -->
  <div class="row">
	 <div class="col-lg-12">
		<div class="panel panel-default">
	   <div class="panel-heading">Liste des Medecins</div>
		   <div class="panel-body">
			
			<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">  
   					     <thead>
						    <tr>
						        <th class="th-sm">Matricule</th>
						        <th class="th-sm">Pr�nom et Nom</th>
						        <th class="th-sm">T�l�phone</th>
						        
						        <th class="th-sm">Date Niassance</th>
						        <th class="th-sm">Groupe Sanguin</th>
						         <th class="th-sm">Action</th>
						         <th >&nbsp;</th>
						       
						    </tr>
						    </thead>
							<tbody>
					       <c:choose>
	           
	           
									 <c:when test="${empty listeMedecins}">
					   						<div class="alert alert-danger">liste vide</div>
					 				 </c:when>
					 				 <c:otherwise>
					 			    	  <c:forEach items="${listeMedecins}" var="p">
										      
										      
										      <tr>

											    <td>${p.matricule}</td>
											    <td>${p.nom}</td>
											    <td>${p.tel}</td>
											  
											    <td>${p.dateNaissance}</td>
											    <td>${p.groupeSanguin}</td>
												<td><a href="/ges_consultation/PatientServlet?id=${p.id}&ins=delete&f=${p.matricule}" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-trash"></i></a> </td>
												<td><a href="/ges_consultation/PatientServlet?id=${p.id}&ins=modifier" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-edit"></i></a> </td>
				   
											  
											  </tr>
										   </c:forEach>
					 				 </c:otherwise>
						   </c:choose>
				
							</tbody>
							  <tfoot>
						    <tr>
						        <th >Matricule</th>
						        <th >Pr�nom et Nom</th>
						        <th >T�l�phone</th>
						        
						        <th >Date Niassance</th>
						        <th >Groupe Sanguin</th>
						         <th >Action</th>
						         <th >&nbsp;</th>
						       
						    </tr>
						    </tfoot>
						</table>
                         	
					     </div>
					 </div>

			  </div>
	
	</div>	
</div>	
<jsp:include page="/inc/footer.jsp"/>
