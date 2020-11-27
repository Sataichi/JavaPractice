package tasks.Task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {

    public static void main(String[] args) {

        Author[] authors = Stream.of(new Author("Kristian Bel", (short) 40),
                new Author("Hideo Kojima", (short) 52),
                new Author("Christie Golden", (short) 61),
                new Author("Kristian Bel stunt double", (short) 29))
                .toArray(Author[]::new);
        Book[] books = Stream.of(new Book("Genius", Stream.of(authors[1]).collect(Collectors.toList()), 167),
                new Book("The art of role-playing", Stream.of(authors[0]).collect(Collectors.toList()), 401),
                new Book("Rise of the horde", Stream.of(authors[2]).collect(Collectors.toList()), 320),
                new Book("Play the role of your stunt double", Stream.of(authors[0], authors[3]).collect(Collectors.toList()), 215))
                .toArray(Book[]::new);

        authors[0].setBooks(Stream.of(books[1], books[3]).collect(Collectors.toList()));
        authors[1].setBooks(Stream.of(books[0]).collect(Collectors.toList()));
        authors[2].setBooks(Stream.of(books[2]).collect(Collectors.toList()));
        authors[3].setBooks(Stream.of(books[3]).collect(Collectors.toList()));

        for (Author author : authors) {
            System.out.println(author.toString());
        }

        for (Book book : books) {
            System.out.println(book.toString());
        }
        //3.1
        System.out.println("1) anyMatch");
        System.out.println(Arrays.stream(books).peek(System.out::println).anyMatch(book -> book.getNumberOfPages() > 200));
        System.out.println("1) allMatch");
        System.out.println(Arrays.stream(books).peek(System.out::println).allMatch(book -> book.getNumberOfPages() > 200));
        //3.2
        System.out.println("2) max");
        System.out.println(Arrays.stream(books).peek(System.out::println).max(Comparator.comparingInt(Book::getNumberOfPages)));
        System.out.println("2) min");
        System.out.println(Arrays.stream(books).peek(System.out::println).min(Comparator.comparingInt(Book::getNumberOfPages)));
        //3.3
        System.out.println("3)");
        System.out.println(Arrays.stream(books).peek(System.out::println).filter(book -> book.getAuthors().size() == 1).peek(System.out::println).collect(Collectors.toList()));
        //3.4
        System.out.println("4) sort by number of pages");
        Arrays.stream(books).peek(System.out::println).sorted(Comparator.comparingInt(Book::getNumberOfPages)).forEach(System.out::println);
        System.out.println("4) sort by title");
        Arrays.stream(books).peek(System.out::println).sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println);
        //3.5, 3.6
        System.out.println("5) and 6)");
        Arrays.stream(books).peek(System.out::println).map(Book::getTitle)
                .forEach(System.out::println);
        //3.7
        System.out.println("7)");
        Arrays.stream(books).peek(System.out::println).flatMap(book -> book.getAuthors().stream()).peek(System.out::println)
                .distinct()
                .forEach(System.out::println);
        System.out.println();
        System.out.println();
        //3.1 parallel
        System.out.println("1) parallel anyMatch");
        System.out.println(Arrays.stream(books).parallel().peek(System.out::println).anyMatch(book -> book.getNumberOfPages() > 200));
        System.out.println("1) parallel allMatch");
        System.out.println(Arrays.stream(books).parallel().peek(System.out::println).allMatch(book -> book.getNumberOfPages() > 200));
        //3.2 parallel
        System.out.println("2) parallel max");
        System.out.println(Arrays.stream(books).parallel().peek(System.out::println).max(Comparator.comparingInt(Book::getNumberOfPages)));
        System.out.println("2) parallel min");
        System.out.println(Arrays.stream(books).parallel().peek(System.out::println).min(Comparator.comparingInt(Book::getNumberOfPages)));
        //3.3 parallel
        System.out.println("3) parallel filter");
        System.out.println(Arrays.stream(books).parallel().peek(System.out::println).filter(book -> book.getAuthors().size() == 1).peek(System.out::println).collect(Collectors.toList()));
        //3.4 parallel
        System.out.println("4) parallel sort by number of pages");
        Arrays.stream(books).parallel().peek(System.out::println).sorted(Comparator.comparingInt(Book::getNumberOfPages)).forEach(System.out::println);
        System.out.println("4) parallel sort by title");
        Arrays.stream(books).parallel().peek(System.out::println).sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println);
        //3.5, 3.6 parallel
        System.out.println("5) and 6) parallel getTitle");
        Arrays.stream(books).parallel().peek(System.out::println).map(Book::getTitle)
                .forEach(System.out::println);
        //3.7 parallel
        System.out.println("7) parallel authors list");
        Arrays.stream(books).parallel().peek(System.out::println).flatMap(book -> book.getAuthors().stream()).peek(System.out::println)
                .distinct()
                .forEach(System.out::println);
        //7
        System.out.println("7.");
        Optional<Book> optional = Arrays.stream(books).max(Comparator.comparingInt(Book::getNumberOfPages));
        System.out.println(optional.orElse(new Book("null", null, 0)).getTitle());
    }

}
