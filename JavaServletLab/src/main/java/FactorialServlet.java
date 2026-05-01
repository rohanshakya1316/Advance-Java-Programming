import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int n = Integer.parseInt(request.getParameter("num"));
        int fact = 1;

        for(int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        out.println("<html><body>");
        out.println("<h2>Factorial of " + n + " is " + fact + "</h2>");
        out.println("</body></html>");
    }
}
