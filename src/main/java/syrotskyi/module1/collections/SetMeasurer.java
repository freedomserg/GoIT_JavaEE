package syrotskyi.module1.collections;

import java.util.*;

public class SetMeasurer extends Measurer implements SetOperationsMeasureAble {
    private Set<Integer> set;
    private Iterator<Integer> iterator;

    public SetMeasurer(Set<Integer> set) {
        this.set = set;
    }

    @Override
    public String getCollectionType() {
        return set.getClass().getSimpleName();
    }

    @Override
    public TreeMap<String, String> getResults(int inputCollectionDataVolume) {
        this.inputCollectionDataVolume = inputCollectionDataVolume;
        fillInputCollection();
        fillResultingMap();
        return measurementResults;
    }

    @Override
    public void fillInputCollection() {
        for (int i = 0; i < inputCollectionDataVolume; i++) {
            int value = getIntegerNumber();
            set.add(value);
        }
    }

    @Override
    public void fillResultingMap() {
        measurementResults.put("add", String.valueOf(measureAddByValueOperationEfficiency()));
        measurementResults.put("remove", String.valueOf(measureRemoveByValueOperationEfficiency()));
        measurementResults.put("contains", String.valueOf(measureContainsOperationEfficiency(set)));
        measurementResults.put("populate", String.valueOf(measurePopulateOperationEfficiency(set)));
    }

    @Override
    public double measureAddByValueOperationEfficiency() {
        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int value = getIntegerNumber();
            startOfMeasurement = System.currentTimeMillis();
            set.add(value);
            endOfMeasurement = System.currentTimeMillis();
            updateTotalDuration();
        }
        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measureRemoveByValueOperationEfficiency() {
        totalDurationOfMeasurements = 0;
        sizeOfUniformSegmentOfCollection = getSizeOfUniformSegmentOfCollection();
        iterator = set.iterator();

        List<Integer> numbersForRemoving = selectNumbersForRemoving();

        for (Integer nextNumberForRemoving : numbersForRemoving) {
            startOfMeasurement = System.currentTimeMillis();
            set.remove(nextNumberForRemoving);
            endOfMeasurement = System.currentTimeMillis();
            updateTotalDuration();
        }
        return totalDurationOfMeasurements / numbersForRemoving.size();
    }

    private List<Integer> selectNumbersForRemoving() {
        List<Integer> numbersForRemoving = new ArrayList<>(QUANTITY_OF_REPETITIONS);
        iterator = set.iterator();
        iterationsCounter = 0;

        while (iterator.hasNext()) {
            int currentValue = iterator.next();
            iterationsCounter++;

            if (reachNextUniformSegment()) {
                numbersForRemoving.add(currentValue);
            }

        }
        return numbersForRemoving;
    }

    @Override
    public int getSizeOfUniformSegmentOfCollection() {
        return set.size() / QUANTITY_OF_REPETITIONS;
    }
}
