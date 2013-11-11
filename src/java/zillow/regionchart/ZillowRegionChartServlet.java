/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zillow.regionchart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import org.netbeans.saas.RestResponse;
import org.netbeans.saas.zillow.ZillowRealEstateService;

/**
 *
 * @author 1
 */
@WebServlet(name = "ZillowRegionChartServlet", urlPatterns = {"/ZillowRegionChartServlet"})
public class ZillowRegionChartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {


            try {
                String unittype = "dollar";
                String city = null;
                String state = null;
                String zIP = null;
                String width = null;
                String height = null;
                String chartduration = null;

                RestResponse result = ZillowRealEstateService.getRegionChart(unittype, city, state, zIP, width, height, chartduration);
                if (result.getDataAsObject(zillow.realestateservice.regionchart.Regionchart.class) instanceof zillow.realestateservice.regionchart.Regionchart) {
                    zillow.realestateservice.regionchart.Regionchart resultObj = result.getDataAsObject(zillow.realestateservice.regionchart.Regionchart.class);
                out.println("<img src=\"" + resultObj.getResponse().getUrl() + "\" />");
                }
                //TODO - Uncomment the print Statement below to print result.
                
            } catch (JAXBException ex) {
                Logger.getLogger(ZillowRegionChartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ZillowRegionChartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ZillowRegionChartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
         

   

