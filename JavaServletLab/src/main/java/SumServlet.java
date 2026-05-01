import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int a = Integer.parseInt(request.getParameter("n1"));
        int b = Integer.parseInt(request.getParameter("n2"));
        int c = Integer.parseInt(request.getParameter("n3"));

        int max = a;
        if(b > max) max = b;
        if(c > max) max = c;

        int sum = 0;
        for(int i = 1; i <= max; i++) {
            sum = sum + i;
        }

        out.println("<html><body>");
        out.println("<h2>Greatest Number = " + max + "</h2>");
        out.println("<h2>Sum of Natural Numbers up to " + max + " = " + sum + "</h2>");
        out.println("</body></html>");
    }
}
