package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import Class.regTeacher;

@WebServlet(name = "TeacherRegServlet")
public class TeacherRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        BufferedReader bufferedReader = request.getReader();
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        String jsonStr = stringBuilder.toString();

        regTeacher reg = new regTeacher();
        boolean sign = reg.solve(jsonStr);

        response.getWriter().write(sign?"TRUE":"FALSE");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
