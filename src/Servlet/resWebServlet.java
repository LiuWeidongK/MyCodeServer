package Servlet;

import DAO.resultInfo;
import MySQL.sql_ResultInfo;
import Util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "resWebServlet")
public class resWebServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        /*BufferedReader bufferedReader = request.getReader();
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }

        String keyRand = stringBuilder.toString();*/
        String keyRand = request.getParameter("s");
        sql_ResultInfo sql = new sql_ResultInfo();
        resultInfo result = sql.work(keyRand);

        request.getSession().setAttribute("result",result);
        response.sendRedirect("WEB/showInfo.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
