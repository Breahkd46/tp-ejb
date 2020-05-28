<%-- 
    Document   : page1
    Created on : 18 mai 2020, 16:20:59
    Author     : valo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page import="entities.Etudiant" %>
<%@ page import="sessionbeans.EtudiantFacadeLocal" %>
<%@ page import="sessionbeans.FicheSyntheseFacadeLocal" %>
<%@ page import="entities.FicheSynthese" %>
<%

    Long etuId = (Long) request.getSession().getAttribute("etudiant");

    if (etuId == null) {
        response.sendRedirect("../etudiant/connexion.html");
        return;
    }

    EtudiantFacadeLocal etudiantFacadeLocal = null;
    FicheSyntheseFacadeLocal ficheSyntheseFacadeLocal = null;

    try {
        InitialContext ctx = new InitialContext();
        etudiantFacadeLocal = (EtudiantFacadeLocal)
                ctx.lookup("java:global/tp-ejb/EtudiantFacade!sessionbeans.EtudiantFacadeLocal");
        ficheSyntheseFacadeLocal = (FicheSyntheseFacadeLocal)
                ctx.lookup("java:global/tp-ejb/FicheSyntheseFacade!sessionbeans.FicheSyntheseFacadeLocal");
    } catch(Exception e) {
        e.printStackTrace();
    }

    String pageNameBase = request.getParameter("nom");
    if (pageNameBase == null) {
        pageNameBase = "page1.html";
    }
    String pageName = "../contenu/" + pageNameBase;

    assert etudiantFacadeLocal != null;
    Etudiant etudiant = etudiantFacadeLocal.find(etuId);

    assert ficheSyntheseFacadeLocal != null;
    FicheSynthese ficheSynthese = ficheSyntheseFacadeLocal.getByEtudiantAndByNomPage(etudiant, pageNameBase);

    if (ficheSynthese == null) {
        ficheSynthese = new FicheSynthese(pageNameBase, "", etudiant);
        etudiant.getFiches().add(ficheSynthese);
        etudiantFacadeLocal.edit(etudiant);
    }

    String textParam = request.getParameter("text");

    if (textParam != null) {
        ficheSynthese.setText(textParam);
        ficheSyntheseFacadeLocal.edit(ficheSynthese);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="<%=pageName %>" flush="true"/>
        <a href="../index.jsp">Revenir au menu</a>
        <form action="">
            <input type="hidden" name="nom" value="<%=request.getParameter("nom")%>">
            <textarea name="text"><%= ficheSynthese.getText() %></textarea>
            <button type="submit">Envoyer</button>
        </form>
    </body>
</html>
