package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facade.Facde_medecin;
import model.Medecin;
import model.Personnel;

/**
 * Servlet implementation class MedecinServlet
 */
@WebServlet("/MedecinServlet")
public class MedecinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Medecin m;
    Facde_medecin facade ;
    Personnel personnel;
    List<Medecin> listeM;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedecinServlet() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String instruction = request.getParameter("ins");
		if(instruction==null)
		{      
	         listeM =  Facde_medecin.liste();
			 request.setAttribute("listeMedecins", listeM);
			 this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
		}else if(instruction.equals("delete")) {
		     int id = Integer.parseInt(request.getParameter("id"));
		     String matricule = request.getParameter("f");
		     int ok =  Facde_medecin.delete(id);
		     ok =Facde_medecin.deleteP(matricule);
			 listeM =  Facde_medecin.liste();
			 request.setAttribute("listeMedecins", listeM);
		     
		      if(ok == 1)
				{
					request.setAttribute("message","Medecin supprimer avec succees !");
				}else {
					request.setAttribute("message","Probleme suppression de medecin !");
			    }
			  this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
		}else if(instruction.equals("modifier"))  {
			listeM =  Facde_medecin.recup(Integer.parseInt(request.getParameter("id"))); 
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/modifier.jsp").forward(request, response);
		}
		else 
		{
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		m  = new Medecin(Integer.parseInt(request.getParameter("id")),request.getParameter("matricule"),request.getParameter("nom"),request.getParameter("dateNaisse")
				,request.getParameter("tel"),request.getParameter("sexe"),request.getParameter("password"),request.getParameter("login")
				,request.getParameter("grade"));
		
		personnel = new Personnel(request.getParameter("matricule"), "Medecin");
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
			int test =  Facde_medecin.verifiee(request.getParameter("matricule"));
			if(test < 1)
			{
					try {
									
							int ok =  Facde_medecin.ajouterMedecin(m);
							ok = Facde_medecin.ajoutP(personnel);
							listeM =  Facde_medecin.liste();		    
							request.setAttribute("listeMedecins", listeM);
							if(ok == 1)
							{
								request.setAttribute("message","Medecin ajouter avec succees !");
							}else {
								request.setAttribute("message","Probleme d'inserton de medecin !");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
					}else {
			            listeM =  Facde_medecin.liste();
			            request.setAttribute("message","cette matricule existe deja!");
						request.setAttribute("listeMedecins", listeM);
						this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
					}
			}else {
				int ok = Facde_medecin.update(m);
				listeM =  Facde_medecin.liste();
				 if(ok == 1)
				 {
					 request.setAttribute("message","Medecin modifier!");
				 }else {
					 request.setAttribute("message","Medecin non modifier!");
				 }
	     
				request.setAttribute("listeMedecins", listeM);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
			}
		
		
		
	}

}
