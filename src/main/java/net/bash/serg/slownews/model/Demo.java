package net.bash.serg.slownews.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(News.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();

        URL xmlURL = new URL("https://news.mail.ru/rss/ukraine/");
        InputStream xml = xmlURL.openStream();
        News news = (News) unmarshaller.unmarshal(xml);
        System.out.println(news.getCategory());
        xml.close();

       /* File xml = new File("src/main/resources/input.xml");
        net.bash.serg.slownews.model.News news = (net.bash.serg.slownews.model.News) unmarshaller.unmarshal(xml);
        System.out.println(news.getCategory());
        */
     }

}