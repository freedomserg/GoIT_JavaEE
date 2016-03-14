package syrotskyi.module1.collections;

import java.io.IOException;
import java.util.*;

public class EfficiencyComparator {
    public static final int TEN_THOUSAND_DATA_VOLUME = 10_000;
    public static final int ONE_HUNDRED_THOUSAND_DATA_VOLUME = 100_000;
    public static final int ONE_MILLION_DATA_VOLUME = 1_000_000;

    public void addCollectionToCompare(ArrayList<Collection> collections) throws IOException {
        compare(collections);
    }

    private void compare(ArrayList<Collection> collections)throws IOException {
        measureForTenThousandVolume(collections);
        measureForHundredThousandVolume(collections);
        measureForOneMillionVolume(collections);
    }

    private void measureForTenThousandVolume(ArrayList<Collection> collections) throws IOException {
        OutputUtil.printHeader(TEN_THOUSAND_DATA_VOLUME);
        for (Collection collection : collections) {
            Measurer measurer = new MeasurerFactoryImpl().makeMeasurer(collection);
            TreeMap<String, String> measureResults = measurer.getResults(TEN_THOUSAND_DATA_VOLUME);
            OutputUtil.printAndSaveResults(measurer.getCollectionType(), measureResults);
        }
    }

    private void measureForHundredThousandVolume(ArrayList<Collection> collections) throws IOException {
        OutputUtil.printHeader(ONE_HUNDRED_THOUSAND_DATA_VOLUME);
        for (Collection collection : collections) {
            Measurer measurer = new MeasurerFactoryImpl().makeMeasurer(collection);
            TreeMap<String, String> measureResults = measurer.getResults(ONE_HUNDRED_THOUSAND_DATA_VOLUME);
            OutputUtil.printAndSaveResults(measurer.getCollectionType(), measureResults);
        }
    }

    private void measureForOneMillionVolume(ArrayList<Collection> collections) throws IOException {
        OutputUtil.printHeader(ONE_MILLION_DATA_VOLUME);
        for (Collection collection : collections) {
            Measurer measurer = new MeasurerFactoryImpl().makeMeasurer(collection);
            TreeMap<String, String> measureResults = measurer.getResults(ONE_MILLION_DATA_VOLUME);
            OutputUtil.printAndSaveResults(measurer.getCollectionType(), measureResults);
        }
    }
}
