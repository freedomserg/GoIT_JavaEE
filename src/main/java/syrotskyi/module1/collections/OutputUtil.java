package syrotskyi.module1.collections;

import java.util.Map;

public class OutputUtil {
    public static void printAndSaveResults(String collectionType, Map<String, String> measureResults) {
        printToConsole(collectionType, measureResults);
    }

    private static void printToConsole(String collectionType, Map<String, String> measureResults) {
        System.out.print(collectionType + ": ");

        for (Map.Entry<String, String> entry : measureResults.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print("<" + key + ">" + " - " + value + " ");
        }

        System.out.println();
    }
}
