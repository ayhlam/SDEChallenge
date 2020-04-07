package challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the element repository interface, using Long types as the elements
 *
 * @author Aaron Lam
 */
public class ElementRepositoryImpl implements ElementRepository<Long> {

    // Denotes the size of the moving average that is calculated
    private final int n;

    // The arrayList to store the elements added to the repository
    private List<Long> array;

    // Variable that will store the sum of the last `n` values
    private Long sum;

    ElementRepositoryImpl(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("N must be number greater than 0");
        }
        this.n = n;
        this.array = new ArrayList<Long>();
        this.sum = 0L;
    }

    /**
     * Function to return a list of all elements in the repository
     *
     * @return list of elements
     */
    public List<Long> getAll(){
        return array;
    }

    /**
     * Function to add an element to the list. Will not accept null values
     *
     * @param element long-type value to be added into the list
     */
    public void addElement(Long element) {
        if (element == null) {
            throw new IllegalArgumentException("Element " + element + " is not valid number");
        }

        array.add(element);
        sum += element;

        /*
        If the size of the list is greater than n, we will subtract the first value from the sum. Therefore, only the
        sum of the last `n` values will be saved in the variable.
        We have an edge case in where n < size of the array.
        */
        if(array.size() > n) {
            sum = sum - array.get(array.size() - n - 1);
        }
    }

    /**
     * Will return the moving average of the last `n` values added to the list.
     * If array size < n, then we return the average of what exists in the array.
     *
     * @return moving average value
     */
    public Long calculateMovingAverage() {
        return array.size() < n ? sum/array.size() : sum/n;
    }

}
