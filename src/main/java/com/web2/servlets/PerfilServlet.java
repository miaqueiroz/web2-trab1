package com.web2.servlets;

import com.web2.dao.UsuarioDAO;
import com.web2.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/usuario")
public class PerfilServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        
        Usuario usuario = new Usuario();
        
        usuario.setNome(request.getParameter("c_nome"));
        usuario.setEmail(request.getParameter("c_email"));
        usuario.setSenha(request.getParameter("c_senha"));

        UsuarioDAO usuarioDao = new UsuarioDAO();

        try {
            usuarioDao.criar(usuario);
            HttpSession session = request.getSession();
            session.setAttribute("nome", usuario.getNome());
            response.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
        }  

    }  
}
