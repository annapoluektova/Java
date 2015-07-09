<%-- 
    Document   : logout
    Created on : Oct 4, 2014, 12:04:46 PM
    Author     : nisaenko
--%>
<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>