package apiTest;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static apiTest.Regression.reportParser.parseReport;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Deepak
 */
@CucumberOptions(features = {"classpath:apiTest//Regression" },
        tags = {"@Regression"}) // important: do not use @RunWith(Karate.class) !

        public class CucumberReport {

    @Test
    void testParallel() throws IOException {
        // if in windows, change // to \\
        String karateOutputPath = "target/karate-reports";
        Results results = Runner.path("classpath:apiTest//Regression")
                .tags("@Smoke")
                .outputCucumberJson(true)
                .parallel(5);
        generateReport(karateOutputPath);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    public static void generateReport(String karateOutputPath) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String currentDateTime = dtf.format(now);
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        String currentDir = System.getProperty("user.dir");
        // if in windows, change // to \\
        String folderPath= currentDir + "/Reports/" + "TestCaseExecution_" +currentDateTime;
        File file = new File (folderPath);
        file.mkdirs();
        Configuration config = new Configuration( file, "Cucumber_Reports");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
        System.out.println("Generating summary" );
        parseReport(folderPath);

    }

}
