import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;


public class Main {


    public static void option1(DataContainer dc){
        Scanner sc = new Scanner(System.in); // create new scanner
        System.out.print("Enter the type(Movie or Show): ");
        String type = sc.nextLine(); // determine the type

        System.out.print("Enter the title: ");
        String title = sc.nextLine(); // get the title

        System.out.print("Enter the director: ");
        String director = sc.nextLine(); // get the director
        ArrayList<String> directors = new ArrayList<>();
        directors.add(director); // add the director to an arraylist of directors


        System.out.print("Enter the country: ");
        String country = sc.nextLine(); // get the country
        ArrayList<String> countries = new ArrayList<>();
        countries.add(country); // add the country to an arraylist of countries

        System.out.print("Enter the release year: ");
        String release_year = sc.nextLine(); //get the release year
        int ry = Integer.parseInt(release_year); // convert release year to integer

        System.out.print("Enter the rating: ");
        String rating = sc.nextLine(); // get the rating

        System.out.print("Enter the duration(min if Movie or Seasons if show): ");
        String duration = sc.nextLine(); // get the duration
        int dur = Integer.parseInt(duration); // convert the duration to an integer

        System.out.print("Enter the genres (Separated by ', '): ");
        String raw_genres = sc.nextLine(); // get the genre list
        String[] genre_list = raw_genres.split(", ");// split genres into actual list
        ArrayList<String> genres = new ArrayList<>();
        for(int i = 0; i < genre_list.length; i++){
            genres.add(genre_list[i]); // put genres in an arraylist
        }

        String id = "s" + String.valueOf((dc.TVShowList.size() + dc.MovieList.size()) + 1); // create a new id

        if(type.equals("Show")){ // if show, then create a new show and add all the attributes to their respective lists
            TVShow newshow = new TVShow(title, id, ry, rating, countries, directors, genres, dur);
            dc.TVShowList.add(newshow);
            if(!dc.TVDurations.contains(dur)){
                dc.TVDurations.add(dur);
            }
            if(!dc.TVYears.contains(ry)){
                dc.TVYears.add(ry);
            }
            if(!dc.TVCountries.contains(country)){
                dc.TVCountries.add(country);
            }
            if(!dc.TVRatings.contains(rating)){
                dc.TVRatings.add(rating);
            }
            for(int i = 0; i < genre_list.length; i++){
                if(!dc.TVGenres.contains(genre_list[i])){
                    dc.TVGenres.add(genre_list[i]);
                }
            }
            if(!dc.TVDirectors.contains(director)){
                dc.TVDirectors.add(director);
            }
        }
        else if(type.equals("Movie")){ // if movie, then create a new movie and add all the attributes to their respective lists
            Movie newmovie = new Movie(title, id, ry, rating, countries, directors, genres, dur);
            dc.MovieList.add(newmovie);
            if(!dc.MovDurations.contains(dur)){
                dc.MovDurations.add(dur);
            }
            if(!dc.MovYears.contains(ry)){
                dc.MovYears.add(ry);
            }
            if(!dc.MovCountries.contains(country)){
                dc.MovCountries.add(country);
            }
            if(!dc.MovRatings.contains(rating)){
                dc.MovRatings.add(rating);
            }
            for(int i = 0; i < genre_list.length; i++){
                if(!dc.MovGenres.contains(genre_list[i])){
                    dc.MovGenres.add(genre_list[i]);
                }
            }
            if(!dc.MovDirectors.contains(director)){
                dc.MovDirectors.add(director);
            }
        }

    }
    public static void option2(DataContainer dc){

        Scanner sc = new Scanner(System.in);
        int num_movies = dc.MovieList.size();
        int num_shows = dc.TVShowList.size();
        int total_entities = num_movies + num_shows;
        double num_pages = Math.ceil(total_entities / 10.0);

        int curr_page = 0;
        int movies_visited = 0;
        int shows_visited = 0;

        int num = 1;
        while(curr_page < num_pages) {
            System.out.println("The list of all Movies will show first, followed by the list of shows.");

            int curr = 0;


            while(curr < 10) {
                if(movies_visited < num_movies) {
                    System.out.println((num) + ". " + dc.MovieList.get(movies_visited).getTitle());
                    movies_visited++;
                    curr++;
                    num++;
                }
                else{
                    break;
                }
            }

            while(curr < 10) {
                if(shows_visited < num_shows) {
                    System.out.println((num) + ". " + dc.TVShowList.get(shows_visited).getTitle());
                    shows_visited++;
                    curr++;
                    num++;
                }
                else{
                    break;
                }
            }


            System.out.println("Hit space bar to see more, or type the number of the title you would like to remove");
            String choice = sc.nextLine();
            if(choice.equals(" ")){
                curr_page++;
            }
            else{
                int index = Integer.parseInt(choice) - 1;

                if(index < num_movies){
                    System.out.println("Title: " + dc.MovieList.get(index).getTitle() + " will be deleted now.");
                    dc.MovieList.remove(index);
                }
                else{
                    index -= (num_movies);
                    System.out.println("Title: " + dc.TVShowList.get(index).getTitle() + " will be deleted now.");

                    dc.TVShowList.remove(index);
                }
                break;
            }
        }

    }
    public static void option3(DataContainer dc){
        Scanner sc = new Scanner(System.in); // create a scanner
        System.out.println("Are you looking for a Movie or Show?");
        String type = sc.nextLine(); // get the type of the entity

        System.out.println("\nWhich attribute are you searching based on?\n" +
                "1. Rating\n" +
                "2. Director\n" +
                "3. Genre\n" +
                "4. Duration\n" +
                "5. Country\n" +
                "6. Year\n");
        String attribute = sc.nextLine(); // get the attribute

        if(attribute.equals("1")){ // if 1, rating
            System.out.println("Please select one of the unique attributes\n");

            int num = 1;
            if(type.equals("Show")){
                for(int i = 0; i < dc.TVRatings.size(); i++){ // this loop gets all the unique ratings
                    System.out.println(num + ". " + dc.TVRatings.get(i));
                    num++;
                }
                System.out.println(); // print empty line

                String choice = sc.nextLine(); // get user choice

                String filter = dc.TVRatings.get(Integer.parseInt(choice)-1); // set filter as the choice - 1 for index purposes

                for(int i = 0; i < dc.TVShowList.size(); i++){
                    if(dc.TVShowList.get(i).getRating().equals(filter)){ // look for matching tv shows and output
                        System.out.println(dc.TVShowList.get(i).getTitle());
                    }
                }
            }
            else{ // else do the same but for movies instead
                for(int i = 0; i < dc.MovRatings.size(); i++){
                    System.out.println(num + ". " + dc.MovRatings.get(i));
                    num++;
                }
                System.out.println();

                String choice = sc.nextLine();
                String filter = dc.MovRatings.get(Integer.parseInt(choice)-1);
                for(int i = 0; i < dc.MovieList.size(); i++){
                    if(dc.MovieList.get(i).getRating().equals(filter)){
                        System.out.println(dc.MovieList.get(i).getTitle());
                    }
                }
            }
        }

        if(attribute.equals("2")){ // if 2, directors
            System.out.println("Please select one of the unique attributes\n");

            int num = 1;
            if(type.equals("Show")){
                for(int i = 0; i < dc.TVDirectors.size(); i++){
                    System.out.println(num + ". " + dc.TVDirectors.get(i)); // print out all the unique directors for the tv shows
                    num++;
                }
                System.out.println(); // print an empty line

                String choice = sc.nextLine(); // get the user's choice
                String filter = dc.TVDirectors.get(Integer.parseInt(choice)-1); // filter = choice - 1 for indexing

                for(int i = 0; i < dc.TVShowList.size(); i++){
                    if(dc.TVShowList.get(i).getDirector().contains(filter)){ // find all tv shows with matching director and output
                        System.out.println(dc.TVShowList.get(i).getTitle());
                    }
                }
            }
            else{ // else do the same but for movies
                for(int i = 0; i < dc.MovDirectors.size(); i++){
                    System.out.println(num + ". " + dc.MovDirectors.get(i));
                    num++;
                }
                System.out.println();

                String choice = sc.nextLine();
                String filter = dc.MovDirectors.get(Integer.parseInt(choice)-1);

                for(int i = 0; i < dc.MovieList.size(); i++){
                    if(dc.MovieList.get(i).getDirector().contains(filter)){
                        System.out.println(dc.MovieList.get(i).getTitle());
                    }
                }
            }
        }

        if(attribute.equals("3")){ // if 3, genres
            System.out.println("Please select one of the unique attributes\n");

            int num = 1;
            if(type.equals("Show")){
                for(int i = 0; i < dc.TVGenres.size(); i++){ // print out all of the unique tv genres
                    System.out.println(num + ". " + dc.TVGenres.get(i));
                    num++;
                }
                System.out.println(); // print an empty line
                String choice = sc.nextLine(); // get the user choice
                String filter = dc.TVGenres.get(Integer.parseInt(choice)-1); // filter = choice - 1 for indexing

                for(int i = 0; i < dc.TVShowList.size(); i++){
                    if(dc.TVShowList.get(i).getGenres().contains(filter)){ // look for matching tv shows of the genre and output
                        System.out.println(dc.TVShowList.get(i).getTitle());
                    }
                }
            }
            else{ // else, do the same thing but for movies
                for(int i = 0; i < dc.MovGenres.size(); i++){
                    System.out.println(num + ". " + dc.MovGenres.get(i));
                    num++;
                }
                System.out.println();

                String choice = sc.nextLine();
                String filter = dc.MovGenres.get(Integer.parseInt(choice)-1);

                for(int i = 0; i < dc.MovieList.size(); i++){
                    if(dc.MovieList.get(i).getGenres().contains(filter)){
                        System.out.println(dc.MovieList.get(i).getTitle());
                    }
                }
            }
        }

        if(attribute.equals("4")){ // if 4, durations
            System.out.println("Please select one of the unique attributes\n");

            int num = 1;
            if(type.equals("Show")){
                for(int i = 0; i < dc.TVDurations.size(); i++){ // print out a list of all the unique durations for tv shows
                    System.out.println(num + ". " + dc.TVDurations.get(i));
                    num++;
                }
                System.out.println();

                String choice = sc.nextLine(); // get the choice
                Integer filter = dc.TVDurations.get(Integer.parseInt(choice)-1); // filter = choice - 1 for indexing

                for(int i = 0; i < dc.TVShowList.size(); i++){ // print out matching tv shows for number of seasons specified
                    if(dc.TVShowList.get(i).getSeasons() == filter){
                        System.out.println(dc.TVShowList.get(i).getTitle());
                    }
                }
            }
            else{
                // else, for movies, we filter based on ranges
                System.out.println("Please pick a range\n" +
                        "1. 0-30 minutes\n" +
                        "2. 31-60 minutes\n" +
                        "3. 61-90 minutes\n" +
                        "4. 91-120 minutes\n" +
                        "5. 121-150 minutes\n" +
                        "6. 151-180 minutes\n");
                String choice = sc.nextLine();
                int high = 0;
                int low = 0;
                // the next series of if statements set low and high bounds
                if(choice.equals("1")){
                    low = 0;
                    high = 30;
                }
                if(choice.equals("1")){
                    low = 0;
                    high = 30;
                }
                if(choice.equals("2")){
                    low = 31;
                    high = 60;
                }
                if(choice.equals("3")){
                    low = 61;
                    high = 90;
                }
                if(choice.equals("4")){
                    low = 91;
                    high = 120;
                }
                if(choice.equals("5")){
                    low = 121;
                    high = 150;
                }
                if(choice.equals("6")){
                    low = 151;
                    high = 180;
                }
                // using the high and low bounds, output any movies that fall within the range
                for(int i = 0; i < dc.MovieList.size(); i++){
                    if(dc.MovieList.get(i).getDuration() >= low && dc.MovieList.get(i).getDuration() <= high){
                        System.out.println(dc.MovieList.get(i).getTitle());
                    }
                }
            }
        }

        if(attribute.equals("5")){ // if 5, countries
            System.out.println("Please select one of the unique attributes\n");

            int num = 1;
            if(type.equals("Show")){
                for(int i = 0; i < dc.TVCountries.size(); i++){ // print out all unique countries in tv list
                    System.out.println(num + ". " + dc.TVCountries.get(i));
                    num++;
                }
                System.out.println(); // print an empty line

                String choice = sc.nextLine(); // get the user choice
                String filter = dc.TVCountries.get(Integer.parseInt(choice)-1); // filter = choice - 1 for indexing

                for(int i = 0; i < dc.TVShowList.size(); i++){ // print out any tv show that matches the country
                    if(dc.TVShowList.get(i).getCountry().contains(filter)){
                        System.out.println(dc.TVShowList.get(i).getTitle());
                    }
                }
            }
            else{ // else, do the same but for movies
                for(int i = 0; i < dc.MovCountries.size(); i++){
                    System.out.println(num + ". " + dc.MovCountries.get(i));
                    num++;
                }
                System.out.println();

                String choice = sc.nextLine();
                String filter = dc.MovCountries.get(Integer.parseInt(choice)-1);

                for(int i = 0; i < dc.MovieList.size(); i++){
                    if(dc.MovieList.get(i).getCountry().contains(filter)){
                        System.out.println(dc.MovieList.get(i).getTitle());
                    }
                }
            }
        }

        if(attribute.equals("6")){ // if 6, release years
            System.out.println("Please select one of the unique attributes\n");

            int num = 1;
            if(type.equals("Show")){
                for(int i = 0; i < dc.TVYears.size(); i++){ // output a list of unique release years for the tv shows
                    System.out.println(num + ". " + dc.TVYears.get(i));
                    num++;
                }
                System.out.println(); // print an empty line

                String choice = sc.nextLine(); // get the user's choice
                Integer filter = dc.TVYears.get(Integer.parseInt(choice)-1); // filter = choice - 1 for indexing

                for(int i = 0; i < dc.TVShowList.size(); i++){ // print out all the tv shows that match the filter
                    if(dc.TVShowList.get(i).getRelease_year() == filter){
                        System.out.println(dc.TVShowList.get(i).getTitle());
                    }
                }
            }
            else{ // else, do the exact same as the tv shows but for movies instead
                for(int i = 0; i < dc.MovYears.size(); i++){
                    System.out.println(num + ". " + dc.MovYears.get(i));
                    num++;
                }
                System.out.println();

                String choice = sc.nextLine();
                Integer filter = dc.MovYears.get(Integer.parseInt(choice)-1);

                for(int i = 0; i < dc.MovieList.size(); i++){
                    if(dc.MovieList.get(i).getRelease_year() == filter){
                        System.out.println(dc.MovieList.get(i).getTitle());
                    }
                }
            }
        }
    }

