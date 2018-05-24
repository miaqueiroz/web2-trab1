<%-- 
    Document   : cadastroProfessor
    Created on : 10/04/2018, 19:48:14
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilos/style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="topnav">
            <a class="active" href="ProfessorServlet">Cadastrar Professor</a>
            <a href="OrientacaoServlet">Cadastrar Orientação</a>
            <a href="ListarServlet">Listar </a>
            <a href="LogoutServlet">Sair</a>
        </div>
        
        <h1>Bem Vindo a Tela de Cadastro de Professores!</h1>
        
        <form method="POST" name="Professor">
            <label>Nome do Professor: </label><input required type="text" name="nomeProfessor">
            <button type="submite" value="Cadastrar">Cadastrar</button>
        </form>
        
        <div><h4>${msgSucesso}</h4></div>
    </body>
</html>
