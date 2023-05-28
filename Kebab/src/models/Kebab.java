package models;

import preprocessors.Filter;

import java.util.Objects;

public class Kebab {
    private final KebabSize size;
    private final double weight;
    private final KebabMeat meat;
    private final double price;

    public Kebab(KebabSize size, double weight, KebabMeat meat, double price) {
        this.size = size;
        this.weight = weight;
        this.meat = meat;
        this.price = price;
    }

    public void apply(Filter filter) {
    }

    public KebabSize getSize() {
        return size;
    }

    public KebabMeat getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kebab kebab = (Kebab) o;
        return Double.compare(kebab.weight, weight) == 0 && Double.compare(kebab.price, price) == 0 && size == kebab.size && meat == kebab.meat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, weight, meat, price);
    }

    @Override
    public String toString() {
        return "size=" + size + ", weight=" + weight + ", meat=" + meat + ", price=" + price;
    }
}
