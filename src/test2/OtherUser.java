package test2;

import java.time.Period;
import java.util.List;

public class OtherUser {
    private String firstName;
    private String lastName;
    private Period period;
    private List<Order> orders;

    public OtherUser(String firstName, String lastName, Period period, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.period = period;
        this.orders = orders;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", period=" + period + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((orders == null) ? 0 : orders.hashCode());
        result = prime * result + ((period == null) ? 0 : period.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
        OtherUser other = (OtherUser) obj;
        if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
        } else if (!firstName.equals(other.firstName)) {
			return false;
		}
        if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
        } else if (!lastName.equals(other.lastName)) {
			return false;
		}
        if (orders == null) {
			if (other.orders != null) {
				return false;
			}
        } else if (!orders.equals(other.orders)) {
			return false;
		}
        if (period == null) {
            return other.period == null;
        } else return period.equals(other.period);
    }

}
