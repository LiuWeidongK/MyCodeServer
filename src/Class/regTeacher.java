package Class;

import DAO.RegistTeacherInfo;
import Util.JsonUtil;
import MySQL.sql_RegTeacher;
public class regTeacher {
    public boolean solve(String jsonStr) {
        RegistTeacherInfo registTeacherInfo = JsonUtil.JsonToObject(jsonStr,RegistTeacherInfo.class);
        sql_RegTeacher sql = new sql_RegTeacher();
        return sql.work(registTeacherInfo);
    }
}
