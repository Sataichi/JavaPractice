package tasks.task2;

public class DoubleObj {
    private Long id;
    private Double value;

    public DoubleObj(Long id, Double obj) {
        this.id = id;
        this.value = obj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
