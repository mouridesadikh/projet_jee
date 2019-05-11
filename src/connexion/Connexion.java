package connexion;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connexion {

	    static Connection conn;
	    static Statement st;
	    static ResultSet result;
	    public Connexion(){
	        
	    }
	    
	    public static  Connection getConnexion()
	    {
	    	
	    	
	         String pilote = "com.mysql.jdbc.Driver";
	         String url="jdbc:mysql://localhost:3306/ges_cons";
	         String login="root";
	         String pass="";
	         
	        try {
	            Class.forName(pilote);
	             try {
	                 conn = (Connection) DriverManager.getConnection(url,login,pass);
	                
	             } catch (SQLException ex) 
	             {
	                 ex.printStackTrace();
	             }
	            } 
	        catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	       return conn;
	    }
	    
	    
	    public static int  executeMAJ(String sql){
	        int ok =0;
	        
	        try {
	            conn = getConnexion();
	            st = conn.createStatement();
	            ok = st.executeUpdate(sql);
	            
	            
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        }
	       
	        return ok;
	    }
	    
	   public static  ResultSet executeSELECT(String sql)
	   {
	         conn = getConnexion();
	        try {
	            st = conn.createStatement();
	            result = st.executeQuery(sql);
	         
               
	         
	           
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        }

	      return result;         
	   }
	   
	   }
