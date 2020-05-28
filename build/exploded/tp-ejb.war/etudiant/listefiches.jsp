<%@ page import="javax.naming.InitialContext" %>
<%@ page import="sessionbeans.EtudiantFacadeLocal" %>
<%@ page import="sessionbeans.FicheSyntheseFacadeLocal" %>
<%@ page import="entities.Etudiant" %>
<%@ page import="entities.FicheSynthese" %><%--
  Created by IntelliJ IDEA.
  User: valo
  Date: 27/05/2020
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Long etuId = (Long) request.getSession().getAttribute("etudiant");
    if (etuId == null) {
        response.sendRedirect("../etudiant/connexion.html");
        return;
    }
    EtudiantFacadeLocal etudiantFacadeLocal = null;

    try {
        InitialContext ctx = new InitialContext();
        etudiantFacadeLocal = (EtudiantFacadeLocal)
                ctx.lookup("java:global/tp-ejb/EtudiantFacade!sessionbeans.EtudiantFacadeLocal");
    } catch(Exception e) {
        e.printStackTrace();
    }
    Etudiant etu = etudiantFacadeLocal.find(etuId);
%>
<html>
<head>
    <title>Fiche </title>
</head>
<body>
    <h1>Fiches</h1>
    <table>
        <thead>
            <tr>
                <th>page</th>
                <th>text</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (FicheSynthese ficheSynthese: etu.getFiches()) {
        %>
        <tr>
            <td><%= ficheSynthese.getNomPage()%></td>
            <td><%= ficheSynthese.getText()%></td>
        </tr>
        <%
            };
        %>
        </tbody>
    </table><br>
    <a href="../index.jsp">Retour a la page</a>
</body>
</html>
