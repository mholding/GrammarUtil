

package grammarutils;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

/**
 * @author mason
 */
public class GrammarUtil {

    /**
     * Tests various grammar and other utility methods and outputs to the console
     */
    public static void main(String[] args) {
        testPlaceFormat();

        testHowLongAgo();

        testSetFields();
    }

    static void testPlaceFormat(){
        // output leader-board style string formatting for numerical place
        for (int i = 0; i < 25; i++) {
            System.out.println("\ninput of " + i + ":  " + Util.getPlace(i));
            System.out.println("input of " + (i + 100) + ":  " + Util.getPlace(i + 100));
        }

        System.out.println();
    }

    static void testHowLongAgo() {
        Date date = new Date();
        long millis = date.getTime();

        long pastMillis = new Date().getTime() - (1000l * 60l);
        Date pastDate = new Date(pastMillis);

        // 1 minute ago
        System.out.println(Util.howLongAgo(pastDate));

        pastMillis = millis - (1000l * 60l * 3);
        pastDate = new Date(pastMillis);

        // 3 minutes ago
        System.out.println(Util.howLongAgo(pastDate));

        pastMillis = millis - (Util.HOUR_MILLIS);
        pastDate = new Date(pastMillis);

        // 1 hour ago
        System.out.println(Util.howLongAgo(pastDate));

        pastMillis = millis - (Util.HOUR_MILLIS * 5);
        pastDate = new Date(pastMillis);

        // 5 hours ago
        System.out.println(Util.howLongAgo(pastDate));

        pastMillis = millis - (Util.DAY_MILLIS);
        pastDate = new Date(pastMillis);

        // 1 day ago
        System.out.println(Util.howLongAgo(pastDate));

        pastMillis = millis - (Util.DAY_MILLIS * 17);
        pastDate = new Date(pastMillis);

        // 17 days ago
        System.out.println(Util.howLongAgo(pastDate));
    }

    static void testSetFields() {

        Document doc = new Document();

        System.out.println("\nDocument with default fields: \n" + doc.toString());

        Map<String, Object> fieldSettings = new HashMap<>();
        Date date = new Date(System.currentTimeMillis() - 1000000000);

        fieldSettings.put("title", "The Catcher in the Rye");
        fieldSettings.put("description", "A great coming of age story");
        fieldSettings.put("keywords", "novel, JD Salinger");
        fieldSettings.put("created", date);
        fieldSettings.put("updated", date);
        fieldSettings.put("readOnly", new Boolean(false));
        fieldSettings.put("privacy", new PrivacyObject("public"));

        Util.setFields(doc, fieldSettings);

        System.out.println("Document with set fields: \n" + doc.toString());
    }

}
