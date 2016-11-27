package MySQL;

import DAO.LoginInfo;
import Util.Jdbc;
import Util.JsonUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_Login {
    public boolean work(String jsonStr) {
        LoginInfo info = JsonUtil.JsonToObject(jsonStr,LoginInfo.class);
        String username = info.getUsername();
        String password = info.getPassword();
        String usertype = info.getType();

        return select(username,password,usertype);
    }

    private boolean select(String user,String pass,String type) {
        Connection conn = Jdbc.conn();
        Statement stmt = null;
        ResultSet rs;
        String db_name = null;
        switch (type) {
            case "TEACHER":
                db_name = "DB_REG_TEACHER";
                break;
            case "STUDENT":
                db_name = "DB_REG_STUDENT";
                break;
            default:
                return false;
        }

        String sql = "SELECT * FROM " + db_name + " WHERE USERNAME = '" + user + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String sPass = rs.getString("PASSWORD");
                if(sPass.equals(pass)){
                    return true;
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {                              //Close
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
