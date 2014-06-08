package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public class VideoManager {

    private static VideoManager singletonInstance = null;
    /**
     *  List of movies this video rental stores has.
     *  In future, we can replace this static library with a database
     */
    private static List<Movie> movieLibrary = null;
    private static Map<String, RentalCategory> rentalCategoryMap = new HashMap<>();
    private static Map<String, RentalModifier> rentalModifierMap = new HashMap<>();


    private void VideoManager(){
        //not letting any body, only one instance of VideoManager should exist.
        // Exists only to defeat instantiation
        //SINGLETON Object
    }

    public static VideoManager getInstance() throws Exception {
           if(singletonInstance == null){
               singletonInstance = new VideoManager();

               //Creating the rental category map, if the store manager wants, he can modify them later
               populateRentalCategoryMap();

               //When we start the application, movie library is initialized
               populateMovieLibrary();
           }
        return singletonInstance;
    }

    /**
     * Populates the RentalCategory map with
     * childrenRentalCategory, regularRentalCategory,  newRentalCategory
     * @throws Exception
     */
    private static void populateRentalCategoryMap() throws Exception {
        //Rental Modifiers
        RentalModifier regularRentalModifier =  new RentalModifier(0.0f, 0.0f, 0, 0);
        RentalModifier newRentalModifier =  new RentalModifier(0.5f, 0.5f, 2, 2);

        rentalModifierMap.put("Regular Rental", regularRentalModifier);
        rentalModifierMap.put("New Rental", newRentalModifier);

        //Rental Categories
        RentalCategory childrenRental = new RentalCategory("Children Rental", regularRentalModifier, 1.5f, 1.5f, 3, 3);
        RentalCategory regularRental = new RentalCategory("Regular Rental", regularRentalModifier, 1.5f, 1.5f, 3, 0);
        RentalCategory newRental = new RentalCategory("New Rental", newRentalModifier, 1.5f, 1.5f, 3, 1);

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
        addMovieToLibrary(avengersMovie);
        addMovieToLibrary(hobbitMovie);
        addMovieToLibrary(toyStoryMovie);
        addMovieToLibrary(carsMovie);
        addMovieToLibrary(titanicMovie);
        addMovieToLibrary(avatarMovie);
    }

    /**
     * This method lets the Video Manager manage his rentals.
     * When a customer wants to rent a movie, he may use this method
     * to check if the movie is available and rent it.
     * If the movie is not found and rental dint go through, false would be returned
     */
    private static boolean rentMovie(Customer customer, String movieTitle, int daysRented){
       boolean isRentalSuccessful = false;
       try{
            Movie movie = searchMovie(movieTitle);
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
     * This method searches the static movieList (database in future)
     * if a movie title is given
     * @param movieTitle
     */
    private static Movie searchMovie(String movieTitle) throws Exception {
        for(Movie movie : movieLibrary){
            if(movie.getTitle().equalsIgnoreCase(movieTitle)){
                return movie;
            }
        }
        //if we do not find the movie, after searching the movieLibrary, throw movie not found exception
        throw new Exception("Movie with title:"+movieTitle+" not available in the library");
    }


    public static void addMovieToLibrary(Movie movie) {
        //Lazy initialization
        if(movieLibrary == null){
            movieLibrary = new ArrayList<>();
        }
        movieLibrary.add(movie);
    }

    /**
     * Main method added, just to demo the working of VideoManager
     *
     * Scenario:
     * Customer "Nikitha" rents a new movie avenger for 5 days
     * and returns it after 7 days.
     * @param args
     */
    public static void main(String[] args){
        try {
            Customer nikithaCustomer = new Customer("Nikitha");
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
            Rental avengersRental = nikithaCustomer.searchRentals(movieRented);
            avengersRental.setDaysKept(daysKept);

            /**
             * After the customer has returned the rental, printing the statement
             */
            System.out.println(nikithaCustomer.statement());

            System.out.println("________________________________________\n");

            System.out.println(nikithaCustomer.htmlStatement());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Rental failed because "+e.getMessage());
        }
    }

}
