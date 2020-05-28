/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.ejb;

import entities.Etudiant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.EtudiantFacadeLocal;

/**
 *
 * @author valo
 */
@WebServlet(name = "CreateUserServlet", urlPatterns = {"/createUser"})
public class CreateUserServlet extends HttpServlet {
    
    @EJB
    EtudiantFacadeLocal facade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Integer age = Integer.valueOf(request.getParameter("age"));
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if (nom == null || prenom == null || login == null || password == null || age == null) {
                out.println("Invalid parameters");
            } else {
                Etudiant etu = new Etudiant(nom, prenom, login, password, age);
                facade.create(etu);
                out.println("<p>Utilisatuer créé : " + nom + " " + prenom + "</p>");
            }
            out.println("<a href=\"etudiant/creer.html\">Creer un autre utilisateur</a>");
            out.println("<a href=\"etudiant/connexion.html\">Se connecter</a>");
            out.println("<a href=\"index.jsp\">Retour au menu</a>");
            facade.findAll().forEach(etudiant -> {
                out.println("<p>"+ etudiant.getNom() + "</p>");
            });
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
