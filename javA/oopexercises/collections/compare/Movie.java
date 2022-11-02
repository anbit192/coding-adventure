package oopexercises.collections.compare;

public class Movie implements Comparable<Movie> {

    private String name;
    private double rating;
    private int year;


    @Override
    public int compareTo(Movie anotherMovie) {
        if (this.year == anotherMovie.year) {
            return 0;
        } else if (this.year < anotherMovie.year) {
            return -1;
        } else {
            return 1;
        }
    }

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
