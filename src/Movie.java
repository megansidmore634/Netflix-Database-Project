import java.util.ArrayList;

public class Movie extends NetflixEntity{
    public int duration;
    public Movie(String titleIn, // default constructor
                 String idIn,
                 int release_yearIn,
                 String ratingIn,
                 ArrayList<String> countryIn,
                 ArrayList<String> directorIn,
                 ArrayList<String> genresIn,
                 int durationIn){

        super(titleIn, idIn, release_yearIn, ratingIn, countryIn, directorIn, genresIn); // inheriting from the NetflixEntity super class
        duration = durationIn; // set duration varibable
    }

    public int getDuration(){
        return duration;
    } // get the duration

    public void setDuration(int inp){
        duration = inp;
    } // set the duration
}
