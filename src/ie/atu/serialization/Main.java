package ie.atu.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Book book = new Book("Java Fundamentals", "John Doe", 29.99);
        // System.out.println("Original Book: " + book);

        Movie movie = new Movie("Deadpool & Wolverine", "Shawn Levy", 2024, 4.2);
        System.out.println("Original Movie: " + movie);

        /*
         * // Serialize
         * try (FileOutputStream fileOut = new FileOutputStream("resources/book.ser");
         * ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
         * out.writeObject(book);
         * System.out.println("Book has been serialized");
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         * 
         * // Deserialize
         * try (FileInputStream fileIn = new FileInputStream("resources/book.ser");
         * ObjectInputStream in = new ObjectInputStream(fileIn)) {
         * Book deserializedBook = (Book) in.readObject();
         * System.out.println("Book has been deserialzed");
         * System.out.println("Deserialized book: " + deserializedBook);
         * } catch (IOException | ClassNotFoundException e) {
         * e.printStackTrace();
         * }
         */

        // EXERCISE 2
        try (FileOutputStream fileOut = new FileOutputStream("resources/movie.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(movie);
            System.out.println("Movie has been Serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("resources/movie.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Movie deserializedMovie = (Movie) in.readObject();
            System.out.println("Movie has be deserialized");
            System.out.println("Deserialized Movie: " + deserializedMovie);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // EXERCISE 3
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 19.99));
        books.add(new Book("1984", "George Orwell", 15.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 12.99));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Averngers: Endgame", "Russo Brothers", 2019, 4.7));
        movies.add(new Movie("Red One", "Jake Kasaan", 2024, 4.1));
        movies.add(new Movie("Gladiator II", "Ridley Scott", 2024, 3.2));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", 2008, 4.9));

        System.out.println("Original catalog:");
        books.forEach(System.out::println);
        movies.forEach(System.out::println);

        // Serialize list
        serializeBooks(books, "resources/library.ser");
        serializeMovies(movies, "resources/cinema.ser");

        // Deserialize list
        List<Book> loadedBooks = deserializeBooks("resources/library.ser");
        List<Movie> loadedMovies = deserializeMovies("resources/cinema.ser");

        System.out.println("\nDeserialized catalog:");
        loadedBooks.forEach(System.out::println);
        loadedMovies.forEach(System.out::println);

        UserProfile user = new UserProfile("johndoe", "secret123", "john@example.com");
        System.out.println("Original User: " + user);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources/user.ser"))) {
            out.writeObject(user);
            System.out.println("User has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("resources/user.ser"))) {
            UserProfile deserializedUser = (UserProfile) in.readObject();
            System.out.println("User has been deserialized");
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serializeBooks(List<Book> books, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(books);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Book> deserializeBooks(String filename) {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            books = (List<Book>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    private static void serializeMovies(List<Movie> movies, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(movies);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Movie> deserializeMovies(String filename) {
        List<Movie> movies = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            movies = (List<Movie>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movies;
    }

}
