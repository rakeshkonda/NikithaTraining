package assignment4;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author nikithaperumalla
 * @id 87312
 * Test Class to validate the functionality of Customer class
 */
public class CustomerTest extends TestCase {

    @Test
    public void testStatement(){
        Customer customer1 = new Customer("Nikitha");
        /**
         *  Test Data : Single Rental
         *  One 'New Release' movie rental for 3 days.
         */
        Movie avengersMovie = new Movie("Avengers", Movie.NEW_RELEASE);
        Rental avengersRental = new Rental(avengersMovie, 3);
        customer1.addRental(avengersRental);

        System.out.println("Running testStatement test with Single New Release Rental for 3 days");

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
        assertEquals("Statement not matching for single rental", expectedStatement, actualStatement);
        System.out.println("testStatement test with Single New Release Rental for 3 days : PASSED");
    }

    @Test
    public void testHtmlStatement(){
        Customer customer1 = new Customer("Nikitha");
        /**
         *  Test Data : Multiple Rentals
         *  One 'New Release' movie rental for 3 days.
         *  One 'Childrens' movie rental for 2 days.
         */
        Movie avengersMovie = new Movie("Avengers", Movie.NEW_RELEASE);
        Movie carsMovie = new Movie("Cars", Movie.CHILDRENS);

        Rental avengersRental = new Rental(avengersMovie, 3);
        Rental carsMovieRental = new Rental(carsMovie, 2);

        customer1.addRental(avengersRental);
        customer1.addRental(carsMovieRental);

        System.out.println("Running testHTMLStatement test with Multiple Rentals, one New Release Rental for 3 days " +
                "and one Childrens movie rental for 2 days");

        /**
         *  Expected price : New Release 9.0, Children movie 1.5
         *  Expected Rental point : New Release 2, Children movie 1
         *  Expected statement :
         *  <H1>Rentals for <EM>Nikitha</EM></H1><P>
         *  Avengers: 9.0<BR>
         *  Cars: 1.5<BR>
         *  <P>You owe <EM>10.5</EM><P>
         *  On this rental you earned <EM>3</EM> frequent renter points<P>
         */
        double expectedPrice = 10.5;
        int expectedFreqRentalPoints = 3;

        String expectedStatement = "<H1>Rentals for <EM>Nikitha</EM></H1><P>\n"
                + avengersMovie.getTitle() + ": " + avengersRental.getCharge() + "<BR>\n"
                + carsMovie.getTitle() + ": " + carsMovieRental.getCharge() + "<BR>\n"
                + "<P>You owe <EM>"+expectedPrice+"</EM><P>\n"
                + "On this rental you earned <EM>"
                + expectedFreqRentalPoints+"</EM> frequent renter points<P>";

        String actualStatement = customer1.htmlStatement();
        assertNotNull(actualStatement);
        assertEquals("HTML Statement not matching for single rental", expectedStatement, actualStatement);
        System.out.println("testHTMLStatement test with Multiple Rentals, one New Release Rental for 3 days " +
                "and one Childrens movie rental for 2 days : PASSED");
    }
}
