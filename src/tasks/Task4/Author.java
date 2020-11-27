package tasks.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Author {

    private String name;

    private short age;

    private List<Book> books;

    public Author(String name, short age) {
        this.name = name;
        this.age = age;
        books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books={" + books.stream()
                .map(x -> String.format("Book{title='%s', numbersOfPages='%d'}", x.getTitle(), x.getNumberOfPages()))
                .collect(Collectors.joining(", ")) +
                "}}";
    }
}
