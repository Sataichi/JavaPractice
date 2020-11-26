package tasks.task3;

public class HandleObject {

    private Double distance;

    private Double size;

    private Color color;

    public HandleObject(Double distance, Double size, Color color) {
        this.distance = distance;
        this.size = size;
        this.color = color;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "HandleObject{" +
            "distance=" + distance +
            ", size=" + size +
            ", color=" + color +
            '}';
    }
}
