package com.masters.oops;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author nikithaperumalla.
 * @id 87312
 */
public class TestCard extends TestCase{

    public static void main(String[] args){
        BillFold billFold = new BillFold();
        Card card1 = new CallingCard("Nikitha", 12345678, 1234);
        Card card2 = new IDCard("Nikitha", 87312);

        billFold.addCard(card1);
        billFold.addCard(card2);

        System.out.println(billFold.formatCards());

        DriverLicense expiredLicence = new DriverLicense("Nikitha", 2013);
        DriverLicense validLicence =  new DriverLicense("Nikky", 2014);

        System.out.println(expiredLicence.format() + ". Licence Expired? "+expiredLicence.isExpired());
        System.out.println(validLicence.format() + ". Licence Expired? "+validLicence.isExpired());
    }

    @Test
    public void testBillFold(){
        BillFold billFold = new BillFold();
        Card card1 = new CallingCard("Nikitha", 12345678, 1234);
        Card card2 = new IDCard("Nikitha", 87312);

        billFold.addCard(card1);
        billFold.addCard(card2);

        String formattedResponse = billFold.formatCards();
        String expectedResponse = "[Card holder: Nikitha. Calling Card Number: 12345678. PIN: 1234|Card holder: Nikitha. ID Number: 87312]";

        Assert.assertEquals("Formatted response does not match with expected response",
                expectedResponse, formattedResponse);
    }

    @Test
    public void testLicenceExpiry(){
        DriverLicense expiredLicence = new DriverLicense("Nikitha", 2013);
        DriverLicense validLicence =  new DriverLicense("Nikky", 2014);

        System.out.println(expiredLicence.format() + ". Licence Expired? "+expiredLicence.isExpired());
        System.out.println(validLicence.format() + ". Licence Expired? "+validLicence.isExpired());

        Assert.assertTrue(expiredLicence.isExpired());
        Assert.assertFalse(validLicence.isExpired());
    }
}
