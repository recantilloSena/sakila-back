<%-- 
    Document   : index
    Created on : 15/11/2022, 07:47:45 PM
    Author     : RICARDO
--%>

<%@page import="com.sena.app.controller.Controlador"%>
<%@page import="com.sena.app.modelo.Actor"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
         Controlador controlador = new Controlador();
          
             List<Actor> listaActores = controlador.findByIdActor(9);
             
             for (Actor item : listaActores){
                 %>
                 <br> <%=item.getFirstName() %>  <%=item.getLastName() %>
                 <%
             }
             
              
         
        
        
        %>
        
    </body>
</html>
