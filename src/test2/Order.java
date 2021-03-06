package test2;

public class Order {
    private String id;
    private String name;

    public Order(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Order other = (Order) obj;
        if (id == null) {
			if (other.id != null) {
				return false;
			}
        } else if (!id.equals(other.id)) {
			return false;
		}
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

}
