package syrotskyi.module1.collections;

import java.util.*;

public class ListMeasurer extends Measurer implements ListOperationsMeasurer {
    private List<Integer> list;

    public ListMeasurer(List<Integer> list) {
        this.list = list;
        numberGenerator = new Random();
    }

    @Override
    public String getCollectionType() {
        return list.getClass().getSimpleName();
    }

    @Override
    public Map<String, String> getResults(int inputDataVolume) {
        fillInputCollection(inputDataVolume);

        measurementResults.put("add", String.valueOf(measureAddByIndexOperationEfficiency()));
        measurementResults.put("get", String.valueOf(measureGetByIndexOperationEfficiency()));
        measurementResults.put("remove", String.valueOf(measureRemoveByIndexOperationEfficiency()));
        measurementResults.put("contains", String.valueOf(measureContainsOperationEfficiency()));
        measurementResults.put("populate", String.valueOf(measurePopulateOperationEfficiency(inputDataVolume)));
        measurementResults.put("iterator.add", String.valueOf(measureIteratorAddOperationEfficiency(inputDataVolume)));

        return measurementResults;
    }

    private void fillInputCollection(int inputDataVolume) {
        for (int i = 0; i < inputDataVolume; i++) {
            int value = numberGenerator.nextInt();
            list.add(value);
        }
    }

    @Override
    public double measureAddByIndexOperationEfficiency() {
        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int index = (int)(Math.random() * list.size());
            int value = numberGenerator.nextInt();

            startOfMeasurement = System.currentTimeMillis();
            list.add(index, value);
            endOfMeasurement = System.currentTimeMillis();

            updateTotalDuration();
        }

        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measureGetByIndexOperationEfficiency() {
        totalDurationOfMeasurements = 0;

        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int index = numberGenerator.nextInt(list.size());

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
            int index = numberGenerator.nextInt(list.size());

            startOfMeasurement = System.currentTimeMillis();
            list.remove(index);
            endOfMeasurement = System.currentTimeMillis();

            updateTotalDuration();
        }

        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measureContainsOperationEfficiency() {
        totalDurationOfMeasurements = 0;
        boolean isContainedValue = false;

        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {
            int value = numberGenerator.nextInt();

            startOfMeasurement = System.currentTimeMillis();
            isContainedValue = list.contains(value);
            endOfMeasurement = System.currentTimeMillis();

            updateTotalDuration();
        }

        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measurePopulateOperationEfficiency(int inputDataVolume) {
        totalDurationOfMeasurements = 0;
        list.clear();

        for (int i = 0; i < QUANTITY_OF_REPETITIONS; i++) {

            startOfMeasurement = System.currentTimeMillis();
            for (int j = 0; j < inputDataVolume; j++) {
                int value = numberGenerator.nextInt();
                list.add(value);
            }
            endOfMeasurement = System.currentTimeMillis();

            updateTotalDuration();
            list.clear();
        }

        return totalDurationOfMeasurements / QUANTITY_OF_REPETITIONS;
    }

    @Override
    public double measureIteratorAddOperationEfficiency(int inputDataVolume) {
        totalDurationOfMeasurements = 0;
        fillInputCollection(inputDataVolume);
        int sizeOfUniformSegmentOfCollection = list.size() / QUANTITY_OF_REPETITIONS;
        int iterationsCounter = 0;
        int addOperationsCounter = 0;

        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            iterationsCounter++;

            if (iterationsCounter % sizeOfUniformSegmentOfCollection == 0) {
                int value = numberGenerator.nextInt();

                startOfMeasurement = System.currentTimeMillis();
                iterator.add(value);
                endOfMeasurement = System.currentTimeMillis();

                updateTotalDuration();
                addOperationsCounter++;
            }

            if (inputDataVolume == iterationsCounter) {
                break;
            }
        }

        return totalDurationOfMeasurements / addOperationsCounter;
    }

    private void updateTotalDuration() {
        durationOfMeasurement = endOfMeasurement - startOfMeasurement;
        totalDurationOfMeasurements += durationOfMeasurement;
    }


}
