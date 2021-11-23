/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Blog.Admor;
import Blog.Anclado;
import Blog.Comentario;
import Blog.Comun;
import Blog.Usuario;
import Datos.RepAdmor;
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
@WebServlet(name = "manejoPublicacion", urlPatterns = {"/manejoPublicacion"})
public class manejoPublicacion extends HttpServlet {

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
            out.println("<title>Servlet manejoPublicacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manejoPublicacion at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect(request.getContextPath() + "/Login.html");
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

        //Recuperar datos
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        Date fechaCreacion = new Date();
        Date fechaEdicion = new Date();

        //Para la busqueda del usuario/admin
        String correo = request.getParameter("correo");
        RepAdmor radmin = new RepAdmor();
        RepNormal rn = new RepNormal();
        Admor admin = radmin.buscarPorCorreo(correo);
        Usuario usuario = rn.buscarPorCorreo(correo);
        //Aqui ya sea si es usuario o admin, buscamos su id y lo capturamos
        //Tambien se decide la pagina de destino en caso de ser admin o usuario normal
        //Establecemos el tipo de usuario como variable y establecemos su imagen de avatar
        ObjectId idAutor = null;
        String nombreAutor = null;
        String destino = null;
        if (admin != null) {
            idAutor = admin.getId();
            nombreAutor = admin.getNombreCompleto();
            destino = "principalAdministrador.jsp";
            request.setAttribute("admin", admin);
            //Imagen de avatar
            String url = "data:image/png;base64," + Base64.encode(admin.getAvatar());
            request.setAttribute("url", url);
        } else if (usuario != null) {
            idAutor = usuario.getId();
            nombreAutor = usuario.getNombreCompleto();
            destino = "principal.jsp";
            request.setAttribute("usuario", usuario);
            //Imagen de avatar
            String url = "data:image/png;base64," + Base64.encode(usuario.getAvatar());
            request.setAttribute("url", url);
        }

        //Obtenemos si es publicacion anclada o no
        String ancladoBool = request.getParameter("anclado");
        if (ancladoBool != null && ancladoBool.equalsIgnoreCase("On") && admin != null) {
            try {
                RepAnclado ra = new RepAnclado();
                Anclado anclado = new Anclado(idAutor, nombreAutor, fechaCreacion, contenido, titulo, fechaEdicion);
                ra.guardar(anclado);
                RequestDispatcher requestD = request.getRequestDispatcher(destino);
                getRetrieveAllPosts(request, response);
                getRetrieveAllComments(request, response);
                requestD.forward(request, response);
            } catch (DAOException e) {
            }
        } else {
            try {
                RepComun rc = new RepComun();
                Comun comun = new Comun(idAutor, nombreAutor, fechaCreacion, contenido, titulo, fechaEdicion);
                rc.guardar(comun);
                RequestDispatcher requestD = request.getRequestDispatcher(destino);
                getRetrieveAllPosts(request, response);
                getRetrieveAllComments(request, response);
                requestD.forward(request, response);
            } catch (DAOException e) {
            }
        }
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
