package syrotskyi.module1.collections;

public interface ListOperationsMeasureAble {
    double measureAddByIndexOperationEfficiency();

    double measureGetByIndexOperationEfficiency();

    double measureRemoveByIndexOperationEfficiency();

    double measureIteratorAddOperationEfficiency();

    double measureIteratorRemoveOperationEfficiency();
}