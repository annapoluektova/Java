<%-- 
    Document   : registration
    Created on : Oct 4, 2014, 10:57:55 AM
    Author     : nisaenko
--%>

<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    Class.forName("org.hsqldb.jdbc.JDBCDriver");
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:D:/Users/nisaenko/db/estore",
            "SA", "");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into members(first_name, last_name, email, uname, pass) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "')");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>
