<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/inc/header.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Consultation</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row" id="info">
			<div class="col-lg-12">
				<h1 class="page-header">Consultation</h1>
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
					<div class="panel-heading">Consultation</div>
					<div class="panel-body">
						


							   <form  action="/ges_consultation/ConsultationServlet" method="post" >
							        <input type="hidden" name="id" value="0">
									<div class="form-group">
										<label>Date</label>
										<input type="date" class="form-control"   name="date" require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Thérapie </label>
										<input class="form-control"  name="therapie" require
										value="">
										 
									</div>
									  <div class="form-group">
										<label>Ordonnance</label>
										<input class="form-control"  name="ordonnance" require
										value="">
										 
									</div>
                                  <c:choose>
	                              <c:when test="${empty listeTicket}">
					   			   <div class="alert alert-danger">liste vide</div>
					 			   </c:when>
					 			   <c:otherwise>    
									<div class="form-group">
										<label>Code ticket</label>
										<select name="id_t" class="form-control">
					 			    	  <c:forEach items="${listeTicket}" var="p">
										      <option  value="${p.id }">${p.code }</option>
										 </c:forEach>
								       </select>
									</div>
					 			 </c:otherwise>
						        </c:choose>
						        <c:choose>
	                              <c:when test="${empty listeMedecins}">
					   			   <div class="alert alert-danger">liste vide</div>
					 			   </c:when>
					 			   <c:otherwise>    
									<div class="form-group">
										<label>Matricule</label>
										<select name="id_m" class="form-control">
					 			    	  <c:forEach items="${listeMedecins}" var="s">
										      <option  value="${s.id }">${s.matricule }</option>
										 </c:forEach>
								       </select>
									</div>
					 			 </c:otherwise>
						        </c:choose>
						        
									 
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
	   <div class="panel-heading">Liste des Consultation</div>
		   <div class="panel-body">
			<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                        <thead>
						    <tr>
						        <th class="th-sm">Date</th>
						        <th class="th-sm">Therapie</th>
						        <th class="th-sm">Ordonnance</th>
						        <th class="th-sm">Matricule medecin</th>
						        <th class="th-sm">Code Ticket</th>
						         <th class="th-sm">Action</th>
						         <th >&nbsp;</th>
				
						       
						    </tr>
						    </thead>
							<tbody>
					       <c:choose>
	           
	           
									 <c:when test="${empty listeConsultation}">
					   						<div class="alert alert-danger">liste vide</div>
					 				 </c:when>
					 				 <c:otherwise>
					 			    	  <c:forEach items="${listeConsultation}" var="l">
										      
										      
										      <tr>
										      		        

											    <td>${l.date}</td>
											    <td>${l.therapie}</td>
											    <td>${l.ordonnance}</td>
											    <td>${l.medecin.matricule}</td>
											    <td>${l.ticket.code}</td>
											   
												<td><a href="/ges_consultation/TicketServlet?id=${l.id}&ins=delete" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-trash"></i></a> </td>
												
				   
											  
											  </tr>
										   </c:forEach>
					 				 </c:otherwise>
						   </c:choose>
				
							</tbody>
							<tfoot>
						    <tr>
						        <th>Date</th>
						        <th >Therapie</th>
						        <th >Ordonnance</th>
						        <th >Matricule medecin</th>
						        <th>Code Ticket</th>
				                <th>Action</th>
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
