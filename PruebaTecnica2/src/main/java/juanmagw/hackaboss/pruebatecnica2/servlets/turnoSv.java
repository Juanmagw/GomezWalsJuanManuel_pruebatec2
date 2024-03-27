package juanmagw.hackaboss.pruebatecnica2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import juanmagw.hackaboss.pruebatecnica2.logica.Controladora;
import juanmagw.hackaboss.pruebatecnica2.logica.Turno;

@WebServlet(name = "turnoSv", urlPatterns = {"/turnoSv"})
public class turnoSv extends HttpServlet {

    Controladora control = new Controladora();

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
        String fecha = request.getParameter("fechaBuscar");
        
        HttpSession miSesion = request.getSession();

        miSesion.setAttribute("listaTurnoFecha", control.mostrarTurnosFecha(LocalDate.parse(fecha)));

        response.sendRedirect("mostrarTurnos.jsp");
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
        Integer numero = Integer.parseInt(request.getParameter("numeroCrear"));
        String fecha = request.getParameter("fechaCrear");
        String descripcion = request.getParameter("descripcionCrear");

        Turno turno = new Turno(numero, LocalDate.parse(fecha), descripcion);

        control.crearTurno(turno);

        response.sendRedirect("index.jsp");
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
