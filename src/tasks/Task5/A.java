package tasks.Task5;

import java.util.List;
import java.util.Objects;

public class A {
    private int age;
    private String name;
    private double budget;
    private List<String> titlesOfReadBooks;

    public A(int age, String name, double budget, List<String> titlesOfReadBooks) {
        this.age = age;
        this.name = name;
        this.budget = budget;
        this.titlesOfReadBooks = titlesOfReadBooks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<String> getTitlesOfReadBooks() {
        return titlesOfReadBooks;
    }

    public void setTitlesOfReadBooks(List<String> titlesOfReadBooks) {
        this.titlesOfReadBooks = titlesOfReadBooks;
    }

    public String userBudgetStatistics(){
        return String.format("Rich User{age=%d, name=%s, budget=%f}", age, name, budget);
    }

    public String userReadTitlesStatistics(){
        return String.format("Well-Read User {age=%d, name=%s, readTitles=%s", age, name, titlesOfReadBooks.toString());
    }

    @Override
    public String toString() {
        return "Student {" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return age == a.age &&
                Double.compare(a.budget, budget) == 0 &&
                Objects.equals(name, a.name) &&
                Objects.equals(titlesOfReadBooks, a.titlesOfReadBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, budget, titlesOfReadBooks);
    }
}
