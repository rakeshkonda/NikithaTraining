package softwarerefactoring.chapter1;

import com.masters.softwarerefactoring.chapter1.after.Movie;
import com.masters.softwarerefactoring.chapter1.after.Rental;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Test Class to validate the functionality of Rental class
 */
public class RentalTest extends TestCase {

    @Test
    public void testGetCharge(){
        /**
         *  Test Data : Single Rental
         *  One 'New Release' movie rental for 3 days.
         */
        System.out.println("Running Rental getCharge test with Single New Release Rental for 3 days");
        Movie avengersMovie = new Movie("Avengers", Movie.NEW_RELEASE);
        Rental avengersRental = new Rental(avengersMovie, 3);
        double expectedCharge = 9.0;

        assertTrue(avengersRental.getCharge() > 0);
        assertEquals("Charge does not match with expected value", avengersRental.getCharge(), expectedCharge);
        System.out.println("Rental getCharge test with Single New Release Rental for 3 days : PASSED");
    }

    @Test
    public void testGetFrequentRentalPoints(){
        /**
         *  Test Data : Single Rental
         *  One 'New Release' movie rental for 3 days.
         */
        System.out.println("Running Rental getFrequentRenterPoints test with Single New Release Rental for 3 days");
        Movie avengersMovie = new Movie("Avengers", Movie.NEW_RELEASE);
        Rental avengersRental = new Rental(avengersMovie, 3);

        int expectedFreqRentalPoints = 2;

        assertTrue(avengersRental.getFrequentRenterPoints() > 0);
        assertEquals("Unexpected Freq rental points", avengersRental.getFrequentRenterPoints(), expectedFreqRentalPoints);
        System.out.println("Running Rental getFrequentRenterPoints test with Single New Release Rental for 3 days : PASSED");
    }
}
