package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facade.Facade_caissier;
import Facade.Facde_medecin;
import model.Caissier;

import model.Personnel;

/**
 * Servlet implementation class CassierServlet
 */
@WebServlet("/CassierServlet")
public class CassierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    Caissier m;
	
	    Personnel personnel;
	    List<Caissier> listeM;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CassierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String instruction = request.getParameter("ins");
		
	    System.out.println(instruction);
		if(instruction==null)
		{      
			
            listeM =  Facade_caissier.liste();
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
		}else if(instruction.equals("delete")) {
			
		     int id = Integer.parseInt(request.getParameter("id"));
		     String matricule = request.getParameter("f");
		 
		     int ok =  Facade_caissier.delete(id);
		     ok =Facade_caissier.deleteP(matricule);
			 listeM =  Facade_caissier.liste();
			 request.setAttribute("listeMedecins", listeM);
		     
		     if(ok == 1)
				{
					request.setAttribute("message","Caissier supprimer avec succees !");
				}else {
					request.setAttribute("message","Probleme suppression de caissier !");
			   }
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
		}else if(instruction.equals("modifier"))  {
			
			
			listeM =  Facade_caissier.recup(Integer.parseInt(request.getParameter("id")));
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/modifier.jsp").forward(request, response);
		}
		else {
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		m  = new Caissier(Integer.parseInt(request.getParameter("id")),request.getParameter("matricule"),request.getParameter("nom"),request.getParameter("dateNaisse")
				,request.getParameter("tel"),request.getParameter("sexe"),request.getParameter("password"),request.getParameter("login")
				);
		
		personnel = new Personnel(request.getParameter("matricule"), "Caissier");
	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  Facade_caissier.verifiee(request.getParameter("matricule"));
	
		if(test < 1)
		{
								try {
								
									int ok =  Facade_caissier.ajouterCaisser(m);
									ok = Facde_medecin.ajoutP(personnel);
									listeM =  Facade_caissier.liste();
								    
									request.setAttribute("listeMedecins", listeM);
									if(ok == 1)
									{
										request.setAttribute("message","Caissier ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton de Caissier !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
				}else {
		             listeM =  Facade_caissier.liste();
		             request.setAttribute("message","cette matricule existe deja!");
					request.setAttribute("listeMedecins", listeM);
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
				}
		}else {
			int ok = Facade_caissier.update(m);
			listeM =  Facade_caissier.liste();
			 if(ok == 1)
			 {
				 request.setAttribute("message","Caissier modifier!");
			 }else {
				 request.setAttribute("message","Caissier non modifier!");
			 }
   
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
		}
		
		
		
	}

	

}
