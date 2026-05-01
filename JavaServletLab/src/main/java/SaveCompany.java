import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/SaveCompany")
public class SaveCompany extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String cname = request.getParameter("cname");
        String city = request.getParameter("city");
        String edate = request.getParameter("edate");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shop","root","");

            PreparedStatement ps =
                    con.prepareStatement("insert into company values(?,?,?)");
            ps.setString(1, cname);
            ps.setString(2, city);
            ps.setString(3, edate);

            ps.executeUpdate();
            out.println("<h2>Record Saved Successfully</h2>");

            con.close();
        } catch(Exception e) {
            out.println(e);
        }
    }
}
