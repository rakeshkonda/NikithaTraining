package assignment5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public class VideoManager {

    private static VideoManager singletonInstance = null;
    private static Map<String, RentalCategory> rentalCategoryMap = new HashMap<String, RentalCategory>();
    private static Map<String, RentalModifier> rentalModifierMap = new HashMap<String, RentalModifier>();
    private static ExistingCustomers existingCustomers = new ExistingCustomers();


    private VideoManager(){
        //not letting any body, only one instance of VideoManager should exist.
        // Exists only to defeat instantiation
        //SINGLETON Object
    }

    public static VideoManager getInstance() throws Exception {
           if(singletonInstance == null){
               singletonInstance = new VideoManager();

               //Creating the rental category map, if the store manager wants, he can modify them later
               populateRentalCategoryMap();

               //When we start the application, movie library is initialized with a set of videos available in store
               populateMovieLibrary();
           }
        return singletonInstance;
    }

    /**
     * Populates the RentalCategory map with
     * childrenRentalCategory, regularRentalCategory,  newRentalCategory
     * @throws Exception exception
     */
    private static void populateRentalCategoryMap() throws Exception {
        //Rental Modifiers
        RentalModifier regularRentalModifier =  new RentalModifier(0.0f, 0.0f, 0, 0);
        RentalModifier newRentalModifier =  new RentalModifier(1.0f, 1.5f, 1, 1);

        rentalModifierMap.put("Regular Rental", regularRentalModifier);
        rentalModifierMap.put("New Rental", newRentalModifier);

        //Rental Categories
        RentalCategory childrenRental = new RentalCategory("Children Rental", regularRentalModifier, 1.5f, 1.5f, 3, 3);
        RentalCategory regularRental = new RentalCategory("Regular Rental", regularRentalModifier, 2.0f, 1.5f, 2, 1);
        RentalCategory newRental = new RentalCategory("New Rental", newRentalModifier, 2.0f, 1.5f, 2, 1);

        rentalCategoryMap.put("Children Rental", childrenRental);
        rentalCategoryMap.put("Regular Rental", regularRental);
        rentalCategoryMap.put("New Rental", newRental);
    }

    /**
     * Populates the static movie library.
     * In future, we can modify method and make it add movies to a database
     */
    private static void populateMovieLibrary(){
        //Two new movies
        Movie avengersMovie = new Movie("Avengers", rentalCategoryMap.get("New Rental"));
        Movie hobbitMovie = new Movie("Hobbit", rentalCategoryMap.get("New Rental"));

        //two children movies
        Movie toyStoryMovie = new Movie("Toy Story", rentalCategoryMap.get("Children Rental"));
        Movie carsMovie = new Movie("Cars", rentalCategoryMap.get("Children Rental"));

        //two regular movie
        Movie titanicMovie = new Movie("Titanic", rentalCategoryMap.get("Regular Rental"));
        Movie avatarMovie = new Movie("Avatar", rentalCategoryMap.get("Regular Rental"));

        //adding the above mentioned movies to my static library
        MoviesInventory.addMovieToLibrary(avengersMovie);
        MoviesInventory.addMovieToLibrary(hobbitMovie);
        MoviesInventory.addMovieToLibrary(toyStoryMovie);
        MoviesInventory.addMovieToLibrary(carsMovie);
        MoviesInventory.addMovieToLibrary(titanicMovie);
        MoviesInventory.addMovieToLibrary(avatarMovie);
    }

    /**
     * This method lets the Video Manager manage his rentals.
     * When a customer wants to rent a movie, he may use this method
     * to check if the movie is available and rent it.
     * If the movie is not found and rental dint go through, false would be returned
     *
     * @param customer customer
     * @param movieTitle title of the movie
     * @param daysRented number of days rented
     * @return true if rental successful, else false
     */
    public static boolean rentMovie(Customer customer, String movieTitle, int daysRented){
       boolean isRentalSuccessful = false;
       try{
            Movie movie = MoviesInventory.searchMovie(movieTitle);
            Rental rental = new Rental(movie, daysRented);
            customer.addRental(rental);
            isRentalSuccessful = true;
       } catch (Exception e){
           //if movie not found, an exception would be thrown
           System.out.println(e.getMessage());
       }
        return isRentalSuccessful;
    }


    /**
     * Main method added, just to demo the working of VideoManager
     *
     * Scenario:
     * Customer "Nikitha" rents a new movie avenger for 5 days
     * and returns it after 7 days.
     * @param args main arguments
     */
    public static void main(String[] args){
        try {
            Customer nikithaCustomer = createCustomer("nikitha", "", "");
            final String movieRented = "Avengers";
            int daysRented = 5;
            int daysKept = 7;

            /**
             *  Test Data : Single Rental
             *  One 'New Release' movie rental for 5 days
             */
            boolean isRentalSuccessful = VideoManager.getInstance().rentMovie(nikithaCustomer, movieRented, daysRented);

            /**
             * Lets assume, the movie was returned after 7 days i.e., daysKept is 7
             */
            VideoManager.getInstance().modifyDaysKept(nikithaCustomer, movieRented, daysKept);

            /**
             * After the customer has returned the rental, printing the statement
             */
            System.out.println(nikithaCustomer.statement());

            System.out.println("________________________________________\n");

            System.out.println(nikithaCustomer.getStatement().htmlStatement());

            checkOutAndPrintReceipt(nikithaCustomer, 100.00);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Rental failed because "+e.getMessage());
        }
    }

    public static void modifyDaysKept(Customer customer, String movieRented, int daysKept) throws Exception {
        Rental avengersRental = customer.searchRentals(movieRented);
        avengersRental.setDaysKept(daysKept);
    }

    /**
     * Creates customer object with the given params.
     * if the customer is not present in the existing customers list,
     * then it will be added to the existing customers list
     *
     * @param firstName first name of the customer
     * @param lastName  last name of the customer
     * @param address address of the customer
     *
     * @return customer object with the given params
     */
    public static Customer createCustomer(String firstName, String lastName, String address){
        PersonDescription personDesc = new PersonDescription(firstName, lastName, address);
        Customer customer = new Customer(personDesc);
        if(isNewCustomer(customer)){
            //if new customer then add to existing customers map
            existingCustomers.addToCustomersMap(customer);
        } else {
            // do nothing
        }
        return customer;
    }

    /**
     * checks if the given customer is new or already exists
     * @param customer customer
     * @return returns true if new customer else false
     */
    public static boolean isNewCustomer(Customer customer){
        return existingCustomers.isNewCustomer(customer);
    }

    public static void checkOutAndPrintReceipt(Customer customer, double amountPaid){
         Receipt receipt = new Receipt(customer, amountPaid);
         receipt.printReceipt();
    }
}
