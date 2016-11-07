package MySQL;

import DAO.teacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sql_TeacherInfo {

    public void work(teacherInfo info){
        Connection conn = Jdbc.conn();
        PreparedStatement pstm;

        String sql = "INSERT INTO DB_TEACHER (CODE,COURSE,ADDRESS) VALUES (?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,info.getRandNum());
            pstm.setString(2,info.getcName());
            pstm.setString(3,info.getMAC());
            pstm.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
