package com.masters.oops;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author nikithaperumalla.
 * @id 87312
 */
public class DriverLicense extends Card{

    private int expirationYear;

    public DriverLicense(String n, int expirationYear) {
        super(n);
        this.expirationYear = expirationYear;
    }

    public String format() {
        return super.format() + ". Driving Licence Expiration Year: "+this.expirationYear;
    }

    public boolean isExpired(){
        GregorianCalendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);

        //if expiration year is < current year
        if(this.expirationYear < currentYear){
            return true;
        }

        return false;
    }
}
