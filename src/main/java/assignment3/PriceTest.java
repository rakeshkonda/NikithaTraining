package assignment3;


import junit.framework.TestCase;
import org.junit.Test;


/**
 * @author nikithaperumalla
 * @id 87312
 * Test Class to validate the functionality of Price class hierarchy
 */
public class PriceTest extends TestCase {
    Price childrensPrice = new ChildrensPrice();
    Price regularPrice = new RegularPrice();
    Price newReleasePrice = new NewReleasePrice();

    @Test
    public void testGetPriceCode(){
        System.out.println("Running Price getPriceCode Test");
        assertEquals("Unexpected childrens price price-code", childrensPrice.getPriceCode(), 2);
        assertEquals("Unexpected regular price price-code", regularPrice.getPriceCode(), 0);
        assertEquals("Unexpected new release price price-code", newReleasePrice.getPriceCode(), 1);
        System.out.println("Price getPriceCode Test : PASSED");
    }

    @Test
    public void testGetCharge(){
        System.out.println("Running Price getCharge Test with the following test data");
        System.out.println("childrens single day rental");
        System.out.println("childrens 4 day rental");
        System.out.println("regular single day rental");
        System.out.println("regular 4 day rental");
        System.out.println("new release single day rental");
        System.out.println("new release 4 day rental");
        testMoviePrice(childrensPrice, 1, 1.5); //childrens single day rental
        testMoviePrice(childrensPrice, 4, 3.0);  //childrens 4 day rental
        testMoviePrice(regularPrice, 1, 2.0);   //regular single day rental
        testMoviePrice(regularPrice, 4, 5.0);   //regular 4 day rental
        testMoviePrice(newReleasePrice, 1, 3.0);  //new release single day rental
        testMoviePrice(newReleasePrice, 4, 12.0);  //new release 4 day rental
        System.out.println("Price getCharge Test : PASSED");
    }

    @Test
    public void testGetFrequentRenterPoints() {
        System.out.println("Running Price getFrequentRenterPoints Test");
        assertEquals("Unexpected renter points for childrens price", childrensPrice.getFrequentRenterPoints(1), 1);
        assertEquals("Unexpected renter points for regular price", regularPrice.getFrequentRenterPoints(1), 1);
        assertEquals("Unexpected renter points for new release price", newReleasePrice.getFrequentRenterPoints(1), 1);
        System.out.println("Price getFrequentRenterPoints Test : PASSED");
    }

    private void testMoviePrice(Price price, int daysRented, double expectedPrice) {
        double actualPrice = price.getCharge(daysRented);
        assertEquals("Unexpected price for "+ daysRented +" day(s) rental", actualPrice, expectedPrice);
    }
}
