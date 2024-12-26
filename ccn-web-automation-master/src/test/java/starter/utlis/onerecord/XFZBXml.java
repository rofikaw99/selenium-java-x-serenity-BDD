package starter.utlis.onerecord;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class XFZBXml {

    public static String xmlPayload;

    static {
        try {
            xmlPayload = new String(Files.readAllBytes(new File("src/test/java/starter/utlis/XFZB.xml").toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
