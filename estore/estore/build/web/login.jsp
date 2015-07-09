<%-- 
    Document   : login
    Created on : Oct 4, 2014, 11:55:37 AM
    Author     : nisaenko
--%>

<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    Class.forName("org.hsqldb.jdbc.JDBCDriver");
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:D:/Users/nisaenko/db/estore",
            "SA", "");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from members where uname='" + userid + "' and pass='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("categories.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>
