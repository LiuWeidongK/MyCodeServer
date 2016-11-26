package MySQL;

import DAO.LoginInfo;
import Util.Jdbc;
import Util.JsonUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class sql_Login {
    public void work(String jsonStr) {
        LoginInfo info = JsonUtil.JsonToObject(jsonStr,LoginInfo.class);
        String username = info.getUsername();
        String password = info.getPassword();

        select(username,password);
    }

    private void select(String user,String pass) {
        Connection conn = Jdbc.conn();
        Statement stmt = null;
        ResultSet rs;

        String slq = "";
    }
}
