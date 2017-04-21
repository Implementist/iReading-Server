/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Implementist.iReading;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Http 请求分派器<br>
 * 通过判断请求参数RequestType的值，将请求分派给具体的Servlet
 *
 * @author Implementist
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RequestType = request.getParameter("RequestType");
        switch (RequestType) {
            case "Login":
                RequestDispatcher dispatchToLogin = request.getRequestDispatcher("LoginServlet");
                dispatchToLogin.forward(request, response);
                break;

            case "Register":
                RequestDispatcher dispatchToRegister = request.getRequestDispatcher("RegisterServlet");
                dispatchToRegister.forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
