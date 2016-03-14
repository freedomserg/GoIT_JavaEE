package syrotskyi.module1.collections;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        ArrayList<Collection> collectionsToCompare = new ArrayList<>();
        collectionsToCompare.add(new ArrayList<>());
        collectionsToCompare.add(new ArrayDeque<>());
        EfficiencyComparator.addCollectionToCompare(collectionsToCompare);
    }
}