package assignment4;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public class RentalCategory extends BaseRentalCategory {

    protected RentalModifier rentalModifier;
    protected String nameSPtr;

    public RentalCategory(String nameSPtr, RentalModifier rentalModifier, float rentalFee,
                          float dailyLateFee, int rentalPeriod, int frequentRenterPoints) throws Exception {
        setNameSPtr(nameSPtr);
        setRentalModifier(rentalModifier);
        setRentalFee(rentalFee);
        setDailyLateFee(dailyLateFee);
        setRentalPeriod(rentalPeriod);
        setFrequentRenterPoints(frequentRenterPoints);
    }

    /**
     *  The following functions calculate specific rental charge, late charge, and
     *  frequent renter points for this rental
     */
    public float RentalCharge()  {
        return (this.getRentalFee() + this.getRentalModifier().getRentalFee());
    }

    public int getPointsEarned()  {
        return (this.getFrequentRenterPoints() + this.getRentalModifier().getFrequentRenterPoints());
    }

    public float getLateCharge(int daysKept){
        // If renter returned rental in time, else return computed fee
        if(daysKept <= (this.getRentalPeriod() - this.getRentalModifier().getRentalPeriod())) {
            return 0.0f;
        } else {
           return  (daysKept - this.getRentalPeriod()) * (this.getDailyLateFee() + this.getRentalModifier().getDailyLateFee());
        }
    }


    //the following operations get name & new rental modifier
    public String getName() {
        return this.nameSPtr;
    }

    public RentalModifier getRentalModifier() {
        return this.rentalModifier;
    }

    //operations to set name & new rental modifier
    public void  setNameSPtr(String nameSPtr) throws Exception {
        // simple test that new fee value is good, then set it
        if( nameSPtr != null && !nameSPtr.isEmpty()) {
            this.nameSPtr = nameSPtr;
        } else {
             throw new Exception("Category Name Ptr can't null or point to empty string");
        }
    }

    public void setRentalModifier(RentalModifier rentalModifier) throws Exception {
        // simple test that new rental modifier is good, then set it
        if (rentalModifier != null) {
            this.rentalModifier = rentalModifier;
        } else {
            throw new Exception("New rental modifier can't be null");
        }
    }
}
