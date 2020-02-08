package ru.bfl4t.spsuace.serialization;


import java.io.Serializable;
import java.util.Objects;

enum FoodName {
    APPLES,
    CHICKEN,
    STRAW,
    GRASS,
    PLANKTON,
    BLUEBERRIES,
    ANTS,
    BACON
}

public class Food implements Serializable {

    private FoodName name;
    private double weight;

    Food(FoodName name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(food.weight, weight) == 0 &&
                name == food.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "(" + name + "; " + weight + ")";
    }

}
