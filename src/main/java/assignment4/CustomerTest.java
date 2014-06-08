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
        Customer nikithaCustomer = new Customer("Nikitha");
        final String movieRented = "Avengers";
        int daysRented = 5;
        int daysKept = 7;

        /**
         *  Test Data : Single Rental
         *  One 'New Release' movie rental for 5 days
         */
        try {
            boolean isRentalSuccessful = VideoManager.getInstance().rentMovie(nikithaCustomer, movieRented, daysRented);
            /**
             * Lets assume, the movie was returned after 7 days i.e., daysKept is 7
             */
            VideoManager.getInstance().modifyDaysKept(nikithaCustomer, movieRented, daysKept);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         *  Expected statement :
         *  " Rental Record for Nikitha
         *        Avengers	10.0
         *    Amount owed is 10.0
         *    You earned 1 frequent renter points "
         */
        double expectedPrice = 10.0;
        int expectedFreqRentalPoints = 1;
        String expectedStatement = "Rental Record for " + nikithaCustomer.getName() + "\n"
                + "\t" + movieRented + "\t" + String.valueOf(expectedPrice) + "\n"
                + "Amount owed is " + String.valueOf(expectedPrice) + "\n"
                + "You earned " + String.valueOf(expectedFreqRentalPoints) +
                " frequent renter points";

        String actualStatement = nikithaCustomer.statement();
        assertNotNull(actualStatement);
        assertEquals("Statement not matching for single rental", expectedStatement, actualStatement);
        System.out.println("testStatement test with Single New Release Rental for "+daysKept +" days : PASSED");


        String expectedHTMLStatement = "<H1>Rentals for <EM>Nikitha</EM></H1><P>\n"
                + movieRented + ": " + expectedPrice + "<BR>\n"
                + "<P>You owe <EM>"+expectedPrice+"</EM><P>\n"
                + "On this rental you earned <EM>"
                + expectedFreqRentalPoints+"</EM> frequent renter points<P>";

        String htmlStatement = nikithaCustomer.htmlStatement();
        assertNotNull(htmlStatement);
        assertEquals("HTML Statement not matching for single rental", expectedHTMLStatement, htmlStatement);
        System.out.println("testHTMLStatement test with Single New Release Rental for "+ daysKept +" : PASSED");
    }
}
