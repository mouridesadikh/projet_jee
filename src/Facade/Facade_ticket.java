package Facade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import model.Caissier;
import model.Patient;
import model.Specialite;
import model.Ticket;

public class Facade_ticket {
    
	static Specialite sp;
	static Patient p;
	static Caissier c;
	static Ticket t;

	//methode qui genere les tickets
		public static  int genererTicket (Ticket t)
		{
			int ok = 0;
			 String req="insert into ticket values(null,'"+t.getCode()+"','"+t.getDatePrise()+"','"+t.getCaissier().getId()+"','"+ t.getSpecialite().getId()+"','"+t.getPatient().getId()+"')";
			 try {
				 ok = Connexion.executeMAJ(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 return ok;
		}
		
		
	//methode qui liste tou les ticket genere par un caissier 
		
	public static List<Ticket> liste()
	{
		List<Ticket> myliste = new ArrayList<Ticket>();
		ResultSet rs;
	
		String req="Select * from ticket t join specialite s on t.id_specialite = s.id "
				+ "join patient p  on t.id_patient=p.id join caissier c on t.id_caisse = c.id  ";
	
		try {
			rs =  Connexion.executeSELECT(req);
			System.out.println(rs.getMetaData());
			t=new Ticket();
			sp=new Specialite();
			c=new Caissier();
			p = new Patient();
		    while(rs.next())
		    {   
		    	t.setId(rs.getInt("id_t"));
		    	t.setCode(rs.getString("code"));
		    	t.setDatePrise(rs.getString("date_t"));
		    	sp.setNom(rs.getString("nom_s"));
		    	sp.setTarif(rs.getInt("tarif"));
		    	p.setMatricule(rs.getString("matricule"));
		    	p.setNom(rs.getString("nom_p"));
		    	p.setTel(rs.getString("tel"));
		    	c.setMatricule(rs.getString("matricule"));
		    	c.setNom(rs.getString("nom_c"));
		    	t.setCaissier(c);
		    	t.setPatient(p);
		    	t.setSpecialite(sp);
		    	myliste.add(t);
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myliste;
	}


public static int verifiee(String code)
{
	String req="select id_t from ticket where code='"+code+"'";
    int ok =0;
	ResultSet rs ;
	try {
	  
		rs = Connexion.executeSELECT(req);
        
		while(rs.next())
		{
			ok = rs.getRow();
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return ok;
}
public static  int delete(int id)
{
	
	int ok=0;
	String req="Delete from ticket where id_t ='"+id+"'";

	try {
		
		ok = Connexion.executeMAJ(req);
	
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ok;
}

}