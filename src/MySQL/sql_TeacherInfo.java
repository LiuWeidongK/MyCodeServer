package MySQL;

import DAO.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sql_TeacherInfo {

    public void work(TeacherInfo info){
        Connection conn = Jdbc.conn();
        PreparedStatement pstm;

        String sql = "INSERT INTO DB_TEACHER (CODE,COURSE,ADDRESS) VALUES (?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,info.getRandNumber());
            pstm.setString(2,info.getcName());
            pstm.setString(3,info.getMAC());
            pstm.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
