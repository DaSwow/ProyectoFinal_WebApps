/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Blog.Comun;
import Blog.Normal;
import Datos.RepComun;
import Datos.RepNormal;
import Exceptions.DAOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class iniciarSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet iniciarSesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet iniciarSesion at " + request.getContextPath() + "</h1>");
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
        postValidateUserAuthInfo(request, response);
    }

    /**
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void postValidateUserAuthInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contra = request.getParameter("password");
        RepNormal rn = new RepNormal();
        Normal usuario = rn.buscarPorCorreoyContra(correo, contra);
        if (usuario != null) {
            String destino = "principal.jsp";
            RequestDispatcher requestD = request.getRequestDispatcher(destino);
            request.setAttribute("usuario", usuario);
            getRetrieveAllPosts(request, response);
            requestD.forward(request, response);
        } else {
            try ( PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>alert('El usuario o contraseña son incorrectos.');location='Login.html';</script>");
            }
        }
    }

    /**
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void getRetrieveAllPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RepComun commonPostsRepository = new RepComun();
            List<Comun> posts = commonPostsRepository.buscar();
            for (int i = 0; i < posts.size(); i++) {
                System.out.println(posts.get(i));
            }
            if (!posts.isEmpty()) {
                //String destino = "principal.jsp";
                //RequestDispatcher requestD = request.getRequestDispatcher(destino);
                request.setAttribute("commonPosts", posts);
                //requestD.forward(request, response);
            } else {
                //
            }
        } catch (DAOException ex) {
            Logger.getLogger(iniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
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
