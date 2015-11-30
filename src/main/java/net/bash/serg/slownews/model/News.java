package net.bash.serg.slownews.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name="rss")
@XmlType(propOrder={"title", "link", "category"})
@XmlAccessorType(XmlAccessType.FIELD)
public class News {

     @XmlPath("channel/item/category/text()")
     private ArrayList<String> category;

     @XmlPath("channel/title/text()")
     private String title;

     @XmlPath("channel/link/text()")
     private String link;

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getLink() {
          return link;
     }

     public void setLink(String link) {
          this.link = link;
     }

     public ArrayList<String> getCategory() {
          return category;
     }

     public void setCategory(ArrayList<String> category) {
          this.category = category;
     }
}