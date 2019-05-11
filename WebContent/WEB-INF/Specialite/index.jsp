<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/inc/header.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Specialite</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row" id="info">
			<div class="col-lg-12">
				<h1 class="page-header">Specalite</h1>
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
			  
			   <div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Ajouter Specialité</div>
					<div class="panel-body">
						<c:choose>
				 <c:when test="${empty message}">
   						
 				 </c:when>
 				 <c:otherwise>
 			    	 <div class="alert alert-success">${message}</div>
 				 </c:otherwise>
			</c:choose>


							   <form  action="/ges_consultation/SpecialiteServlet" method="post" >
							        <input type="hidden" name="id" value="0">
									<div class="form-group">
										<label>Nom</label>
										<input class="form-control"   name="nom" require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Tarif Consultation </label>
										<input  type="number" class="form-control"  name="tarif" require
										value="">
										 
									</div>
                                  				<input type="submit" id="creer_client" class="btn btn-primary" value="Valider">
								<button type="reset" class="btn btn-default">Annuler</button>
							  </form>
								
						 </div>
						
				    </div>
			   </div>
			  <div class="col-md-6">
			  <div class="panel panel-default">
	   <div class="panel-heading">Liste des Specialités</div>
		   <div class="panel-body">
	             <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">    
   					     <thead>
						    <tr>
						        <th class="th-sm" >Nom Specialité</th>
						        <th class="th-sm" >Tarif Consultation</th>
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

											    <td>${p.nom}</td>
											    <td>${p.tarif}</td>
											   	<td><a href="/ges_consultation/SpecialiteServlet?id=${p.id}&ins=delete&f=${p.nom}" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-trash"></i></a> </td>
												<td><a href="/ges_consultation/SpecialiteServlet?id=${p.id}&ins=modifier" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-edit"></i></a> </td>
				   
											  
											  </tr>
										   </c:forEach>
					 				 </c:otherwise>
						   </c:choose>
				
							</tbody>
							  <tfoot>
						       <tr>
						        <th  >Nom Specialité</th>
						        <th  >Tarif Consultation</th>
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
<!-- 	fin form -->
  	
</div>	
<jsp:include page="/inc/footer.jsp"/>