    public static void option4(DataContainer dc){
        Scanner sc = new Scanner(System.in);
        int num_movies = dc.MovieList.size();
        int num_shows = dc.TVShowList.size();
        int total_entities = num_movies + num_shows;
        double num_pages = Math.ceil(total_entities / 10.0);

        int curr_page = 0;
        int movies_visited = 0;
        int shows_visited = 0;

        int num = 1;
        while(curr_page < num_pages) {
            System.out.println("The list of all Movies will show first, followed by the list of shows.");

            int curr = 0;


            while(curr < 10) {
                if(movies_visited < num_movies) {
                    System.out.println((num) + ". " + dc.MovieList.get(movies_visited).getTitle());
                    movies_visited++;
                    curr++;
                    num++;
                }
                else{
                    break;
                }
            }

            while(curr < 10) {
                if(shows_visited < num_shows) {
                    System.out.println((num) + ". " + dc.TVShowList.get(shows_visited).getTitle());
                    shows_visited++;
                    curr++;
                    num++;
                }
                else{
                    break;
                }
            }


            System.out.println("Hit space bar to see more, or type the number of the title you would like to change the rating of");
            String choice = sc.nextLine();
            if(choice.equals(" ")){
                curr_page++;
            }
            else{
                System.out.println("Enter the new rating for the movie you chose: ");
                String new_rating = sc.nextLine();
                int index = Integer.parseInt(choice) - 1;

                if(index < num_movies){
                    System.out.println("Rating for " + dc.MovieList.get(index).getTitle() + " is now " + new_rating);
                    dc.MovieList.get(index).setRating(new_rating);
                }
                else{
                    index -= (num_movies);
                    System.out.println("Rating for " + dc.TVShowList.get(index).getTitle() + " is now " + new_rating);

                    dc.TVShowList.get(index).setRating(new_rating);
                }
                break;
            }
        }


    }

