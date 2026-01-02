import sun.nio.ch.Net;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;


public class Stage1Test {

    public static NetflixEntity makeChanges(NetflixEntity ent){ // function to initiate a change
        Scanner sc = new Scanner(System.in); // create a scanner
        System.out.println("Would you like to change any of the attributes?");
        String answer = sc.nextLine(); // read answer

        if(answer.equals("Yes")){ // if the answer is yes, execute the following
            System.out.println("Type the attribute you would like to change:");
            String attribute = sc.nextLine(); // get the attribute to be changed


        /* the following lines of code ( until line 66 ) evaluate which attribute the user entered to be changed. Then,
           it will print out the old value using the appropriate get method, prompt the user for the
           new attribute, and change the attribute using one of the set methods
         */

            if(attribute.equals("Title")){
                System.out.println("Old value was: " + ent.getTitle());
                System.out.println("What would you like to change Title to?");
                String change = sc.nextLine();
                ent.setTitle(change);
            }
            if(attribute.equals("Rating")){
                System.out.println("Old value was: " + ent.getRating());
                System.out.println("What would you like to change Rating to?");
                String change = sc.nextLine();
                ent.setRating(change);
            }
            if(attribute.equals("Genre")){
                System.out.println("Old value was: " + ent.genres.get(0));
                System.out.println("What would you like to change Genre to?");
                String change = sc.nextLine();
                ent.genres.set(0, change);
            }
            if(attribute.equals("Country")) {
                System.out.println("Old value was: " + ent.getCountry());
                System.out.println("What would you like to change Country to?");
                String change = sc.nextLine();
                ent.setCountry(change);
            }
            if(attribute.equals("Director")) {
                System.out.println("Old value was: " + ent.getDirector());
                System.out.println("What would you like to change Director to?");
                String change = sc.nextLine();
                ent.setDirector(change);
            }
            if(attribute.equals("ID")) {
                System.out.println("Old value was: " + ent.getId());
                System.out.println("What would you like to change ID to?");
                String change = sc.nextLine();
                ent.setId(change);
            }
            if(attribute.equals("Release Year")) {
                System.out.println("Old value was: " + ent.getRelease_year());
                System.out.println("What would you like to change Release Year to?");
                int change = sc.nextInt();
                sc.nextLine();
                ent.setRelease_year(change);
            }
        }

        return ent; // return the modified entity
    }

    public static void printmovie(DataContainer dc){ // function for printing out the movie list

        for(int i = 0; i < dc.MovieList.size(); i++) { // for every movie in the movie list, print out the attributes
            System.out.println("Movie Title: " + dc.MovieList.get(i).getTitle()); // get title
            System.out.println("Movie ID: " + dc.MovieList.get(i).getId()); // get id
            System.out.println("Movie Release Year: " + dc.MovieList.get(i).getRelease_year()); // get release year
            System.out.println("Movie Rating: " + dc.MovieList.get(i).getRating()); // get rating
            System.out.println("Movie Country: " + dc.MovieList.get(i).getCountry()); // get country
            System.out.println("Movie Director: " + dc.MovieList.get(i).getDirector()); // get director
            System.out.print("Movie Genre(s): "); // print out the genres
            if (dc.MovieList.get(i).getGenres().size() == 1) { // if the genre list size = 1, then only print that one
                System.out.print(dc.MovieList.get(i).getGenres().get(0) + "\n");
            } else {
                for (int j = 0; j < dc.MovieList.get(i).getGenres().size() - 1; j++) {
                    System.out.print(dc.MovieList.get(i).getGenres().get(j) + ", ");
                }
                System.out.print(dc.MovieList.get(i).getGenres().get(dc.MovieList.get(i).getGenres().size() - 1) + "\n"); // for formatting purposes
            }
            System.out.println("Movie Duration: " + dc.MovieList.get(i).getDuration()); // get duration
        }
    }

