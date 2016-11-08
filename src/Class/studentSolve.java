package Class;

import DAO.studentInfo;
import MySQL.sql_StudentInfo;
import Util.JsonUtil;

public class studentSolve {

    public Boolean solve(String jsonStr){

        studentInfo info = JsonUtil.JsonToObject(jsonStr,studentInfo.class);

        sql_StudentInfo Sql = new sql_StudentInfo();

        return Sql.work(info);
    }
}
