package Class;
import DAO.RegistStudentInfo;
import MySQL.sql_RegStudent;
import Util.JsonUtil;

public class regStudent {
    public boolean solve(String jsonStr) {
        RegistStudentInfo regS = JsonUtil.JsonToObject(jsonStr, RegistStudentInfo.class);
        sql_RegStudent sql = new sql_RegStudent();
        return sql.work(regS);
    }
}
