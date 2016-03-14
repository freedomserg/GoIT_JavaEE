package syrotskyi.module1.collections;

import java.util.Collection;
import java.util.Random;
import java.util.TreeMap;

public abstract class Measurer {
    protected int inputCollectionDataVolume;
    protected Random numberGenerator = new Random();
    protected long startOfMeasurement;
    protected long endOfMeasurement;
    protected long durationOfMeasurement;
    protected double totalDurationOfMeasurements;
    protected int sizeOfUniformSegmentOfCollection;
    protected int iterationsCounter;
    protected int updateCollectionCounter;
    protected static TreeMap<String, String> measurementResults = new TreeMap<>();
    public final int QUANTITY_OF_REPETITIONS = 100;

    {
        measurementResults.put("add", null);
        measurementResults.put("get", null);
        measurementResults.put("remove", null);
        measurementResults.put("contains", null);
        measurementResults.put("populate", null);
        measurementResults.put("iterator.add", null);
        measurementResults.put("iterator.remove", null);
    }

    public abstract TreeMap<String, String> getResults(int inputCollectionDataVolume);

    public abstract void fillInputCollection();

    public abstract void fillResultingMap();

    public int getIntegerNumber() {
        return numberGenerator.nextInt();
    }

    public abstract String getCollectionType();

    public void updateTotalDuration() {
        durationOfMeasurement = endOfMeasurement - startOfMeasurement;
        totalDurationOfMeasurements += durationOfMeasurement;
    }

    public double measureContainsOperationEfficiency(Collection collection) {
        totalDurationOfMeasurements = 0;
        boolean isContainedValue = false;
        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int value = getIntegerNumber();
            startOfMeasurement = System.currentTimeMillis();
            isContainedValue = collection.contains(value);
            endOfMeasurement = System.currentTimeMillis();
            updateTotalDuration();
        }
        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    public double measurePopulateOperationEfficiency(Collection collection) {
        totalDurationOfMeasurements = 0;
        collection.clear();
        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            startOfMeasurement = System.currentTimeMillis();
            for (int j = 0; j < inputCollectionDataVolume; j++) {
                int value = getIntegerNumber();
                collection.add(value);
            }
            endOfMeasurement = System.currentTimeMillis();
            updateTotalDuration();
            collection.clear();
        }
        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    public abstract int getSizeOfUniformSegmentOfCollection();

    public boolean reachNextUniformSegment() {
        return iterationsCounter % sizeOfUniformSegmentOfCollection == 0;
    }
}