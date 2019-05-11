package Facade;

import java.sql.ResultSet;

import connexion.Connexion;
import javafx.scene.chart.PieChart.Data;
import model.Caissier;
import model.Medecin;
import model.Personnel;

public class Login_Facade {

	
	static Personnel p ;
	static Medecin m;
	static Caissier c;
	
	public static String verifLogin(String email,String password,String type)
	{  
		ResultSet rs=null;
		String emailR = "";
		int ok = 0;
		String req = "select * from medecin m join Personnel p on m.matricule=p.matricule where email='"+email+"' and password='"+password+"'";
		String req2 = "select * from caissier m join Personnel p on m.matricule=p.matricule where email='"+email+"' and password='"+password+"'";
		if(type=="Medecin")
		{
			try {
				rs = Connexion.executeSELECT(req);
				if(rs!=null)
				{
					while(rs.next())
					{
						emailR = rs.getString("type");
					}
				}else {
					emailR ="";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				rs = Connexion.executeSELECT(req2);
				if(rs!=null)
				{
					while(rs.next())
					{
						emailR = rs.getString("type");
					}
				}else {
					emailR ="";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.print("dggdgd"+emailR);
		return emailR;
		
	}
}
