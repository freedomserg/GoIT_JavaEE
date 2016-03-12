package syrotskyi.module1.collections;

import java.util.Map;
import java.util.TreeMap;

public abstract class Measurer {
    public final int MIN_QUANTITY_MEASUREMENTS = 100;
    protected static Map<String, String> results = new TreeMap<>();

    static {
        results.put("add", null);
        results.put("get", null);
        results.put("remove", null);
        results.put("contains", null);
        results.put("populate", null);
        results.put("iterator.add", null);
        results.put("iterator.remove", null);
    }

    public abstract Map<String, String> getResults(int inputDataVolume);

    public abstract String getCollectionType();
}
