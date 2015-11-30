package net.bash.serg.slownews.servlet;
import net.bash.serg.slownews.model.WeatherClientParser;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

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

        try {
            JAXBContext context = JAXBContextFactory.createContext(new Class[]{net.bash.serg.slownews.model.News.class}, null);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL xmlURL = new URL("https://news.mail.ru/rss/ukraine/");
            InputStream xml = xmlURL.openStream();
            net.bash.serg.slownews.model.News news = (net.bash.serg.slownews.model.News) unmarshaller.unmarshal(xml);
            ArrayList <String> al = news.getCategory();

            session.setAttribute("category0", al.get(0));
            session.setAttribute("category1", al.get(1));
            session.setAttribute("category2", al.get(2));
            session.setAttribute("title", news.getTitle());
            session.setAttribute("link", news.getLink());
            xml.close();
        }
        catch(JAXBException e){
             System.out.println(e.getMessage());
        }
      //  WeatherClientParser client = new WeatherClientParser();
       // session.setAttribute("news", client.getResult());
        dispatcher.forward(req, res);
    }
}