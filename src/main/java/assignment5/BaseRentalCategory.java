package assignment5;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public abstract class BaseRentalCategory {
    protected float rentalFee;
    protected float dailyLateFee;
    protected int rentalPeriod;
    protected int frequentRenterPoints;

    public BaseRentalCategory(){
        this.rentalFee = 0;
        this.dailyLateFee = 0;
        this.rentalPeriod = 0;
        this.frequentRenterPoints = 0;
    }

    public BaseRentalCategory(float rentalFee, float dailyLateFee, int rentalPeriod, int frequentRenterPoints) throws Exception {
        setRentalFee(rentalFee);
        setDailyLateFee(dailyLateFee);
        setRentalPeriod(rentalPeriod);
        setFrequentRenterPoints(frequentRenterPoints);
    }

    public float getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(float rentalFee) throws Exception {
        // test that new late fee is good then set it
        if (rentalFee >= 0)	{
            this.rentalFee	= rentalFee;
        } else {
            throw new Exception("Rental Fee can't be negative");
        }
    }

    public float getDailyLateFee() {
        return dailyLateFee;
    }

    public void setDailyLateFee(float dailyLateFee) throws InvalidArgumentException {
        // test that new late fee is good, then set it
        if (dailyLateFee >= 0){
            this.dailyLateFee	= dailyLateFee;
        }
        else {
            throw new InvalidArgumentException(new String[]{"Daily late Fee can't be negative"});
        }
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) throws InvalidArgumentException{
        // test that new rental period is good, then set it
        if (rentalPeriod >= 0){
            this.rentalPeriod = rentalPeriod;
        }
        else {
            throw new InvalidArgumentException(new String[]{"Rental Period can't be negative"});
        }
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) throws InvalidArgumentException {
        if (frequentRenterPoints >= 0){
            this.frequentRenterPoints = frequentRenterPoints;
        }
        else {
            throw new InvalidArgumentException(new String[]{"frequent Renter Points can't be negative"});
        }
    }
}
