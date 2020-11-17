package test;

import java.time.Period;

public class User {
    private String firstName;
    private String lastName;
    private Period period;

    public User(String firstName, String lastName, Period period) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.period = period;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", period=" + period + "]";
    }

}
