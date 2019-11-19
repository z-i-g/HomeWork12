<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="TestEJB.IMyEjb" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.naming.NamingException" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Directories and files:</h2>

<%
    InitialContext context = new InitialContext();
    IMyEjb ejb = null;
    try {
        ejb = (IMyEjb) context.lookup("java:app/innopolis/MyEjb!TestEJB.IMyEjb");
    } catch (NamingException e) {
        e.printStackTrace();
    }
    List<String> list = ejb.readFileDirectory();

    for (String path : list) {
        out.print(path);
%><br>
<%
    };
%>

</body>
</html>
