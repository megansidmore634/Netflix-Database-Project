import java.lang.reflect.Array;
import java.util.ArrayList;

public class NetflixEntity {

    // the following lines initialize variables to store the attributes of each Netflix Entity
    // these attributes are shared between Movies and TV Shows, which is why they are in the superclass
    public String title;
    public String id;
    public int release_year;
    public String rating;
    public ArrayList<String> director = new ArrayList<>();
    public ArrayList<String> country = new ArrayList<>();
    public ArrayList<String> genres = new ArrayList<String>(); // using an ArrayList to store the genres because there could be more than one.

    public NetflixEntity(String titleIn, // default constructor
                         String idIn,
                         int release_yearIn,
                         String ratingIn,
                         ArrayList<String> countryIn,
                         ArrayList<String> directorIn,
                         ArrayList<String> genresIn)
    {
        // the following lines initialize each of the attributes
        title = titleIn;
        id = idIn;
        release_year = release_yearIn;
        rating = ratingIn;
        genres = genresIn;
        country = countryIn;
        director = directorIn;
    }

    public String getTitle(){
        return title;
    } // return the title

    public void setTitle(String inp){
        title = inp;
    } // set the title to something

    public String getId(){
        return id;
    } // return the id

    public void setId(String inp){ // set the id to something
        id = inp;
    }

    public int getRelease_year(){
        return release_year;
    } // return the release year

    public void setRelease_year(int inp){
        release_year = inp;
    } // set the release year to something

    public String getRating(){
        return rating;
    } // return the rating

    public void setRating(String inp){
        rating = inp;
    } // set the rating to something

    public ArrayList<String> getDirector(){
        return director;
    } // return the director

    public void setDirector(String inp){
        director.add(inp);
    } // set the director to something

    public ArrayList<String> getCountry(){
        return country;
    } // return the country

    public void setCountry(String inp){
        country.add(inp);
    } // set the country to something

    public ArrayList<String> getGenres(){ // return the arraylist of genres
        return genres;
    }

    public void addGenres(String inp){
        genres.add(inp);
    } // add a genre to the list
}
