import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/factorial")
public class FactorialBoxServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("num");
        String result = "";

        if(n != null) {
            int num = Integer.parseInt(n);
            int fact = 1;
            for(int i = 1; i <= num; i++)
                fact *= i;
            result = String.valueOf(fact);
        }

        out.println("<html><body>");
        out.println("<form method='post'>");
        out.println("Number: <input type='text' name='num' value='" +
                (n==null?"":n) + "'><br><br>");
        out.println("Factorial: <input type='text' value='" +
                result + "'><br><br>");
        out.println("<input type='submit' value='Calculate'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
