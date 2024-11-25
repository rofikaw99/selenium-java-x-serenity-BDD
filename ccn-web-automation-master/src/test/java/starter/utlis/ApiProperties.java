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
    public static String sourceServiceId(){
        return load().getProperty("source-service-id");
    }
    public static String paymentServiceId(){
        return load().getProperty("payment-service_id");
    }
    public static String companyServiceId(){
        return load().getProperty("company-service-id");
    }
    public static String associateServiceId(String product){
        return load().getProperty("associate-service-id-" + product);
    }
    public static String supplierId(String product){
        return load().getProperty("supplier-id-" + product);
    }
    public static String associateServiceIdSvs(){
        return load().getProperty("associate-service-id-svs");
    }
    public static String emailCompany1(){
        return load().getProperty("email-company-1");
    }
    public static String emailCompany2(){
        return load().getProperty("email-company-2");
    }
    public static String emailCompany3(){
        return load().getProperty("email-company-3");
    }
    public static String companyName1(){
        return load().getProperty("company-name-1");
    }
    public static String companyName2(){
        return load().getProperty("company-name-2");
    }
    public static String companyName3(){
        return load().getProperty("company-name-3");
    }
    public static String productName(String product){
        return load().getProperty("product-" + product.toLowerCase());
    }
    public static String cubeId1(){
        return load().getProperty("cube-id-1");
    }
    public static String cubeId2(){
        return load().getProperty("cube-id-2");
    }
    public static String cubeId3(){
        return load().getProperty("cube-id-3");
    }
    public static String baseUrlExternal(){
        return load().getProperty("base-url-external");
    }
    public static String baseUrlPayment(){
        return load().getProperty("base-url-payment");
    }
}