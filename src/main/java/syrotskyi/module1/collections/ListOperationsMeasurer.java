package syrotskyi.module1.collections;

public interface ListOperationsMeasurer {
    double measureAddByIndexOperationEfficiency();

    double measureGetByIndexOperationEfficiency();

    double measureRemoveByIndexOperationEfficiency();

    double measureIteratorAddOperationEfficiency(int inputDataVolume);
}
