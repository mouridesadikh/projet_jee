package Facade;

import model.Caissier;
import model.GroupeSanguin;
import model.Medecin;
import model.Patient;
import model.Personne;
import model.Personnel;
import model.Specialite;
import model.Ticket;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.SystemException;

import connexion.*;
public class Facde_medecin {
  
	
	static Medecin m;
	Personne pr;
	Caissier c;
	GroupeSanguin gs ;


	public Facde_medecin ()
	{
		
	}
	
	//method pour ajouter un Medecin
	public static int ajouterMedecin (Medecin m)
	{
		 
		int ok = 0;
		 String req="insert into medecin values(null,'"+m.getMatricule()+"','"+m.getNom()+"','"+m.getDateNaissance()+"','"+m.getTel()+"','"+m.getSexe()+"','"+m.getGrade()+"','"+m.getEmail()+"','"+m.getPassword()+"')";
		
		 try {
			
			 ok = Connexion.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		 return ok;
	}
	
  public static int ajoutP(Personnel pr)
  {
	  int ok = 0;
		
		 String req = "insert into personnel values(null,'"+pr.getMatricule()+"','"+pr.getFonction()+"')";
		
		 try {
			
			 ok = Connexion.executeMAJ(req);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		 return ok;
	  
  }
	
	//methode pour lister tout le medecinr
	public static int verifiee(String matricule)
	{
		String req="select id from medecin where matricule='"+matricule+"'";
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
	
	public static List<Medecin>   recup(int id)
	{
		ResultSet rs ;
		List<Medecin> myliste = new ArrayList<Medecin>();
		String req="select * from medecin where id='"+id+"'";
     
	
		try {
		  
			rs = Connexion.executeSELECT(req);
			while(rs.next())
			{
				m=new Medecin(rs.getInt("id"), rs.getString("matricule"),rs.getString("nomM"),rs.getString("dateNaisse"),rs.getString("tel"),rs.getString("sexe"),rs.getString("password"),rs.getString("email"),rs.getString("grade"));
				myliste.add(m);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		myliste.forEach(p->{
			System.out.println(p.getEmail());
		});
		return myliste;
	}
	public static List<Medecin> liste()
	{
		ResultSet rs ;
		List<Medecin> myliste = new ArrayList<Medecin>();
		String req="select * from medecin";

	     
		try {
			
			rs = Connexion.executeSELECT(req);
			//System.out.print("sante serigne bi"+rs.getMetaData());
			
			while(rs.next())
			{
				m=new Medecin(rs.getInt("id"), rs.getString("matricule"),rs.getString("nomM"),rs.getString("dateNaisse"),rs.getString("tel"),rs.getString("sexe"),rs.getString("password"),rs.getString("email"),rs.getString("grade"));
				myliste.add(m);
				
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
		String req="Delete from medecin where id ='"+id+"'";

		try {
			
			ok = Connexion.executeMAJ(req);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
	}
	
	public static  int deleteP(String matricule)
	{
		
		int ok=0;

		String req="Delete from personnel where matricule='"+matricule+"'";
		try {
			
			ok = Connexion.executeMAJ(req);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
	}
	
	
	//methode pour modfier un medecin
	public static int update(Medecin m )
	{
	
		int ok = 0;
   
		String req="update medecin set nomM='"+m.getNom()+"', dateNaisse='"+m.getDateNaissance()+"', tel='"+m.getTel()+"',sexe='"+m.getSexe()+"',grade='"+m.getGrade()+"',email='"+m.getEmail()+"',password='"+m.getPassword()+"' where id ='"+m.getId()+"'";
		try {
			
			ok = Connexion.executeMAJ(req);
		} catch (Exception e) {
			e.printStackTrace();
		   
		}
		return ok ;
	}
	
	
}
