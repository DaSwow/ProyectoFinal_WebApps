/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Blog.Anclado;
import Blog.Comentario;
import Blog.Comun;
import Blog.Usuario;
import Datos.RepAnclado;
import Datos.RepComentarios;
import Datos.RepComun;
import Datos.RepNormal;
import Exceptions.DAOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.internal.Base64;
import org.bson.types.ObjectId;

/**
 *
 * @author carls
 */
@WebServlet(name = "manejoComentarios", urlPatterns = {"/manejoComentarios"})
public class manejoComentarios extends HttpServlet {

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
            out.println("<title>Servlet manejoComentarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manejoComentarios at " + request.getContextPath() + "</h1>");
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

        //Para la busqueda del usuario/admin
        String correo = request.getParameter("correo");
        String contenidoComentario = request.getParameter("comentario");
        RepNormal rn = new RepNormal();
        Usuario usuario = rn.buscarPorCorreo(correo);

        
        String autorComentario = null;
        String destino = null;
        if (usuario != null) {
            //Obtener el id del post 
            autorComentario = usuario.getNombreCompleto();
            RepComun rcomun = new RepComun();
            Comun comun = null;
            try {
                comun = rcomun.buscar(new ObjectId(request.getParameter("idPost")));
            } catch (DAOException e) {
            }
            //Destino
            destino = "principal.jsp";
            request.setAttribute("usuario", usuario);
            //Imagen de avatar
            String url = "data:image/png;base64," + Base64.encode(usuario.getAvatar());
            request.setAttribute("url", url);

            RepComentarios rc = new RepComentarios();
            Comentario comentario = new Comentario(comun.getId(),
                    autorComentario, new Date(), contenidoComentario);
            try {
                rc.guardar(comentario);
            } catch (DAOException e) {
            }
            RequestDispatcher requestD = request.getRequestDispatcher(destino);
            getRetrieveAllPosts(request, response);
            getRetrieveAllComments(request, response);
            requestD.forward(request, response);
        }

        processRequest(request, response);
    }

    private void getRetrieveAllPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RepComun commonPostsRepository = new RepComun();
            List<Comun> posts = commonPostsRepository.buscar();

            RepAnclado pinnedPostsRepository = new RepAnclado();
            List<Anclado> pinnedPosts = pinnedPostsRepository.buscar();

            if (posts != null && !posts.isEmpty()) {
                //String destino = "principal.jsp";
                //RequestDispatcher requestD = request.getRequestDispatcher(destino);
                request.setAttribute("commonPosts", posts);
                //requestD.forward(request, response);
            }
            if (pinnedPosts != null && !pinnedPosts.isEmpty()) {
                //String destino = "principal.jsp";
                //RequestDispatcher requestD = request.getRequestDispatcher(destino);
                request.setAttribute("pinnedPosts", pinnedPosts);
                //requestD.forward(request, response);
            }
        } catch (DAOException ex) {
            Logger.getLogger(iniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getRetrieveAllComments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RepComentarios commentariosRepository = new RepComentarios();
            List<Comentario> comentarios = commentariosRepository.buscar();
            if (comentarios != null && !comentarios.isEmpty()) {
                request.setAttribute("comments", comentarios);
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
