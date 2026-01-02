import java.util.ArrayList;

public class DataContainer {
    public int numItemsTV;
    public int numItemsMovie;
    public ArrayList<TVShow> TVShowList = new ArrayList<TVShow>();
    public ArrayList<Movie> MovieList = new ArrayList<Movie>();

    public ArrayList<String> TVRatings = new ArrayList<>();
    public ArrayList<String> MovRatings = new ArrayList<>();

    public ArrayList<String> TVDirectors = new ArrayList<>();
    public ArrayList<String> MovDirectors = new ArrayList<>();

    public ArrayList<String> TVGenres = new ArrayList<>();
    public ArrayList<String> MovGenres = new ArrayList<>();

    public ArrayList<Integer> TVDurations = new ArrayList<>();
    public ArrayList<Integer> MovDurations = new ArrayList<>();
    public ArrayList<String> TVCountries = new ArrayList<>();
    public ArrayList<String> MovCountries = new ArrayList<>();

    public ArrayList<Integer> TVYears = new ArrayList<>();
    public ArrayList<Integer> MovYears = new ArrayList<>();

    public void insertNewTVShow(TVShow show){
        TVShowList.add(show);
    }

    public void insertNewMovie(Movie movie){
        MovieList.add(movie);
    }



}