    public static void WriteToFile(String filename, DataContainer dc) {
        try {
            FileWriter myWriter = new FileWriter(new File(filename));
            myWriter.write("show_id\ttype\ttitle\tdirector\tcountry\trelease_year\trating\tduration\tGenre\n");
            for(int i = 0; i < dc.MovieList.size(); i++){

                String writeline = "";
                String directors = "";

                for(int j = 0; j < dc.MovieList.get(i).getDirector().size()-1; j++){
                    directors += dc.MovieList.get(i).getDirector().get(j) + ", ";
                }
                directors += dc.MovieList.get(i).getDirector().get(dc.MovieList.get(i).getDirector().size()-1);

                String genres = "";
                for(int j = 0; j < dc.MovieList.get(i).getGenres().size()-1; j++){
                    genres += dc.MovieList.get(i).getGenres().get(j) + ", ";
                }
                genres += dc.MovieList.get(i).getGenres().get(dc.MovieList.get(i).getGenres().size()-1);

                String countries = "";
                for(int j = 0; j < dc.MovieList.get(i).getCountry().size()-1; j++){
                    countries += dc.MovieList.get(i).getCountry().get(j) + ", ";
                }
                countries += dc.MovieList.get(i).getCountry().get(dc.MovieList.get(i).getCountry().size()-1);

                writeline += dc.MovieList.get(i).getId() + "\t"
                        + "Movie\t" + dc.MovieList.get(i).getTitle() + "\t"
                        + directors + "\t" + countries + "\t" +
                        dc.MovieList.get(i).getRelease_year() + "\t" + dc.MovieList.get(i).getRating()
                        + "\t" + dc.MovieList.get(i).getDuration() + "\t" + genres;

                myWriter.write(writeline + "\n");
            }

            for(int i = 0; i < dc.TVShowList.size(); i++){
                String writeline = "";

                String directors = "";
                for(int j = 0; j < dc.TVShowList.get(i).getDirector().size()-1; j++){
                    directors += dc.TVShowList.get(i).getDirector().get(j) + ", ";
                }
                directors += dc.TVShowList.get(i).getDirector().get(dc.TVShowList.get(i).getDirector().size() - 1);

                String genres = "";
                for(int j = 0; j < dc.TVShowList.get(i).getGenres().size()-1; j++){
                    genres += dc.TVShowList.get(i).getGenres().get(j) + ", ";
                }
                genres += dc.TVShowList.get(i).getGenres().get(dc.TVShowList.get(i).getGenres().size() - 1);

                String countries = "";
                for(int j = 0; j < dc.TVShowList.get(i).getCountry().size() - 1; j++){
                    countries += dc.TVShowList.get(i).getCountry().get(j) + ", ";
                }
                countries += dc.TVShowList.get(i).getCountry().get(dc.TVShowList.get(i).getCountry().size() - 1);

                writeline += dc.TVShowList.get(i).getId() + "\t"
                        + "TV Show\t" + dc.TVShowList.get(i).getTitle() + "\t"
                        + directors + "\t" + countries + "\t" +
                        dc.TVShowList.get(i).getRelease_year() + "\t" + dc.TVShowList.get(i).getRating()
                        + "\t" + dc.TVShowList.get(i).getSeasons() + "\t" + genres;

                myWriter.write(writeline + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DataContainer entities = new DataContainer(); // initialize a data container to store all info
        Scanner sc = new Scanner(System.in); // create a scanner
        System.out.print("Please enter the name of the input file: ");
        String filename = sc.nextLine(); // read answer

        String line = "";
        String splitBy = "\t";

        ArrayList<String[]> raw_data = new ArrayList<>();
        int i = 0;
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] entity = line.split(splitBy); // each line is split into a list
                if(i != 0){
                raw_data.add(entity); // and added to the arraylist of raw data
                }
                i++;
            }


            for(int j = 0; j < raw_data.size(); j++){ // for each list in the raw_data array
                if(raw_data.get(j)[1].equals("TV Show")){ // if it's a tv show,
                    String[] curr_show = raw_data.get(j); // get the list representing the show
                    ArrayList<String> genr = new ArrayList<>(); // initialize a list for genres
                    ArrayList<String> countr = new ArrayList<>(); // initialize a list for countries
                    ArrayList<String> dir = new ArrayList<>(); // initialize a list for directors
                    String[] duration = curr_show[7].split(" "); // get the duration
                    String[] genres = curr_show[8].split(", "); // getthe list of genres
                    String[] countries = curr_show[4].split(", "); // get the list of countries
                    String[] directors = curr_show[3].split(", "); // get the list of directors
                    if(!entities.TVDurations.contains(Integer.parseInt(duration[0]))){
                        entities.TVDurations.add(Integer.parseInt(duration[0])); // add unique duration if not already there
                    }
                    /*the next sequence of for loops does the following:
                    * 1. loops through every item in the array
                    * 2. if the item is already in its respective unique attributes array, do nothing
                    * 3. otherwise, add the item to the unique attributes array
                    * */
                    for(int k = 0; k < genres.length; k++){
                        genr.add(genres[k]);
                        if(!entities.TVGenres.contains(genres[k])){
                            entities.TVGenres.add(genres[k]);
                        }
                    }
                    for(int k = 0; k < countries.length; k++){
                        countr.add(countries[k]);
                        if(!entities.TVCountries.contains(countries[k])){
                            entities.TVCountries.add(countries[k]);
                        }
                    }
                    for(int k = 0; k < directors.length; k++){
                        dir.add(directors[k]);
                        if(!entities.TVDirectors.contains(directors[k])){
                            entities.TVDirectors.add(directors[k]);
                        }
                    }

                    if(!entities.TVYears.contains(Integer.parseInt(curr_show[5]))){
                        entities.TVYears.add(Integer.parseInt(curr_show[5]));
                    }

                    if(!entities.TVRatings.contains(curr_show[6])){
                        entities.TVRatings.add(curr_show[6]);
                    }

                    TVShow show = new TVShow(curr_show[2],
                                             curr_show[0],
                                             Integer.parseInt(curr_show[5]),
                                             curr_show[6],
                                             countr,
                                             dir,
                                             genr,
                                             Integer.parseInt(duration[0])); // create a new tv show with the above attributes
                    entities.TVShowList.add(show); // add it to the tv show list
                }

                if(raw_data.get(j)[1].equals("Movie")){ // do the same thing as we did for the tv show, but this time it's a movie
                    String[] curr_show = raw_data.get(j);
                    ArrayList<String> genr = new ArrayList<>();
                    ArrayList<String> countr = new ArrayList<>();
                    ArrayList<String> dir = new ArrayList<>();
                    String[] duration = curr_show[7].split(" ");
                    String[] genres = curr_show[8].split("; ");
                    String[] countries = curr_show[4].split("; ");
                    String[] directors = curr_show[3].split("; ");

                    /*the next sequence of for loops does the following:
                     * 1. loops through every item in the array
                     * 2. if the item is already in its respective unique attributes array, do nothing
                     * 3. otherwise, add the item to the unique attributes array
                     * */
                    if(!entities.MovDurations.contains(Integer.parseInt(duration[0]))){
                        entities.MovDurations.add(Integer.parseInt(duration[0]));
                    }
                    for(int k = 0; k < genres.length; k++){
                        genr.add(genres[k]);
                        if(!entities.MovGenres.contains(genres[k])){
                            entities.MovGenres.add(genres[k]);
                        }
                    }
                    for(int k = 0; k < countries.length; k++){
                        countr.add(countries[k]);
                        if(!entities.MovCountries.contains(countries[k])){
                            entities.MovCountries.add(countries[k]);
                        }
                    }
                    for(int k = 0; k < directors.length; k++){
                        dir.add(directors[k]);
                        if(!entities.MovDirectors.contains(directors[k])){
                            entities.MovDirectors.add(directors[k]);
                        }
                    }

                    if(!entities.MovYears.contains(Integer.parseInt(curr_show[5]))){
                        entities.MovYears.add(Integer.parseInt(curr_show[5]));
                    }

                    if(!entities.MovRatings.contains(curr_show[6])){
                        entities.MovRatings.add(curr_show[6]);
                    }

                    Movie mov = new Movie(curr_show[2],
                            curr_show[0],
                            Integer.parseInt(curr_show[5]),
                            curr_show[6],
                            countr,
                            dir,
                            genr,
                            Integer.parseInt(duration[0]));
                    entities.MovieList.add(mov);
                }
            }

            String option = " "; // initialize the option variable

            while(!option.equals("Exit")){ // while not exit, print out the menu
                System.out.println("1. Add a title\n2. Delete a title\n3. Search for titles\n4. Modify a title\nType Exit to end program.");
                option= sc.nextLine(); // get the user's option

                if(option.equals("1")){ // if option == 1, call option 1, which is add a title
                    option1(entities);

                }
                if(option.equals("2")){ // if option == 2, call option 2, which is delete a title
                    option2(entities);
                }
                if(option.equals("3")){ // if option == 3, call option 3, which is search for titles
                    option3(entities);
                }
                if(option.equals("4")){
                    option4(entities); // if option == 4, call option 4, which is modify title
                }
            }
            WriteToFile("n3.txt", entities);
       }
        catch(IOException e) {
            e.printStackTrace(); // catch exception
        }
    }
}
