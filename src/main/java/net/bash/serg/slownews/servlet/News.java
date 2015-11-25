package net.bash.serg.slownews.servlet;



import net.bash.serg.slownews.model.WeatherClientParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bso05702 on 18.11.2015.
 */
@WebServlet("/news")
public class News extends HttpServlet{
    private static final String BEGIN = "/WEB-INF/view/news.jsp";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        RequestDispatcher dispatcher = application.getRequestDispatcher(BEGIN);
        HttpSession session = req.getSession();
        WeatherClientParser client = new WeatherClientParser();
        session.setAttribute("news",  client.getResult());
        dispatcher.forward(req, res);
    }
}
