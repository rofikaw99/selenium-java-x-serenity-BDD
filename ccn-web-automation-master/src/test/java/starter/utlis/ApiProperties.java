package starter.utlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiProperties {

    public static Properties load(){
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("api.properties")) {
            // load a properties file
            prop.load(input);

            // get the property value and print it out

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static String internalUrl(){
        return load().getProperty("internal_url");
    }

    public static String apiKey(){
        return load().getProperty("api_key");
    }
    public static String serviceId(){
        return load().getProperty("service_id");
    }
    public static String clientIdOneRecord(){
        return load().getProperty("client_id_one_record");
    }
    public static String clientSecretOneRecord(){
        return load().getProperty("client_secret_one_record");
    }
    public static String baseUrl(){
        return load().getProperty("base_url");
    }

}