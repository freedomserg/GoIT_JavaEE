package syrotskyi.module1.collections;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public abstract class Measurer {
    protected Random numberGenerator;
    protected long startOfMeasurement;
    protected long endOfMeasurement;
    protected long durationOfMeasurement;
    protected double totalDurationOfMeasurements;
    protected static Map<String, String> measurementResults = new TreeMap<>();
    public final int QUANTITY_OF_REPETITIONS = 100;

    static {
        measurementResults.put("add", null);
        measurementResults.put("get", null);
        measurementResults.put("remove", null);
        measurementResults.put("contains", null);
        measurementResults.put("populate", null);
        measurementResults.put("iterator.add", null);
        measurementResults.put("iterator.remove", null);
    }

    public abstract Map<String, String> getResults(int inputDataVolume);

    public abstract String getCollectionType();

    public abstract double measureContainsOperationEfficiency();

    public abstract double measurePopulateOperationEfficiency(int inputDataVolume);
}
