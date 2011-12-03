import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManager
{
        private Connection conn;
        private String url, userName, password;
        
        /* Konstruktor klasy <code>SqlManager<code>
          */
        public SQLManager()
        {       
                url = "jdbc:mySQL://localhost:3306/database";
                userName = "";
                password = "";
        }
        
        /* Metoda <code>connect</code> inicjuje po¸�czenie z baza
         * 
         */
        public String connect()
        {
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
                        conn = DriverManager.getConnection(url, userName, password);
                } 
                catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
                }
                return "ok";
        }
        
        /* Metoda <code>connect</code> 
         * 
         */
        private void disconnect()
        {
                try{
                        conn.close();
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.err.println(e.toString());
                }
        }
        
        public Connection getConnection()
        {
                return conn;
        }
        
        /*public PrepareStatement createPrepareStatement(String query)
        {
                return conn.createPrepareStatement(query);
        }*/
        
        public String getTable()
        {
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
        public String executeQuery(String query)
        {
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
        public String executeUpdate(String update)
        {
                connect();
                Statement statement;
                          
                                                  
                try {
                        statement = conn.createStatement();
                        statement.executeUpdate(update);
                        
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.err.println(e.toString());
                                           return e.toString();
                }

        return "ok";
        }
}