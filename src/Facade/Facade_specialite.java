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
import model.Specialite;

public class Facade_specialite {

	
	 

	
	static Specialite m;



	public Facade_specialite ()
	{
		
	}
	
	

	//method pour ajouter un Medecin
	public static int ajouter (Specialite m)
	{
		 
		int ok = 0;
		 String req="insert into specialite values(null,'"+m.getNom()+"','"+m.getTarif()+"')";
		
		 try {
			
			 ok = Connexion.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		 return ok;
	}
	
  
	
	//methode pour lister tout le medecinr
	public static int verifiee(String nom)
	{
		String req="select id from specialite where nom_s='"+nom+"'";
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
	
	public static List<Specialite>   recup(int id)
	{
		ResultSet rs ;
		List<Specialite> myliste = new ArrayList<Specialite>();
		String req="select * from specialite where id='"+id+"'";
     
	
		try {
		  
			rs = Connexion.executeSELECT(req);
			while(rs.next())
			{
				m=new Specialite(rs.getInt("id"), rs.getString("nom_s"),rs.getInt("tarif"));
				myliste.add(m);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return myliste;
	}
	public static List<Specialite> liste()
	{
		ResultSet rs ;
		List<Specialite> myliste = new ArrayList<Specialite>();
		String req="select * from specialite";

	     
		try {
			
			rs = Connexion.executeSELECT(req);
			//System.out.print("sante serigne bi"+rs.getMetaData());
			
			while(rs.next())
			{
				m=new Specialite(rs.getInt("id"), rs.getString("nom_s"),rs.getInt("tarif"));
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
		String req="Delete from specialite where id ='"+id+"'";

		try {
			
			ok = Connexion.executeMAJ(req);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
	}
	
	
	
	
	//methode pour modfier un medecin
	public static int update(Specialite m )
	{
	
		int ok = 0;
   
		String req="update specialite set nom_s='"+m.getNom()+"', nom='"+m.getNom()+"', tarif='"+m.getTarif()+"' where id ='"+m.getId()+"'";
		try {
			
			ok = Connexion.executeMAJ(req);
		} catch (Exception e) {
			e.printStackTrace();
		   
		}
		return ok ;
	}
	
}
