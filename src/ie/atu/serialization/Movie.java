package ie.atu.serialization;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String director;
    private int year;
    private double rating;
    private int currentYear = java.time.Year.now().getValue();

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        try {
            if (year >= 1900 && year <= currentYear) {
                this.year = year;
            } else {
                throw new IllegalArgumentException("Year must be between 1900 and the current year.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        this.rating = rating;

    }

    @Override
    public String toString() {
        return "Movie {title='" + title + "', director='" +
                director + "', year=" + year + "', rating='" +
                rating + "}";
    }

}
