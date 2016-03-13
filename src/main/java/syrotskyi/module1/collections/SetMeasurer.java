package syrotskyi.module1.collections;

import java.util.Map;
import java.util.Set;

public class SetMeasurer extends Measurer {
    private Set<Integer> set;

    public SetMeasurer(Set<Integer> set) {
        this.set = set;
    }


    @Override
    public String getCollectionType() {
        return null;
    }

    @Override
    public Map<String, String> getResults(int inputDataVolume) {
        return null;
    }

    @Override
    public double measureContainsOperationEfficiency() {
        return 0;
    }

    @Override
    public double measurePopulateOperationEfficiency(int inputDataVolume) {
        return 0;
    }
}
