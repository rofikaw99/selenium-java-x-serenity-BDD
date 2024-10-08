package starter.utlis;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadFile {

    private static final String basePath = "src/test/java/starter/utlis/";

    public static String tokenCompany1() throws IOException {
        return FileUtils.readFileToString(new File(basePath + "payment/tokenCompany1.json"), StandardCharsets.UTF_8);
    }

    public static String tokenCompany2() throws IOException {
        return FileUtils.readFileToString(new File(basePath + "payment/tokenCompany2.json"), StandardCharsets.UTF_8);
    }
}
