package challenge;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for the element repository
 *
 * @author Aaron Lam
 */
class ElementRepositoryTest {

    private ElementRepositoryImpl elementRepository;

    @BeforeEach
    void setup() {
        elementRepository = new ElementRepositoryImpl(3);
    }

    @Test
    void testRejectInvalidN() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ElementRepositoryImpl(0);
        });
    }

    @Test
    @DisplayName("Given elements exist in repository, calculate correct moving average")
    void testCalculateMovingAverage() {
        elementRepository.addElement(1L);
        elementRepository.addElement(2L);
        elementRepository.addElement(3L);
        assertEquals(2L, elementRepository.calculateMovingAverage());
    }

    @Test
    @DisplayName("Given elements exist in repository, when moving average changes, calculate the new moving average")
    void testCalculateMovingAverageForMoreThanNElements() {
        elementRepository.addElement(1L);
        elementRepository.addElement(2L);
        elementRepository.addElement(3L);
        elementRepository.addElement(4L);
        assertEquals(3L, elementRepository.calculateMovingAverage());
    }

    @Test
    @DisplayName("Given <n elements exist in repository, when moving average changes, calculate the new moving average")
    void testCalculateMovingAverageForLessThanNElements() {
        elementRepository.addElement(1L);
        elementRepository.addElement(3L);
        assertEquals(2L, elementRepository.calculateMovingAverage());
    }

    @Test
    @DisplayName("Given negative valued elements exist in repository, calculate the new moving average")
    void testCalculateMovingAverageForNegativeElements() {
        elementRepository.addElement(-1L);
        elementRepository.addElement(-2L);
        elementRepository.addElement(-3L);
        assertEquals(-2L, elementRepository.calculateMovingAverage());
    }
}
