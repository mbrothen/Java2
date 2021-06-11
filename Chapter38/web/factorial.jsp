<%-- 
    Document   : factorial
    Created on : Mar 17, 2019, 1:57:50 PM
    Author     : mbrothen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorial Table</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Factorial Table</h1>
        <table> 
            <tr><th>Number</th><th>Factorial</th></tr>
        <%
            //Generates factorial table in html
        String tr = "<tr><td>";
        String midRow = "</td><td>";
        String endTr = "</td></tr>";
        for (int i = 0; i<=10; i++){
            int currentFactorial = i;
            for (int j = 1; j < i; j++){
                currentFactorial = currentFactorial * j;
            } 
        %>
        <%-- print current row --%>
        <%= tr + i + midRow + currentFactorial +  endTr %>
           <%
        }
        %>        
        </table>
    </body>
</html>
