package helper;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.security.PublicKey;

public class Utility {

    public static File getJsonSchemaFile (String JsonFile){
        return new File("src/test/java/helper/JsonSchemaData/"+JsonFile);
    }

    public static String generateRandomEmail(){
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email= "";
        String temp = RandomStringUtils.randomAlphanumeric(10); //panjang email 10 karakter
        email = temp + "@testdata.com"; // ini kayanya untuk domainnya
        return email;
    }
}
