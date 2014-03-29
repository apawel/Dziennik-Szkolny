package dziennik_szkolny;
import java.sql.*;

public class DAO_Dziennik {

	   private final static String DBURL = "jdbc:mysql://dev.uek.krakow.pl:3306/plysiu_apawel";
	    private final static String DBUSER = "plysiu";
	    private final static String DBPASS = "sonalcsway";
	    private final static String DBDRIVER = "com.mysql.jdbc.Driver";
	    
	    private static Connection connection;
	    private static Statement statement;
	    private static String query;
	    public static void main(String[] args) {
	    	int count = 0;
	    	query = "SELECT * FROM  `Klasa` ";
	        try {
	            Class.forName(DBDRIVER).newInstance();
	            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	            statement = connection.createStatement();
	            ResultSet result = statement.executeQuery(query);
	            while(result.next()) {
	            	   count =  result.getInt("COUNT");
	            	}
	                        statement.close();
	                        connection.close();
	            
	        } catch (InstantiationException | IllegalAccessException
	                | ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }


}
