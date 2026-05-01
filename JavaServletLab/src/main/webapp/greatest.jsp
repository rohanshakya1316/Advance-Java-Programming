<html>
<body>

<form method="post">
    Number 1: <input type="text" name="n1"><br><br>
    Number 2: <input type="text" name="n2"><br><br>
    Number 3: <input type="text" name="n3"><br><br>
    <input type="submit" value="Find Greatest">
</form>

<%
if(request.getParameter("n1") != null) {
    int a = Integer.parseInt(request.getParameter("n1"));
    int b = Integer.parseInt(request.getParameter("n2"));
    int c = Integer.parseInt(request.getParameter("n3"));

    int max = a;
    if(b > max) max = b;
    if(c > max) max = c;
%>
    <h3>Greatest Number: <%= max %></h3>
<%
}
%>

</body>
</html>
