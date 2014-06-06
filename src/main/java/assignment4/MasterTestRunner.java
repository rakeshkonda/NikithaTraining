package assignment4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * @author nikithaperumalla
 * @id 87312
 * This the master test runner that builds the test suite
 * and runs the tests that are added to the test suite
 */
public class MasterTestRunner extends TestCase {

    public static void main(String[] args) {
        //Test runner to run the suite of tests
        TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(CustomerTest.class));
        result.addTest(new TestSuite(PriceTest.class));
        result.addTest(new TestSuite(RentalTest.class));
        return result;
    }
}