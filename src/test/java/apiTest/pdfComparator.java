package apiTest;

import de.redsix.pdfcompare.PdfComparator;

import java.io.File;
import java.io.FileInputStream;

public class pdfComparator {

    public static boolean comparePDF (String compareType) throws Exception {
        FileInputStream expectedPDFResponse = null;
        FileInputStream actualPDFResponse = null;

        switch (compareType) {

            case constants.DataValidationInPDF:

                expectedPDFResponse = new FileInputStream(new File(constants.expectedPDFPath));
//              expectedPDFResponse = new FileInputStream(new File(constants.DirPath.concat(constants.DataValidationInPDF)));
                actualPDFResponse = new FileInputStream(new File(constants.actualPathForPdf));
                break;

            default:
                System.out.println("There is no file specified");

        }
        boolean difference = new PdfComparator(expectedPDFResponse, actualPDFResponse).compare().writeTo("diffpdfOutPut");

        if(!    difference){
            System.out.println("Both files are identical");
        } else
        {
            System.out.println(difference);
            difference = false;
        }
        return difference;
    }


}