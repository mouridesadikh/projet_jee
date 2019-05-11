package Facade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import model.Caissier;
import model.GroupeSanguin;
import model.Medecin;
import model.Personne;
import model.Personnel;

public class Facade_caissier {

	static Caissier m;
	Personne pr;

	GroupeSanguin gs ;


	public Facade_caissier ()
	{
		
	}
	
	

	//method pour ajouter un Medecin
	public static int ajouterCaisser (Caissier m)
	{
		 
		int ok = 0;
		 String req="insert into caissier values(null,'"+m.getMatricule()+"','"+m.getNom()+"','"+m.getDateNaissance()+"','"+m.getTel()+"','"+m.getSexe()+"','"+m.getEmail()+"','"+m.getPassword()+"')";
		
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
		String req="select id from caissier where matricule='"+matricule+"'";
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
	
	public static List<Caissier>   recup(int id)
	{
		ResultSet rs ;
		List<Caissier> myliste = new ArrayList<Caissier>();
		String req="select * from caissier where id='"+id+"'";
     
	
		try {
		  
			rs = Connexion.executeSELECT(req);
			while(rs.next())
			{
				m=new Caissier(rs.getInt("id"), rs.getString("matricule"),rs.getString("nom_c"),rs.getString("dateNaisse"),rs.getString("tel"),rs.getString("sexe"),rs.getString("password"),rs.getString("email"));
				myliste.add(m);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return myliste;
	}
	public static List<Caissier> liste()
	{
		ResultSet rs ;
		List<Caissier> myliste = new ArrayList<Caissier>();
		String req="select * from caissier";

	     
		try {
			
			rs = Connexion.executeSELECT(req);
			//System.out.print("sante serigne bi"+rs.getMetaData());
			
			while(rs.next())
			{
				m=new Caissier(rs.getInt("id"), rs.getString("matricule"),rs.getString("nom_c"),rs.getString("dateNaisse"),rs.getString("tel"),rs.getString("sexe"),rs.getString("password"),rs.getString("email"));
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
		String req="Delete from caissier where id ='"+id+"'";

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
	public static int update(Caissier m )
	{
	
		int ok = 0;
   
		String req="update caissier set nom_c='"+m.getNom()+"', dateNaisse='"+m.getDateNaissance()+"', tel='"+m.getTel()+"',sexe='"+m.getSexe()+"',email='"+m.getEmail()+"',password='"+m.getPassword()+"' where id ='"+m.getId()+"'";
		try {
			
			ok = Connexion.executeMAJ(req);
		} catch (Exception e) {
			e.printStackTrace();
		   
		}
		return ok ;
	}

}
