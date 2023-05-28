package models;

import preprocessors.Filter;

public class CakeKebab extends Kebab {
    private final boolean thickCake;

    public CakeKebab(KebabSize size, double weight, KebabMeat meat, double price, boolean thickCake) {
        super(size, weight, meat, price);
        this.thickCake = thickCake;
    }

    @Override
    public String toString() {
        return "CakeKebab{" + super.toString() + "thickCake=" + thickCake + '}';
    }
}
