package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public Connection getConnection(){
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/quan_ly_benh_an";
        String user = "root";
        String password = "ahhoang00374";
        try{
            System.out.println("ok");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("not ok");
        }
        return connection;
    }
}
