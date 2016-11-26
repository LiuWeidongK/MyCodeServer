package MySQL;

import DAO.resultInfo;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sql_ResultInfo {
    private resultInfo re;
    public resultInfo work(String keyRand){
        Connection conn = Jdbc.conn();
        Statement stmt = null;
        ResultSet rs;
        ArrayList<String> s_ids = new ArrayList<>();
        ArrayList<String> s_names = new ArrayList<>();

        String sql = "SELECT * FROM DB_STUDENT WHERE CODE='" + keyRand + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                if(!id.isEmpty()&&!name.isEmpty()){
                    s_ids.add(id);
                    s_names.add(name);
                }
            }
            re = new resultInfo(s_ids,s_names);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {                              //Close
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(stmt!=null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return re;
    }
}
