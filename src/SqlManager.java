import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

public class SQLManager
{
        private Connection conn;
        private String mSQLUrl, mSQLLogin, mSQLPassword;
        
     
        public SQLManager(){       
        		mSQLUrl = "jdbc:mySQL://localhost:3306/database";
                loadSQLLoginData();
        }
        
        public String connect(){
                try {
                        Class.forName("com.mySQL.jdbc.Driver").newInstance();
                } 
                catch (InstantiationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                return "error";
                } 
                catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } 
                catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        
                try {
                    conn = DriverManager.getConnection(mSQLUrl, mSQLLogin, mSQLPassword);
                }catch (SQLException e) {
	                e.printStackTrace();
	                return e.toString();
                }
                return "ok";
        }
        
        private void disconnect(){
                try{
                        conn.close();
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.err.println(e.toString());
                }
        }
        
        public Connection getConnection(){
                return conn;
        }
        
    
        
        public String getTable(){
                connect();
                Statement statement;
                ResultSet rs;
                String wynik="";
              
                try {
                        statement = conn.createStatement();
                        rs = statement.executeQuery("SELECT name FROM users");
                
                        rs.next();
                        wynik = rs.getString(1);
                //      conn.close();
                } 
                catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.err.println(e.toString());
                }
                disconnect();
                return wynik;
        }
        
        /* Metoda <code>getQuery</code> pobiera z bazy danych 
         *  SELECT
         */
        public String executeQuery(String query){
                connect();
                Statement statement;
                ResultSet rs;
                String wynik="";
                
                try {
                        statement = conn.createStatement();
                        rs = statement.executeQuery(query);
                        rs.next();
                        wynik = rs.getString(1);
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.err.println(e.toString());
                                                return e.toString();
                }
                disconnect();
                return wynik;
        }
        
        /* Metoda <code>executeUpdate</code> zmienia dane w bazie 
         *  INSERT, UPDATE or DELETE
         */
        public String executeUpdate(String update){
                connect();
                Statement statement;
                                                             
                try {
                        statement = conn.createStatement();
                        statement.executeUpdate(update);                     
                }catch (SQLException e){
                        // TODO Auto-generated catch block
                        System.err.println(e.toString());
                                           return e.toString();
                }

        return "ok";
        }
        
    	public  void loadSQLLoginData(){
    		//jeśli bedziemy uzywac bazy na localhoscie to funkcja zbedna ale gdybysmy chcieli sie 
    		//polączyć z czymś na zewnątrz to może sie przydać
    		  FileInputStream fstream = null;
    			try{
    				fstream = new FileInputStream("config.cfg");
    			}catch(FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		  DataInputStream in = new DataInputStream(fstream);
    		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		   String strLine;
    		try{
    			if((strLine = br.readLine()) != null){
    				  mSQLLogin=strLine;
    			}
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    		  
    		try{
    			if((strLine = br.readLine()) != null){
    				  mSQLPassword=strLine;
    			  }
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
}