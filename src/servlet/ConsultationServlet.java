package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facade.Facade_caissier;
import Facade.Facade_consultation;
import Facade.Facade_patient;
import Facade.Facade_specialite;
import Facade.Facade_ticket;
import Facade.Facde_medecin;
import model.Caissier;
import model.Consultation;
import model.Medecin;
import model.Patient;
import model.Specialite;
import model.Ticket;

/**
 * Servlet implementation class ConsultationServlet
 */
@WebServlet("/ConsultationServlet")
public class ConsultationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Ticket t;
	 List<Ticket> listeT;
	 List<Medecin> listeM;
	 List<Consultation> listeC;
	 Medecin m;
	 Consultation c;
	 Patient p;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultationServlet() {
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
				
	            listeT =  Facade_ticket.liste();
			    listeC = Facade_consultation.liste();
			    listeM = Facde_medecin.liste();
			
				request.setAttribute("listeMedecins", listeM);
				request.setAttribute("listeTicket", listeT);
				request.setAttribute("listeConsultation", listeC);
		
				this.getServletContext().getRequestDispatcher("/WEB-INF/Consultation/index.jsp").forward(request, response);
			}else if(instruction.equals("delete")) {
				
			     int id = Integer.parseInt(request.getParameter("id"));
		
			 
			     int ok =  Facade_ticket.delete(id);

					
		            listeT =  Facade_ticket.liste();
				    listeC = Facade_consultation.liste();
				    listeM = Facde_medecin.liste();
				
					request.setAttribute("listeMedecins", listeM);
					request.setAttribute("listeTicket", listeT);
					request.setAttribute("listeConsultation", listeC);
			     
			     if(ok == 1)
					{
						request.setAttribute("message","Consultation supprimer avec succees !");
					}else {
						request.setAttribute("message","Probleme suppression Consultation !");
				   }
				this.getServletContext().getRequestDispatcher("/WEB-INF/Consultation/index.jsp").forward(request, response);
			 
			     }
			else {
				
			}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		t = new Ticket();
		t.setId(Integer.parseInt(request.getParameter("id_t")));	
		m = new Medecin();
		m.setId(Integer.parseInt(request.getParameter("id_m")));
		
		
		c  = new Consultation(Integer.parseInt(request.getParameter("id")),request.getParameter("date"),request.getParameter("therapie"),request.getParameter("ordonnance"),t,m);
		

	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
					try {
								
									int ok =  Facade_consultation.ajouter(c);
				
									listeT =  Facade_ticket.liste();
								    listeC = Facade_consultation.liste();
								    listeM = Facde_medecin.liste();
								
									request.setAttribute("listeMedecins", listeM);
									request.setAttribute("listeTicket", listeT);
									request.setAttribute("listeConsultation", listeC);
							     
									if(ok == 1)
									{
										request.setAttribute("message","Consultation ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton de Consultation !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Consultation/index.jsp").forward(request, response);
				
		}else {
		
     
			listeT =  Facade_ticket.liste();
		    listeC = Facade_consultation.liste();
		    listeM = Facde_medecin.liste();
		
			request.setAttribute("listeMedecins", listeM);
			request.setAttribute("listeTicket", listeT);
			request.setAttribute("listeConsultation", listeC);
	     
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Consultation/index.jsp").forward(request, response);
		}

	}

}
