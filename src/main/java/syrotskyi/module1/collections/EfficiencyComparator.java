package syrotskyi.module1.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class EfficiencyComparator {
    public static final int TEN_THOUSAND_DATA_VOLUME = 10_000;

    public static void addCollectionToCompare(ArrayList<Collection> collections) {
        compare(collections);
    }

    private static void compare(ArrayList<Collection> collections) {
        for (Collection collection : collections) {
            Measurer measurer = new MeasurerFactoryImpl().makeMeasurer(collection);
            Map<String, String> measureResults = measurer.getResults(TEN_THOUSAND_DATA_VOLUME);
            OutputUtil.printAndSaveResults(measurer.getCollectionType(), measureResults);
        }

    }
}
