package Class;

import DAO.TeacherInfo;
import MySQL.sql_TeacherInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class teacherSolve {

    public void solve(String json) throws JSONException {

        JSONObject jsonObject = new JSONObject(json);

        TeacherInfo info = new TeacherInfo(jsonObject.getString("randNum"),jsonObject.getString("cName"),jsonObject.getString("MAC"));

        sql_TeacherInfo Sql = new sql_TeacherInfo();
        Sql.work(info);
    }
}
