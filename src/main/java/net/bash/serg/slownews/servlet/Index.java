package net.bash.serg.slownews.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by bso05702 on 18.11.2015.
 */
@WebServlet("/")
public class Index extends HttpServlet {
    private static final String BEGIN = "/index.jsp";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getRealPath(File.separator);
        System.out.println(contextPath);
        RequestDispatcher dispatcher = application.getRequestDispatcher(BEGIN);
        dispatcher.forward(req, res);
    }
}