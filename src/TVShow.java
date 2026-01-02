import java.util.ArrayList;

public class TVShow extends NetflixEntity{
    public int seasons;
    public TVShow(String titleIn, // default constructor
                 String idIn,
                 int release_yearIn,
                 String ratingIn,
                  ArrayList<String> countryIn,
                  ArrayList<String> directorIn,
                 ArrayList<String> genresIn,
                 int seasonsIn){

        super(titleIn, idIn, release_yearIn, ratingIn, countryIn, directorIn, genresIn); // inheriting from superclass NetflixEntity
        seasons = seasonsIn; // set the number of seasons
    }

    public int getSeasons(){
        return seasons;
    } // return number of seasons

    public void setSeasons(int inp){
        seasons = inp;
    } // set the number of seasons

}
