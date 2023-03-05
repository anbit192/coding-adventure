package oopexercises.collections.compare.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareTest {

    public static void printInfo(List<Movie> list) {
        for (Movie movie : list) {
            System.out.println(movie);
        }
    }

    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Neon Genesis Evangelion", 8.3, 1995));
        list.add(new Movie("The End Of Evangelion", 7.5, 1997));
        list.add(new Movie("Evangelion 3.0 + 1.0 Thrice Upon A Time", 7.3,2021));

        System.out.println("Sort by year: ");
        Collections.sort(list);
        printInfo(list);

        System.out.println("Sort by rating:");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        printInfo(list);

        System.out.println("Sort by name:");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list,nameCompare);
        printInfo(list);

    }
}
