package challenge;

/**
 * Main class for SDE challenge. It will instantiate the repository class,
 * add elements, and calculate the moving average twice.
 *
 * @author Aaron Lam
 */
public class SDEChallengeApplication {

    public static void main(String[] args) {

        ElementRepositoryImpl elementRepository = new ElementRepositoryImpl(3);

        elementRepository.addElement(2L);
        elementRepository.addElement(3L);
        elementRepository.addElement(4L);

        System.out.println("Average is: " + elementRepository.calculateMovingAverage()); //Expect 3

        elementRepository.addElement(5L);
        elementRepository.addElement(6L);

        System.out.println("Average is: " + elementRepository.calculateMovingAverage()); //Expect 5

    }


}