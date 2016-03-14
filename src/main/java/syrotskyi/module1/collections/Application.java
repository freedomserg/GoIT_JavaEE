package syrotskyi.module1.collections;

import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        ArrayList<Collection> collectionsToCompare = new ArrayList<>();
        collectionsToCompare.add(new ArrayList<>());
        collectionsToCompare.add(new LinkedList<>());
        collectionsToCompare.add(new HashSet<>());
        collectionsToCompare.add(new TreeSet<>());

        EfficiencyComparator efficiencyComparator = new EfficiencyComparator();
        efficiencyComparator.addCollectionToCompare(collectionsToCompare);
    }
}