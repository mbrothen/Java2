package factorial;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mbrothen
 * Servelet that calls getTable that generates a factorial table
 */
@WebServlet(name = "factorial", urlPatterns = {"/factorial"})
public class factorial extends HttpServlet {

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
            out.println("<title>Servlet factorial</title>");       
            out.println("<style> table, th, td { border: 1px solid black;}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet factorial at " + request.getContextPath() + "</h1>");
            out.println(getTable());
            out.println("</body>");
            out.println("</html>");
        }
    }
    public String getTable(){
        
        //Generates factorial table in html
        String output = "<table> <tr><th>Number</th><th>Factorial</th></tr>";
        String tr = "<tr><td>";
        String midRow = "</td><td>";
        String endTr = "</td></tr>";
        for (int i = 0; i<=10; i++){
            int currentFactorial = i;
            for (int j = 1; j < i; j++){
                currentFactorial = currentFactorial * j;
            }
            output+= tr + i + midRow + currentFactorial +  endTr;
        }
        output += "</table>";
        
        return output;
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
