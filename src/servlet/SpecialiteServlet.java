package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facade.Facade_patient;
import Facade.Facade_specialite;

import Facade.Facde_medecin;
import model.Medecin;
import model.Patient;
import model.Personnel;
import model.Specialite;

/**
 * Servlet implementation class SpecialiteServlet
 */
@WebServlet("/SpecialiteServlet")
public class SpecialiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Specialite m;
	

    List<Specialite> listeM;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String instruction = request.getParameter("ins");
			

			if(instruction==null)
			{      
				
	            listeM =  Facade_specialite.liste();
			    
				request.setAttribute("listeMedecins", listeM);
				this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
			}else if(instruction.equals("delete")) {
				
			     int id = Integer.parseInt(request.getParameter("id"));
			     
			 
			     int ok =  Facade_specialite.delete(id);
			   
				 listeM =  Facade_specialite.liste();
				 request.setAttribute("listeMedecins", listeM);
			     
			     if(ok == 1)
					{
						request.setAttribute("message","Specialite supprimer avec succees !");
					}else {
						request.setAttribute("message","Probleme suppression Specialite !");
				   }
				this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
			}else if(instruction.equals("modifier"))  {
				
				
				listeM =  Facade_specialite.recup(Integer.parseInt(request.getParameter("id")));
			    
				request.setAttribute("listeMedecins", listeM);
				this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/modifier.jsp").forward(request, response);
			}
			else {
				
			}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		m  = new Specialite(Integer.parseInt(request.getParameter("id")),request.getParameter("nom"),Integer.parseInt(request.getParameter("tarif")));
		

	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  Facde_medecin.verifiee(request.getParameter("nom"));
	
		if(test < 1)
		{
								try {
								
									int ok =  Facade_specialite.ajouter(m);
									
									listeM =  Facade_specialite.liste();
								    
									request.setAttribute("listeMedecins", listeM);
									if(ok == 1)
									{
										request.setAttribute("message","Speciaite ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton de specialite !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
				}else {
		             listeM =  Facade_specialite.liste();
		             request.setAttribute("message","cette matricule existe deja!");
					request.setAttribute("listeMedecins", listeM);
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
				}
		}else {
			int ok = Facade_specialite.update(m);
			listeM =  Facade_specialite.liste();
			 if(ok == 1)
			 {
				 request.setAttribute("message","Specialite modifier!");
			 }else {
				 request.setAttribute("message","Specialite non modifier!");
			 }
     
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
		}
		
		

	
}
}