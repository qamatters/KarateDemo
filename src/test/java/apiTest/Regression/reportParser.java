package apiTest.Regression;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class reportParser {
    public static void parseReport(String folderPath) throws IOException {
        Document htmlFile = null;
        try {
             String url = folderPath + "/cucumber-html-reports/" + "overview-features.html";
            // need http protocol
            htmlFile = Jsoup.parse(new File(url), "ISO-8859-1");
            Elements totalScenariosInReport = htmlFile.select("#tablesorter > tfoot > tr:nth-child(1) > td:nth-child(10)");
            String totalScenarios = totalScenariosInReport.text();

            Elements totalPassScenariosInReport = htmlFile.select("#tablesorter > tfoot > tr:nth-child(1) > td:nth-child(8)");
            String totalPassScenarios = totalPassScenariosInReport.text();

            Elements totalFailScenariosInReport = htmlFile.select("#tablesorter > tfoot > tr:nth-child(1) > td:nth-child(9)");
            String totalFailScenarios = totalFailScenariosInReport.text();

            System.out.println("Total Scenarios :" +totalScenarios );
            System.out.println("Total Pass Scenarios :" +totalPassScenarios );
            System.out.println("Total Fail Scenarios :" +totalFailScenarios );

            File summaryFile = new File("Summary.txt");
            if(summaryFile.exists()) {
                System.out.println("File exist, deleting it" );
             summaryFile.delete();
             new File("Summary.txt");
            }
            FileWriter writer = new FileWriter(summaryFile);
            writer.write(totalScenarios);
            writer.write(totalPassScenarios);
            writer.write(totalFailScenarios);
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
