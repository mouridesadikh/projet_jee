package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Facade.Facade_patient;

import model.Patient;


/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Patient m;
	

    List<Patient> listeM;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlet() {
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
			
            listeM =  Facade_patient.liste();
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
		}else if(instruction.equals("delete")) {
			
		     int id = Integer.parseInt(request.getParameter("id"));
		     
		 
		     int ok =  Facade_patient.delete(id);
		   
			 listeM =  Facade_patient.liste();
			 request.setAttribute("listeMedecins", listeM);
		     
		     if(ok == 1)
				{
					request.setAttribute("message","Patient supprimer avec succees !");
				}else {
					request.setAttribute("message","Probleme suppression de patient !");
			   }
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
		}else if(instruction.equals("modifier"))  {
			
			
			listeM =  Facade_patient.recup(Integer.parseInt(request.getParameter("id")));
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/modifier.jsp").forward(request, response);
		}
		else {
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		m  = new Patient(Integer.parseInt(request.getParameter("id")),request.getParameter("matricule"),request.getParameter("nom"),request.getParameter("dateNaisse")
				,request.getParameter("tel"),request.getParameter("sexe"),request.getParameter("gs")
				);
		

	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  Facade_patient.verifiee(request.getParameter("matricule"));
	
		if(test < 1)
		{
								try {
								
									int ok =  Facade_patient.ajouter(m);
				
									listeM =  Facade_patient.liste();
								    
									request.setAttribute("listeMedecins", listeM);
									if(ok == 1)
									{
										request.setAttribute("message","Patient ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton patient !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
				}else {
		             listeM =  Facade_patient.liste();
		             request.setAttribute("message","cette matricule existe deja!");
					request.setAttribute("listeMedecins", listeM);
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
				}
		}else {
			int ok = Facade_patient.update(m);
			listeM =  Facade_patient.liste();
			 if(ok == 1)
			 {
				 request.setAttribute("message","Patient modifier!");
			 }else {
				 request.setAttribute("message","Patient non modifier!");
			 }
   
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
		}
		
		
		

	}

}
