package net.bash.serg.slownews.model;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by basoy on 11/23/15.
 */

public class WeatherClient {
    private String result;
   public WeatherClient(){
           try {

               Client client =  Client.create();

               WebResource webResource = client
                       .resource("http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0");

               ClientResponse response = webResource.accept("application/json")
                       .get(ClientResponse.class);

               if (response.getStatus() != 200) {
                   throw new RuntimeException("Failed : HTTP error code : "
                           + response.getStatus());
               }

               String output = response.getEntity(String.class);

               setResult(output);

           } catch (Exception e) {

               e.printStackTrace();

           }
       }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}