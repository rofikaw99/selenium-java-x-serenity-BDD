package starter.utlis.onerecord;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class XFWBXml {

    public static String xmlPayload;

    static {
        try {
            xmlPayload = new String(Files.readAllBytes(new File("src/test/java/starter/utlis/onerecord/XWFBXml.xml").toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
