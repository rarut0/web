package Acciones;

import ModeloDB.UsuarioDB;
import BasedeDatos.Rutas;
import Modelo.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/registrar"})
@MultipartConfig        
public class Registrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        String mail = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        int cp = Integer.parseInt(request.getParameter("codigo"));
        Date fechaNac = (Date)request.getAttribute("edad");
        String ciudad = request.getParameter("ciudad");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String provincia = request.getParameter("provincia");
        int movil = Integer.parseInt(request.getParameter("movil"));
        
        String url;
        Usuario u = new Usuario(0, nombre, apellido, nick, password,  direccion, cp,  mail, ciudad, provincia, telefono,  fechaNac);
        
        if (UsuarioDB.getUsuarioPorNick(nick)==null) {
            //El usuario se creo correctamente
            url = "/index.jsp";
            //JOptionPane.showMessageDialog(panel, "Usuario creado con exito.");
        } else {
            //El ya existe
            url = "/registrar.jsp";
            //JOptionPane.showMessageDialog(panel, "El usuario ya existe.");
        }
        
        // forward the request and response to the view
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response);
        
    }
       
    protected static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"",
                "");
                return fileName.substring(fileName.lastIndexOf('/') +
                1).substring(fileName.lastIndexOf('\\') + 1);
            }
            }   
        return null;
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }

