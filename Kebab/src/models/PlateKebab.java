package models;

import preprocessors.Filter;

import java.util.Objects;

public class PlateKebab extends Kebab {
    private final KebabAdditives additives;
    private final boolean takeAway;

    public PlateKebab(KebabSize size, double weight, KebabMeat meat, double price, KebabAdditives additives, boolean takeAway) {
        super(size, weight, meat, price);
        this.additives = additives;
        this.takeAway = takeAway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlateKebab that = (PlateKebab) o;
        return takeAway == that.takeAway && additives == that.additives;
    }

    @Override
    public void apply(Filter filter) {
        filter.filter(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), additives, takeAway);
    }

    @Override
    public String toString() {
        return "PlateKebab{" + super.toString() + "additives=" + additives + ", takeAway=" + takeAway + '}';
    }
}
