package syrotskyi.module1.collections;

import java.util.*;

public class ListMeasurer extends Measurer implements ListOperationsMeasurer {
    private List<Integer> list;
    private final int INDEX_FOR_ADD_OPERATION = 0;

    public ListMeasurer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String getCollectionType() {
        return list.getClass().getSimpleName();
    }

    @Override
    public Map<String, String> getResults(int inputDataVolume) {
        results.put("add", String.valueOf(measureAddOperationByIndexEfficiency(INDEX_FOR_ADD_OPERATION, inputDataVolume)));

        return results;
    }

    @Override
    public double measureAddOperationByIndexEfficiency(int index, int inputDataVolume) {
        double totalDuration = 0;
        long start;
        long end;
        long duration;

        for (int i = 0; i < MIN_QUANTITY_MEASUREMENTS; i++) {

            start = System.currentTimeMillis();
            for (int j = 0; j < inputDataVolume; j++) {
                Random random = new Random();
                list.add(index, random.nextInt());
            }
            end = System.currentTimeMillis();

            duration = end - start;
            totalDuration += duration;

            try {
                list = list.getClass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return totalDuration / MIN_QUANTITY_MEASUREMENTS;
    }
}
