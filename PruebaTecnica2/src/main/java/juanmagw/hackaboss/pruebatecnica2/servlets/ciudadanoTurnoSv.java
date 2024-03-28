package juanmagw.hackaboss.pruebatecnica2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import juanmagw.hackaboss.pruebatecnica2.logica.Ciudadano;
import juanmagw.hackaboss.pruebatecnica2.logica.Controladora;
import juanmagw.hackaboss.pruebatecnica2.logica.Turno;

@WebServlet(name = "ciudadanoTurnoSv", urlPatterns = {"/ciudadanoTurnoSv"})
public class ciudadanoTurnoSv extends HttpServlet {

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
        HttpSession miSesion = request.getSession();

        List<Turno> turnos = control.mostrarTurnos();
        List<Ciudadano> ciudadanos = control.mostrarCiudadanos();

        miSesion.setAttribute("turnos", turnos);
        miSesion.setAttribute("ciudadanos", ciudadanos);

        response.sendRedirect("ciudadanoTurno.jsp");
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
        Long ciudadanoTurno = Long.valueOf(request.getParameter("ciudadanoTurno"));
        Integer turnoCiudadano = Integer.valueOf(request.getParameter("turnoCiudadano"));

        Ciudadano ciudadano = control.mostrarCiudadanoId(ciudadanoTurno);
        Turno turno = control.mostrarTurnoNumero(turnoCiudadano);

        if (ciudadanoTurno.equals("") || ciudadanoTurno == null || turnoCiudadano.equals("") || turnoCiudadano == null) {
            //Mensaje de error
            response.sendRedirect("error.jsp");
        } else if (turno.getCiudadano() == null) {
            turno.setCiudadano(ciudadano);
            control.editarTurno(turno);
            response.sendRedirect("ciudadano.jsp");
        } else {
            //Mensaje de error
            response.sendRedirect("error.jsp");
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
