<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <meta charset="ISO-8859-1">
    <title>Consultation</title>
     <link href="${pageContext.request.contextPath}/assets/css/app.css" rel="stylesheet">
	 <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <link href="${pageContext.request.contextPath}/assets/css/styles.css" rel="stylesheet">
       <link href="${pageContext.request.contextPath}/assets/css/addons/datatables.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/assets/js/lumino.glyphs.js"></script>

</head>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href=""><span>Ges</span> Consultation</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
					   <%  String email=(String) session.getAttribute("type");%>
					    
					   <%if(email!=null){ %>
						<a href="/ges_consultation/LoginServlet?ins=logout"

                                >

                          Logout
                                                      
                         </a>
				
                       <%} %>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
    
<% if(email!=null){ %>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
		
		   <% if(!email.equals("Caissier") && !email.equals("Medecin") ){ %>
			<li><a href="CassierServlet"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg>Caisse</a></li> 
			<li><a href="MedecinServlet"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>Medecin</a></li>
			<li><a href="SpecialiteServlet"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg>Specialite</a></li>
			 <%} %>
			<% if(email=="Caissier"){ %>
			<li><a href="PatientServlet"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>Patient</a></li>
			
			<li><a href="TicketServlet"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg>Ticket</a></li>
			<% } %>
			<%if(email.equals("Medecin")){ %>
			 <li><a href="ConsultationServlet"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg>Consultation</a></li>
			 <%} %>
			
			
			
			<li role="presentation" class="divider"></li>
		</ul>

	</div>
<%}else{ %>
    
<%} %>


	
	