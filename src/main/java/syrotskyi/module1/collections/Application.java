package syrotskyi.module1.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Application {
    public static void main(String[] args) {
        ArrayList<Collection> collectionsToCompare = new ArrayList<>();
        collectionsToCompare.add(new ArrayList<>());
        collectionsToCompare.add(new LinkedList<>());
        EfficiencyComparator.addCollectionToCompare(collectionsToCompare);
    }
}