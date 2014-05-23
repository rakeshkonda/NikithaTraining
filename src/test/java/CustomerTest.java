import com.masters.softwarerefactoring.chapter1.after.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test Class to validate the functionality of Customer class
 */
public class CustomerTest extends TestCase {

    @Test
    public void testStatement(){
        Customer customer1 = new Customer("Nikitha");
        /**
         *  Test Data:
         *  One 'New Release' movie rental for 3 days.
         */
        Movie avengersMovie = new Movie("Avengers", Movie.NEW_RELEASE);
        Rental avengersRental = new Rental(avengersMovie, 3);
        customer1.addRental(avengersRental);

        /**
         *  Expected price : daysRented * 3 => $9.00
         *  Expected Rental point : daysRented > 2 => 2 points
         *  Expected statement :
         *  " Rental Record for Nikitha
         *        Avengers	9.0
         *    Amount owed is 9.0
         *    You earned 2 frequent renter points "
         */
        double expectedPrice = 9.0;
        int expectedFreqRentalPoints = 2;
        String expectedStatement = "Rental Record for " + customer1.getName() + "\n"
                + "\t" + avengersMovie.getTitle() + "\t" + String.valueOf(avengersRental.getCharge()) + "\n"
                + "Amount owed is " + String.valueOf(expectedPrice) + "\n"
                + "You earned " + String.valueOf(expectedFreqRentalPoints) +
                " frequent renter points";

        String actualStatement = customer1.statement();
        assertNotNull(actualStatement);
        System.out.println(actualStatement);
        assertEquals("Statement not matching for single rental", expectedStatement, actualStatement);
    }
}
