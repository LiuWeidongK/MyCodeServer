package Class;
import DAO.RegistStudentInfo;
import MySQL.sql_RegStudent;
import Util.JsonUtil;

public class regStudent {
    public void solve(String jsonStr) {
        RegistStudentInfo regS = JsonUtil.JsonToObject(jsonStr, RegistStudentInfo.class);
        sql_RegStudent sql = new sql_RegStudent();
        sql.work(regS);
    }
}
