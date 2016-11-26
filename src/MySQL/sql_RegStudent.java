package MySQL;

import DAO.RegistStudentInfo;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sql_RegStudent {
    public void work(RegistStudentInfo regS) {
        Connection conn = Jdbc.conn();
        PreparedStatement pstm = null;

        String sql = "INSERT INTO DB_REG_STUDENT (NAME,_CLASS,ID,GENDER,USERNAME,PASSWORD) VALUES (?,?,?,?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,regS.getName());
            pstm.setString(2,regS.get_class());
            pstm.setString(3,regS.getId());
            pstm.setString(4,regS.getSex());
            pstm.setString(5,regS.getUsername());
            pstm.setString(6,regS.getPassword());
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
