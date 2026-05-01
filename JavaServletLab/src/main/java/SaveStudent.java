import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/SaveStudent")
public class SaveStudent extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int roll = Integer.parseInt(request.getParameter("roll"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String level = request.getParameter("level");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_management","root","");

            PreparedStatement ps =
                    con.prepareStatement("insert into student values(?,?,?,?)");
            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, level);

            ps.executeUpdate();
            out.println("<h2>Student Record Saved Successfully</h2>");

            con.close();
        } catch(Exception e) {
            out.println(e);
        }
    }
}
