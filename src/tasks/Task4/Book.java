package tasks.Task4;

import java.util.List;
import java.util.stream.Collectors;

public class Book {

    private String title;

    private List<Author> authors;

    private int numberOfPages;

    public Book(String title, List<Author> authors, int numberOfPages) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors={" + authors.stream()
                .map(x -> String.format("Author{name='%s', age='%d'}", x.getName(), x.getAge()))
                .collect(Collectors.joining(", ")) +
                "}, numberOfPages=" + numberOfPages +
                '}';
    }
}
