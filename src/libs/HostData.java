/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author trabajo
 */
public class HostData {

    private String driver;
    private String host;
    private String name;
    private String password;

    public HostData() {
        //leer json 
        JsonParser parser = new JsonParser();

        try {
            //Object obj = parser.parse(new FileReader("C:\\Users\\trabajo\\Documents\\NetBeansProjects\\NestleAD\\src\\config\\DataDB.json"));
            Object obj = parser.parse(new FileReader("DataDB.json"));
            JsonObject jsonObject = (JsonObject) obj;
            driver = jsonObject.get("driver").getAsString();
            host = jsonObject.get("host").getAsString();
            name = jsonObject.get("name").getAsString();
            password = jsonObject.get("password").getAsString();
            
            setDriver(driver);
            setHost(host);
            setName(name);
            setPassword(password);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public String getDriver() {
        return driver;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    private void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
