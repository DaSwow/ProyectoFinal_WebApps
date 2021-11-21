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
import Exceptions.DAOException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Carlos
 */
@MultipartConfig
public class registroCuenta extends HttpServlet {

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
            out.println("<title>Servlet registroCuenta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroCuentatest at " + request.getContextPath() + "</h1>");
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
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contrasenia");
        String telefono = request.getParameter("telefono");
        String ciudad = request.getParameter("ciudad");
        String admn = request.getParameter("admin");

        //Logotipo - Avatar
        Part filePart = request.getPart("logotipo"); //
        InputStream fileContent = filePart.getInputStream();
        byte[] logotipoConvertido = IOUtils.toByteArray(fileContent);

        //Fecha de nacimiento
        String fechaAux = request.getParameter("fechaNacimiento");

        Date fechaNacimiento = new Date();
        try {
            fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaAux);
        } catch (ParseException ex) {
        }

        //Genero
        String genero = request.getParameter("sexo");

        // Hash password
        String generatedSecuredPasswordHash
                = generateStrongPasswordHash(contra);
        System.out.println(generatedSecuredPasswordHash);

        RepAdmor ra = new RepAdmor();
        RepNormal rn = new RepNormal();

        //algun metodo para sacar el contenido del checkbox para admin y hacer lo de abajo
        if (rn.buscarPorCorreo(correo) == null && ra.buscarPorCorreo(correo) == null) {
            //te dice que ya esta registrado si no
            if (admn.equalsIgnoreCase("On")) {
                try {
                    Admor admin = new Admor(nombre, correo, generatedSecuredPasswordHash, telefono, ciudad, fechaNacimiento, genero, logotipoConvertido);
                    ra.guardar(admin);
                    String destino = "Login.html";
                    RequestDispatcher requestD = request.getRequestDispatcher(destino);
                    requestD.forward(request, response);
                } catch (DAOException ex) {

                }
            } else {
                try {
                    Normal usuario = new Normal(nombre, correo, generatedSecuredPasswordHash, telefono, ciudad, fechaNacimiento, genero, logotipoConvertido);
                    rn.guardar(usuario);
                    String destino = "Login.html";
                    RequestDispatcher requestD = request.getRequestDispatcher(destino);
                    requestD.forward(request, response);
                } catch (DAOException ex) {

                }
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>alert('Ya existe un usuario registrado con el mismo correo');location='RegistroDeCuenta.html';</script>");
            }

        }
    }

    /*
    /**
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //    private void postRegisterUserAuthInfo(HttpServletRequest request, HttpServletResponse response)
    //            throws ServletException, IOException {
    //        String nombre = request.getParameter("nombre");
    //        String correo = request.getParameter("correo");
    //        String contra = request.getParameter("contrasenia");
    //        String telefono = request.getParameter("telefono");
    //        String ciudad = request.getParameter("ciudad");
    //        Date fechaNac = new Date(); //request.getParameter("fechaNacimiento");
    //
    //        String genero;
    //        if (request.getParameter("sexo").equals("on")) {
    //            genero = "Hombre";
    //        } else {
    //            genero = "Mujer";
    //        }
    //
    //        // Hash password for obligatory security measures
    //        String generatedSecuredPasswordHash
    //                = generateStrongPasswordHash(contra);
    //        System.out.println(generatedSecuredPasswordHash);
    //
    //        Normal usuario = new Normal(nombre, correo, generatedSecuredPasswordHash, telefono, ciudad, fechaNac, genero, );
    //        RepNormal rn = new RepNormal();
    //        if (rn.buscarPorCorreo(correo) == null) {
    //            try {
    //                rn.guardar(usuario);
    //                String destino = "Login.html";
    //                RequestDispatcher requestD = request.getRequestDispatcher(destino);
    //                requestD.forward(request, response);
    //            } catch (DAOException ex) {
    //            }
    //        } else {
    //            try (PrintWriter out = response.getWriter()) {
    //                out.println("<script type='text/javascript'>alert('Ya existe un usuario registrado con el mismo correo');location='RegistroDeCuenta.html';</script>");
    //            }
    //        }
    //    }
    /**
     *
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static String generateStrongPasswordHash(String password) {
        try {
            int iterations = 1000;
            char[] chars = password.toCharArray();
            byte[] salt = getSalt();

            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] hash = skf.generateSecret(spec).getEncoded();
            return iterations + ":" + toHex(salt) + ":" + toHex(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
        }
        return null;
    }

    /**
     *
     * @return @throws NoSuchAlgorithmException
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        System.out.println("Generated salt: " + Arrays.toString(salt));
        return salt;
    }

    /**
     *
     * @param array
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
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
