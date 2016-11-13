package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import Class.studentSolve;

@WebServlet(name = "studentServlet")
public class studentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        BufferedReader bufferedReader = request.getReader();
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        String jsonStr = stringBuilder.toString();
        System.out.println(jsonStr);
        studentSolve solve = new studentSolve();
        Boolean sign = solve.solve(jsonStr);
        System.out.println(sign);

        response.getWriter().write("ok");

        /*String jsonStr = request.getParameter("json");
        System.out.println(jsonStr);
        studentSolve solve = new studentSolve();
        Boolean sign = solve.solve(jsonStr);
        System.out.println(sign);
        response.getOutputStream().write("ok".getBytes());*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
