<%-- 
    Document   : index
    Created on : 26 mai 2020, 20:47:24
    Author     : valo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sessionbeans.EtudiantFacadeLocal" %>
<%@page import="entities.Etudiant" %>
<%@page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="entities.FicheSynthese" %>
<%
    EtudiantFacadeLocal facade = null;
    try {
        InitialContext ctx = new InitialContext();
        facade = (EtudiantFacadeLocal)
                ctx.lookup("java:global/tp-ejb/EtudiantFacade!sessionbeans.EtudiantFacadeLocal");
    } catch (NamingException e) {
        e.printStackTrace();
    }
    Long etuId = (Long) request.getSession().getAttribute("etudiant");
    if (etuId == null) {
        response.sendRedirect("index.html");
        return;
    } else {

    }
    assert facade != null;
    Etudiant etu = facade.find(etuId);
    System.out.println(etu.getFiches());
    System.out.println(etu.getFiches().size());
    for(FicheSynthese ficheSynthese: etu.getFiches()){
        System.out.println(ficheSynthese.getNomPage());
    };
%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1><%=etu.getPrenom()%> <%=etu.getNom()%></h1><br>
        <p>Age: <%= etu.getAge()%></p>
        <h1>INDEX</h1>
        <a href="basique/page.jsp?nom=page1.html">Page 1</a><br>
        <a href="basique/page.jsp?nom=page2.html">Page 2</a><br>
        <a href="basique/page.jsp?nom=page3.html">Page 3</a><br>
        <br>
        <a href="etudiant/listefiches.jsp">Fiches</a>
    </body>
</html>
