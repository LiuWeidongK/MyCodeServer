package MySQL;

import DAO.studentInfo;
import Util.Jdbc;

import java.sql.*;
import java.util.ArrayList;

public class sql_StudentInfo {

    public Boolean work(studentInfo info){
        ArrayList<String> macs = info.getMacs();
        String id = info.getId();
        String randnum = info.getRandnumber();

        String tc_mac = this.selectMAC(randnum);

        if(macs.contains(tc_mac)){
            this.insertInfo(id,randnum);
            return true;
        } else {
            return false;
        }
    }

    private void insertInfo(String ids,String randnumber){
        Connection conn = Jdbc.conn();
        PreparedStatement pstm = null;

        String sql = "INSERT INTO DB_STUDENT (CODE,ID,NAME) VALUES (?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,randnumber);
            pstm.setString(2,ids);
            pstm.setString(3,"unknown");
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {                 //Close
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(pstm!=null)
                    pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String selectMAC(String randnumber){
        Connection conn = Jdbc.conn();
        Statement stmt = null;
        ResultSet rs;
        String tc_mac = null;
        String sql = "SELECT * FROM DB_TEACHER WHERE CODE='" + randnumber + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                tc_mac = rs.getString("ADDRESS");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {                 //Close
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
        return tc_mac;
    }
}


//{"Macs":[],"id":"258","randnumber":"147"}