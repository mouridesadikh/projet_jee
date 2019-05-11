package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facade.Facade_caissier;
import Facade.Facade_patient;
import Facade.Facade_specialite;
import Facade.Facade_ticket;
import Facade.Facde_medecin;
import model.Caissier;
import model.Medecin;
import model.Patient;
import model.Personnel;
import model.Specialite;
import model.Ticket;

/**
 * Servlet implementation class TicketServlet
 */
@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Ticket m;
	 List<Ticket> listeM;
	 List<Caissier> listeC;
	 List<Specialite> listeS;
	 List<Patient> listeP;
	 Caissier c;
	 Specialite s;
	 Patient p;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketServlet() {
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
			
            listeM =  Facade_ticket.liste();
		    listeC = Facade_caissier.liste();
		    listeP = Facade_patient.liste();
		    listeS = Facade_specialite.liste();
			request.setAttribute("listeMedecins", listeM);
			request.setAttribute("listeCaisse", listeC);
			request.setAttribute("listeSpecialite", listeS);
			request.setAttribute("listePatient", listeP);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
		}else if(instruction.equals("delete")) {
			
		     int id = Integer.parseInt(request.getParameter("id"));
	
		 
		     int ok =  Facade_ticket.delete(id);

		        listeM =  Facade_ticket.liste();
			    listeC = Facade_caissier.liste();
			    listeP = Facade_patient.liste();
			    listeS = Facade_specialite.liste();
				request.setAttribute("listeMedecins", listeM);
				request.setAttribute("listeCaisse", listeC);
				request.setAttribute("listeSpecialite", listeS);
				request.setAttribute("listePatient", listeP);
		     
		     if(ok == 1)
				{
					request.setAttribute("message","Ticket supprimer avec succees !");
				}else {
					request.setAttribute("message","Probleme suppression de Ticket !");
			   }
			this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
		 
		     }
		else {
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		c = new Caissier(Integer.parseInt(request.getParameter("id_c")), "", "", "", "", "", "", "");
		p =new Patient(Integer.parseInt(request.getParameter("id_p")), "", "", "", "", "", "");
		s = new Specialite(Integer.parseInt(request.getParameter("id_s")),"", 0);
		
		m  = new Ticket(Integer.parseInt(request.getParameter("id")),request.getParameter("code"),request.getParameter("date"),s,p,c);
		

	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  Facade_ticket.verifiee(request.getParameter("code"));
	
		if(test < 1)
		{
								try {
								
									int ok =  Facade_ticket.genererTicket(m);
				
								        listeM =  Facade_ticket.liste();
									    listeC = Facade_caissier.liste();
									    listeP = Facade_patient.liste();
									    listeS = Facade_specialite.liste();
										request.setAttribute("listeMedecins", listeM);
										request.setAttribute("listeCaisse", listeC);
										request.setAttribute("listeSpecialite", listeS);
										request.setAttribute("listePatient", listeP);
									if(ok == 1)
									{
										request.setAttribute("message","Ticket ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton de Ticket !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
				}else {
					
				        listeM =  Facade_ticket.liste();
					    listeC = Facade_caissier.liste();
					    listeP = Facade_patient.liste();
					    listeS = Facade_specialite.liste();
						request.setAttribute("listeMedecins", listeM);
						request.setAttribute("listeCaisse", listeC);
						request.setAttribute("listeSpecialite", listeS);
						request.setAttribute("listePatient", listeP);
		             request.setAttribute("message","cette matricule existe deja!");
	
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
				}
		}else {
		
     
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
		}

	}

}
