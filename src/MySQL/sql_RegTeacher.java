package MySQL;

import DAO.RegistTeacherInfo;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sql_RegTeacher {
    public void work(RegistTeacherInfo regT) {
        Connection conn = Jdbc.conn();
        PreparedStatement pstm = null;

        String sql = "INSERT INTO DB_REG_TEACHER (USERNAME,PASSWORD) VALUES (?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,regT.getUsername());
            pstm.setString(2,regT.getPassword());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {                 //Close
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
}
