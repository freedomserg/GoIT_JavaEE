package syrotskyi.module1.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class EfficiencyComparator {
    public static final int TEN_THOUSAND_DATA_VOLUME = 10_000;
    public static final int ONE_HUNDRED_THOUSAND_DATA_VOLUME = 100_000;
    public static final int ONE_MILLION_DATA_VOLUME = 1_000_000;

    public static void addCollectionToCompare(ArrayList<Collection> collections) {
        compare(collections);
    }

    private static void compare(ArrayList<Collection> collections) {
        measureForTenThousandVolume(collections);
        measureForHundredThousandVolume(collections);
        measureForOneMillionVolume(collections);
    }

    private static void measureForTenThousandVolume(ArrayList<Collection> collections) {
        for (Collection collection : collections) {
            Measurer measurer = new MeasurerFactoryImpl().makeMeasurer(collection);
            Map<String, String> measureResults = measurer.getResults(TEN_THOUSAND_DATA_VOLUME);
            OutputUtil.printAndSaveResults(measurer.getCollectionType(), measureResults);
        }
    }

    private static void measureForHundredThousandVolume(ArrayList<Collection> collections) {
        for (Collection collection : collections) {
            Measurer measurer = new MeasurerFactoryImpl().makeMeasurer(collection);
            Map<String, String> measureResults = measurer.getResults(ONE_HUNDRED_THOUSAND_DATA_VOLUME);
            OutputUtil.printAndSaveResults(measurer.getCollectionType(), measureResults);
        }
    }

    private static void measureForOneMillionVolume(ArrayList<Collection> collections) {
        for (Collection collection : collections) {
            Measurer measurer = new MeasurerFactoryImpl().makeMeasurer(collection);
            Map<String, String> measureResults = measurer.getResults(ONE_MILLION_DATA_VOLUME);
            OutputUtil.printAndSaveResults(measurer.getCollectionType(), measureResults);
        }
    }
}