    public static void printTVShow(DataContainer dc) { // function to print the tv show list
        for (int i = 0; i < dc.TVShowList.size(); i++) { // for every item in the tv show list
            System.out.println("TV Show Title: " + dc.TVShowList.get(i).getTitle()); // get title
            System.out.println("TV Show ID: " + dc.TVShowList.get(i).getId()); // get id
            System.out.println("TV Show Release Year: " + dc.TVShowList.get(i).getRelease_year()); // get release year
            System.out.println("TV Show Rating: " + dc.TVShowList.get(i).getRating()); // get rating
            System.out.println("TV Show Country: " + dc.TVShowList.get(i).getCountry()); // get country
            System.out.println("TV Show Director: " + dc.TVShowList.get(i).getDirector()); // get director
            System.out.print("TV Show Genre(s): "); // print out the genres
            if (dc.TVShowList.get(i).getGenres().size() == 1) { // if the genre list size =1, only print that
                System.out.print(dc.TVShowList.get(i).getGenres().get(0) + "\n");
            } else {
                for (int j = 0; j < dc.TVShowList.get(i).getGenres().size() - 1; j++) {
                    System.out.print(dc.TVShowList.get(i).getGenres().get(j) + ", ");
                }
                System.out.print(dc.TVShowList.get(i).getGenres().get(dc.TVShowList.get(i).getGenres().size() - 1) + "\n"); // for formatting purposes
            }
            System.out.println("TV Show seasons: " + dc.TVShowList.get(i).getSeasons()); // get seasons

        }
    }
    public static void main(String[] args ){

        DataContainer dc = new DataContainer(); // create a new data container to contain the new movie or tv show

        Scanner sc = new Scanner(System.in); // create a new scanner to read input
        System.out.print("TV Show or Movie?\n"); // prompt the user for the name of the file
        String type = sc.nextLine(); // read the user input as a string

        System.out.println("Okay we are going to build a " + type);

        // the next lines of code prompt the user for each of the attributes
        System.out.println("Please enter a Title: ");
        String title = sc.nextLine();
        System.out.println("Please enter a Genre: ");
        String genres_raw = sc.nextLine();
        System.out.println("Please enter a Director: ");
        String director = sc.nextLine();
        System.out.println("Please enter a Country: ");
        String country = sc.nextLine();
        System.out.println("Please enter a rating: ");
        String rating = sc.nextLine();
        System.out.println("Please enter a Release Year: ");
        int release_year = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter an ID: ");
        String id = sc.nextLine();

        String[] genre_list = genres_raw.split(",");
        ArrayList<String> genres = new ArrayList<String>();

        for(int i = 0; i < genre_list.length; i++){
            genres.add(genre_list[i]);
        }
/*
        if(type.equals("TV Show")){ // if the type the user entered was a tv show:
            System.out.println("Please enter a Number of Seasons: "); // prompt for a number of seasons
            int seasons = sc.nextInt(); // read number of seasons
            TVShow show = new TVShow(title, id, release_year, rating, country, director, genres, seasons); // create new tv show instance
            dc.TVShowList.add(show); // add the tv show to the tv show list in dc
            printTVShow(dc); // print out the tv show attributes
            dc.TVShowList.set(0, (TVShow) makeChanges(dc.TVShowList.get(0))); // set the new tv show to what was returned from the make changes function
            System.out.println("Here is the new TV Show");
            printTVShow(dc); // print new tv show attributes
        }
        else{ // otherwise (if the type is movie)
            System.out.println("Please enter a Duration in Minutes: "); // prompt user for movie duration
            int duration = sc.nextInt(); // read the duration
            Movie mov = new Movie(title, id, release_year, rating, country, director, genres, duration); // instantiate a new movie instance
            dc.MovieList.add(mov); // add the new movie to the movie list in the dc
            System.out.println("Here is the created " + type);
            printmovie(dc); // print out the movie we just created
            dc.MovieList.set(0, (Movie)makeChanges(dc.MovieList.get(0))); // change the movie based on what's returned from makechanges
            System.out.println("Here is the new movie");
            printmovie(dc); // print out the new movie attributes
        }*/
    }
}
