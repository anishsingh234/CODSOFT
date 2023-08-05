package Task3;
import java.sql.*;

public class dbConnect {
   

    public Connection getConnection() throws ClassNotFoundException, SQLException {
       
        String user = "root", pass = "root";
        String url = "jdbc:mysql://localhost:3306/studentdata";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
}
