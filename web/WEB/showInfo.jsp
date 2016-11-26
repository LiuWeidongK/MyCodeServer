<%@ page import="DAO.resultInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Info</title>
    <style type="text/css">
        table.gridtable {
            font-family: verdana,arial,sans-serif;
            width: 75px;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
        }
        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }
        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<%
    resultInfo result = (resultInfo) session.getAttribute("result");
    ArrayList<String> list_id = result.getIds();
    ArrayList<String> list_name = result.getNames();
    int length = list_id.size();
%>
<table class="gridtable">
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <%
        for(int i=0;i<length;i++){
    %>
    <tr>
        <td><%=list_id.get(i)%></td>
        <td><%=list_name.get(i)%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
