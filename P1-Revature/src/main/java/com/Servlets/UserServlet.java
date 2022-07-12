package com.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {


    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); <== Will run "HttpServlet" method

        //Integer userId = Integer.parseInt(req.getParameter("user-id-input"));


        //Users myUser = userDAO.read(userId);


        //resp.getWriter().println(myUser.getEmail());
        //System.out.println(resp.getStatus() + ": Here we are printing out the response code.");
        String email = String.valueOf(req.getParameter("email-sign-in"));
        String password = String.valueOf(req.getParameter("password-sign-in"));

        CurrentUser.currentUser = userDAO.loginUser(email, password);

        //HERE i am redirecting the client to the welcome.html page
        req.getRequestDispatcher("welcome.html").forward(req, resp);

    }











    }
