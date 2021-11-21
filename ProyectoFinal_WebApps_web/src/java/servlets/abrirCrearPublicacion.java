/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Blog.Admor;
import Blog.Normal;
import Datos.RepAdmor;
import Datos.RepNormal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.internal.Base64;

/**
 *
 * @author carls
 */
@WebServlet(name = "abrirCrearPublicacion", urlPatterns = {"/abrirCrearPublicacion"})
public class abrirCrearPublicacion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet abrirCrearPublicacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet abrirCrearPublicacion at " + request.getContextPath() + "</h1>");
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
        String correo = request.getParameter("correo");
        String destino = request.getParameter("destino");
        RepNormal rn = new RepNormal();
        RepAdmor ra = new RepAdmor();
        Normal usuario = rn.buscarPorCorreo(correo);
        Admor admin = ra.buscarPorCorreo(correo);
        if (admin != null) {

            if(destino.equalsIgnoreCase("regresar")){
                destino="principalAdministrador.jsp";
            }
            
            RequestDispatcher requestD = request.getRequestDispatcher(destino);
            request.setAttribute("admin", admin);

            //Imagen de avatar
            String url = "data:image/png;base64," + Base64.encode(admin.getAvatar());
            request.setAttribute("url", url);

            requestD.forward(request, response);

        } else if (usuario != null) {
            
            if(destino.equalsIgnoreCase("regresar")){
                destino="principal.jsp";
            }
            
            RequestDispatcher requestD = request.getRequestDispatcher(destino);
            request.setAttribute("usuario", usuario);

            //Imagen de avatar
            String url = "data:image/png;base64," + Base64.encode(usuario.getAvatar());
            request.setAttribute("url", url);

            requestD.forward(request, response);
        }

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
