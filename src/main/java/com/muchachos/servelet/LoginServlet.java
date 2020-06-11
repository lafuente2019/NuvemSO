package com.muchachos.servelet;

import com.muchachos.dao.FuncionarioDao;
import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 22/05/2020
 *
 * @author Diego
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private Funcionario funcionario = new Funcionario();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Logar")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            try {
                funcionario = funcionarioDao.validar(email, senha);
                if (funcionario.getEmail() != null && funcionario.getSenha() != null) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/start.jsp");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (ClassNotFoundException | SQLException e) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
