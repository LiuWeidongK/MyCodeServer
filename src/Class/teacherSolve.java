package Class;

import DAO.teacherInfo;
import MySQL.sql_TeacherInfo;
import Util.JsonUtil;

public class teacherSolve {

    public void solve(String jsonStr){

        teacherInfo info = JsonUtil.JsonToObject(jsonStr, teacherInfo.class);

        sql_TeacherInfo Sql = new sql_TeacherInfo();

        Sql.work(info);
    }
}
