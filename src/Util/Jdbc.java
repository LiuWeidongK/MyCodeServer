package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    public static Connection conn(){
        String drive = "com.mysql.jdbc.Driver";
        String type = "utf8";
        String url = "jdbc:mysql://localhost:3306/bluetooth?characterEncoding=" + type;
        String username = "root";
        String password = "0000";
        Connection conn = null;
        try {
            Class.forName(drive);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
