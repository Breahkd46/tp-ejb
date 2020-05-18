<%-- 
    Document   : page3
    Created on : 18 mai 2020, 16:21:25
    Author     : valo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="tp.ejb.BaseSessionBeanLocal" %>
<% 
    String text = "";
    String date = "";
    try {
        BaseSessionBeanLocal baseSession = (BaseSessionBeanLocal) 
                request.getSession().getAttribute("base");
        if (baseSession == null) {
            System.out.println("Creation");
            InitialContext ctx = new InitialContext();
            baseSession = (BaseSessionBeanLocal) 
                    ctx.lookup("java:global/tp-ejb/BaseSessionBean"
                            + "!tp.ejb.BaseSessionBeanLocal");
            request.getSession().setAttribute("base", baseSession);
        }
        String textParam = request.getParameter("text");
        System.out.println(textParam);
        if (textParam != null) {
            System.out.println("set");
            baseSession.setText(textParam);
        }
        System.out.println(baseSession.getText());
        if (baseSession.getText() != null) {
            text = baseSession.getText();
            date = baseSession.getDate().toString();
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page 3</title>
    </head>
    <body>
        <h1>Page 3</h1>
        <br>
        <a href="../index.html">Revenir au menu</a>
        <p>Date : <%= date %></p>
        <form action="">
            
            <textarea name="text"><%= text %></textarea>
            <button type="submit">Envoyer</button>
        </form>
    </body>
</html>
