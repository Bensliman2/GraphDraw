package models;

/**
 * Created by sherxon on 1/7/17.
 */
public class Edge1 implements Comparable<Edge1> {
    private Double weight;
    private Integer from;
    private Integer to;

    public Edge1(Double weight) {
        this.weight = weight;
    }

    public Edge1(Integer from, Integer to, Double weight) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge1 edge = (Edge1) o;

        if (weight != null ? !weight.equals(edge.weight) : edge.weight != null) return false;
        if (from != null ? !from.equals(edge.from) : edge.from != null) return false;
        return !(to != null ? !to.equals(edge.to) : edge.to != null);

    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public int hashCode() {
        int result = weight != null ? weight.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public int compareTo(Edge1 o) {
        return (int) (this.weight - o.weight);
    }
}
