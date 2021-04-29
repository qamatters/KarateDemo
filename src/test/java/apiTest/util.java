package apiTest;


import org.skyscreamer.jsonassert.JSONAssert;

public class util {

    public static boolean compareJsonsIrrespectiveOfOrder (String expectedJSON, String actualJSON) {
        boolean testResult = false;
            try {
                JSONAssert.assertEquals(expectedJSON, actualJSON, false);
                testResult = true;
            } catch (org.json.JSONException e) {
                e.printStackTrace( );
            }
        return testResult;
    }
}
