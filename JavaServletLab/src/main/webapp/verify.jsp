<%
String u = request.getParameter("uname");
String p = request.getParameter("pass");

if(u.equals("Nikesh") && p.equals("12345")) {
%>
    <h2>Welcome <%= u %>! Login Successful.</h2>
<%
} else {
    response.sendRedirect("register.html");
}
%>
