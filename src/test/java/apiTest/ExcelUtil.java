package apiTest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ExcelUtil {

    public static void byteArrayToExcel (byte[] ResponseBytes) {

        System.out.println("Excel file generating");
        try {
            FileUtils.writeByteArrayToFile(new File("src/test/java/TestData/Actual_response.xlsx"), ResponseBytes);
            System.out.println("Excel file generated");
        } catch (IOException e) {
            System.out.println("Excel file generation failed");
            e.printStackTrace();
        }

    }
}
