package assignment5;

import java.util.ArrayList;
import java.util.List;

public class MoviesInventory {
    /**
     * List of movies this video rental stores has.
     * In future, we can replace this static library with a database
     */
    static List<Movie> movieLibrary = null;

    /**
     * This method searches the static movieList (database in future)
     * if a movie title is given
     *
     * @param movieTitle title of the movie
     * @return Movie movie object with the title of the movie
     */
    static Movie searchMovie(String movieTitle) throws Exception {
        for (Movie movie : movieLibrary) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                return movie;
            }
        }
        //if we do not find the movie, after searching the movieLibrary, throw movie not found exception
        throw new Exception("Movie with title:" + movieTitle + " not available in the library");
    }

    public static void addMovieToLibrary(Movie movie) {
        //Lazy initialization
        if (movieLibrary == null) {
            movieLibrary = new ArrayList<Movie>();
        }
        movieLibrary.add(movie);
    }
}