package challenge;

import java.util.List;

/**
 * Interface for a generic element repository. Has three methods to:
 * - get all elements
 * - add element to repository
 * - calculate moving average
 *
 * @author Aaron Lam
 *
 * @param <T> generic element used in repository
 */
public interface ElementRepository<T> {

    List<T> getAll();

    void addElement(T element);

    T calculateMovingAverage();

}
