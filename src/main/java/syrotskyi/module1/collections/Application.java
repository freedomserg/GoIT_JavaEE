package syrotskyi.module1.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Application {
    public static void main(String[] args) {
        ArrayList<Collection> collectionsToCompare = new ArrayList<>();
        collectionsToCompare.add(new ArrayList<>());
        EfficiencyComparator.addCollectionToCompare(collectionsToCompare);
    }
}
