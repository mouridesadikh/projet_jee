package Facade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import model.Caissier;
import model.GroupeSanguin;
import model.Medecin;
import model.Patient;
import model.Personne;
import model.Personnel;

public class Facade_patient {
	static Patient m;



	public Facade_patient ()
	{
		
	}
	
	

	//method pour ajouter un Medecin
	public static int ajouter (Patient m)
	{
		 
		int ok = 0;
		 String req="insert into patient values(null,'"+m.getMatricule()+"','"+m.getNom()+"','"+m.getDateNaissance()+"','"+m.getTel()+"','"+m.getSexe()+"','"+m.getGroupeSanguin()+"')";
		
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
		String req="select id from patient where matricule='"+matricule+"'";
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
	
	public static List<Patient>   recup(int id)
	{
		ResultSet rs ;
		List<Patient> myliste = new ArrayList<Patient>();
		String req="select * from patient where id='"+id+"'";
     
	
		try {
		  
			rs = Connexion.executeSELECT(req);
			while(rs.next())
			{
				m=new Patient(rs.getInt("id"), rs.getString("matricule"),rs.getString("nom_p"),rs.getString("dateNaisse"),rs.getString("tel"),rs.getString("sexe"),rs.getString("groupeSanguin"));
				myliste.add(m);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return myliste;
	}
	public static List<Patient> liste()
	{
		ResultSet rs ;
		List<Patient> myliste = new ArrayList<Patient>();
		String req="select * from patient";

	     
		try {
			
			rs = Connexion.executeSELECT(req);
			System.out.print("sante serigne bi"+rs.getMetaData());
			
			while(rs.next())
			{
				System.out.println(rs.getString("nom_p"));
				m=new Patient(rs.getInt("id"), rs.getString("matricule"),rs.getString("nom_p").toString(),rs.getString("dateNaisse"),rs.getString("tel"),rs.getString("sexe"),rs.getString("groupeSanguin"));
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
		String req="Delete from patient where id ='"+id+"'";

		try {
			
			ok = Connexion.executeMAJ(req);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
	}
	
	
	
	
	//methode pour modfier un medecin
	public static int update(Patient m )
	{
	
		int ok = 0;
   
		String req="update patient set nom_p='"+m.getNom()+"', dateNaisse='"+m.getDateNaissance()+"', tel='"+m.getTel()+"',sexe='"+m.getSexe()+"',groupeSanguin='"+m.getGroupeSanguin()+"' where id ='"+m.getId()+"'";
		try {
			
			ok = Connexion.executeMAJ(req);
		} catch (Exception e) {
			e.printStackTrace();
		   
		}
		return ok ;
	}
}
