package Class;

import DAO.RegistTeacherInfo;
import Util.JsonUtil;
import MySQL.sql_RegTeacher;
public class regTeacher {
    public void solve(String jsonStr) {
        RegistTeacherInfo registTeacherInfo = JsonUtil.JsonToObject(jsonStr,RegistTeacherInfo.class);
        sql_RegTeacher sql = new sql_RegTeacher();
        sql.work(registTeacherInfo);
    }
}
