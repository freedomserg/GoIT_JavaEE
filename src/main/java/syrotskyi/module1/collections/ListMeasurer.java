package syrotskyi.module1.collections;

import java.util.*;

public class ListMeasurer extends Measurer implements ListOperationsMeasureAble {
    private List<Integer> list;
    private ListIterator<Integer> iterator;

    public ListMeasurer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String getCollectionType() {
        return list.getClass().getSimpleName();
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
            list.add(value);
        }
    }

    @Override
    public void fillResultingMap() {
        measurementResults.put("add", String.valueOf(measureAddByIndexOperationEfficiency()));
        measurementResults.put("get", String.valueOf(measureGetByIndexOperationEfficiency()));
        measurementResults.put("remove", String.valueOf(measureRemoveByIndexOperationEfficiency()));
        measurementResults.put("contains", String.valueOf(measureContainsOperationEfficiency(list)));
        measurementResults.put("populate", String.valueOf(measurePopulateOperationEfficiency(list)));
        measurementResults.put("iterator.add", String.valueOf(measureIteratorAddOperationEfficiency()));
        measurementResults.put("iterator.remove", String.valueOf(measureIteratorRemoveOperationEfficiency()));
    }

    @Override
    public double measureAddByIndexOperationEfficiency() {
        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int index = getIndex();
            int value = getIntegerNumber();
            startOfMeasurement = System.currentTimeMillis();
            list.add(index, value);
            endOfMeasurement = System.currentTimeMillis();
            updateTotalDuration();
        }
        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    private int getIndex() {
        return (int)(Math.random() * list.size());
    }

    @Override
    public double measureGetByIndexOperationEfficiency() {
        totalDurationOfMeasurements = 0;
        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int index = getIndex();
            startOfMeasurement = System.currentTimeMillis();
            list.get(index);
            endOfMeasurement = System.currentTimeMillis();
            updateTotalDuration();
        }
        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measureRemoveByIndexOperationEfficiency() {
        totalDurationOfMeasurements = 0;
        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int index = getIndex();
            startOfMeasurement = System.currentTimeMillis();
            list.remove(index);
            endOfMeasurement = System.currentTimeMillis();
            updateTotalDuration();
        }
        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measureIteratorAddOperationEfficiency() {
        totalDurationOfMeasurements = 0;
        fillInputCollection(); //fill input collection because it have been cleared by measurePopulateOperationEfficiency() method
        sizeOfUniformSegmentOfCollection = getSizeOfUniformSegmentOfCollection();
        iterator = list.listIterator();
        iterationsCounter = 0;
        updateCollectionCounter = 0;

        while (iterator.hasNext()) {
            int currentValue = iterator.next();
            iterationsCounter++;
            if (reachNextUniformSegment()) {
                int insertedValue = getIntegerNumber();
                startOfMeasurement = System.currentTimeMillis();
                iterator.add(insertedValue);
                endOfMeasurement = System.currentTimeMillis();
                updateTotalDuration();
                updateCollectionCounter++;
            }

            if (updateCollectionCounter == QUANTITY_OF_REPETITIONS) {
                break;
            }
        }
        return totalDurationOfMeasurements / updateCollectionCounter;
    }

    @Override
    public int getSizeOfUniformSegmentOfCollection() {
        return list.size() / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measureIteratorRemoveOperationEfficiency() {
        totalDurationOfMeasurements = 0;
        sizeOfUniformSegmentOfCollection = getSizeOfUniformSegmentOfCollection();
        iterator = list.listIterator();
        iterationsCounter = 0;
        updateCollectionCounter = 0;

        while (iterator.hasNext()) {
            int currentValue = iterator.next();
            iterationsCounter++;

            if (reachNextUniformSegment()) {
                startOfMeasurement = System.currentTimeMillis();
                iterator.remove();
                endOfMeasurement = System.currentTimeMillis();
                updateTotalDuration();
                updateCollectionCounter++;
            }

            if (updateCollectionCounter == QUANTITY_OF_REPETITIONS) {
                break;
            }
        }
        return totalDurationOfMeasurements / updateCollectionCounter;
    }
}