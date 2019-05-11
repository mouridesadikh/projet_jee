package Facade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import model.Consultation;
import model.Medecin;
import model.Patient;
import model.Ticket;

public class Facade_consultation {
	static Medecin m;
    static Ticket t;
    static Consultation c;

	public Facade_consultation ()
	{
		
	}
	
	

	//method pour ajouter un Medecin
	public static int ajouter (Consultation cs)
	{
		 
		int ok = 0;
		 String req="insert into consultation  values(null,'"+cs.getDate()+"','"+cs.getTherapie()+"','"+cs.getOrdonnance()+"','"+cs.getMedecin().getId()+"','"+cs.getTicket().getId()+"')";
		
		 try {
			
			 ok = Connexion.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		 return ok;
	}
	
 
	
	
	
	public static List<Consultation>   recup(int id)
	{
		ResultSet rs ;
		List<Consultation> myliste = new ArrayList<Consultation>();
		String req="select * from consultation where id='"+id+"'";
     
	
		try {
		  
			rs = Connexion.executeSELECT(req);
			while(rs.next())
			{
				m = new Medecin();
				t = new Ticket();
				m.setNom(rs.getString("matricule"));
				t.setCode(rs.getString("code"));
				c=new Consultation(rs.getInt("id"), rs.getString("date"),rs.getString("therapie"),rs.getString("ordonnance"),t,m);
				myliste.add(c);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return myliste;
	}
	public static List<Consultation> liste()
	{
		ResultSet rs ;
		List<Consultation> myliste = new ArrayList<Consultation>();
		String req="select * from consultation";

	     
		try {
			
			rs = Connexion.executeSELECT(req);
			System.out.print("sante serigne bi"+rs.getMetaData());
			
			while(rs.next())
			{

				c=new Consultation(rs.getInt("id"),rs.getString("date"),rs.getString("therapie"),rs.getString("ordonnance"),t,m);
				myliste.add(c);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return myliste;
	}
   	
	//methode por supprimer un medecin
	public static  int delete(int id)
	{
		
		int ok=0;
		String req="Delete from consultation where id ='"+id+"'";

		try {
			
			ok = Connexion.executeMAJ(req);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
	}
	
	
	


}
