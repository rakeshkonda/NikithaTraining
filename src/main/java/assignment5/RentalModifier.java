package assignment5;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public class RentalModifier extends BaseRentalCategory {
    /**
     * creating a non-abstract/concrete class extending the BaseRentalCategory,
     * So that we can instantiate objects for BaseRentalCategory using RentalModifier
     */
    public RentalModifier(float rentalFee, float dailyLateFee, int rentalPeriod, int frequentRenterPoints) throws Exception {
         super(rentalFee, dailyLateFee, rentalPeriod, frequentRenterPoints);
    }
}
