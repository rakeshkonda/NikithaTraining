import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import softwarerefactoring.chapter1.*;


/**
 * This the master test runner that builds the test suite
 * and runs the tests that are added to the test suite
 */
class MasterTestRunner extends TestCase {

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