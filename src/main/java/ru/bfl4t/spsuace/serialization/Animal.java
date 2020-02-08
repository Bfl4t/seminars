package ru.bfl4t.spsuace.serialization;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

enum AnimalType {
    MAMMAL,
    INSECT,
    BIRD,
    FISH,
    REPTILE,
    AMPHIBIAN,
    ARTHROPOD
}

public class Animal implements Serializable {

    private List<Food> foodList;
    private AnimalType type;
    String name;
    Integer age;

    public Animal(List<Food> foodList, AnimalType type, String name, Integer age) {
        this.foodList = foodList;
        this.type = type;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(foodList, animal.foodList) &&
                type == animal.type &&
                Objects.equals(name, animal.name) &&
                Objects.equals(age, animal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodList, type, name, age);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type: " + type + "\n");
        stringBuilder.append("Name: " + name + "\n");
        stringBuilder.append("age: " + age + "\n");
        stringBuilder.append("Food list: ");
        for(Food food : foodList) {
            stringBuilder.append(food.toString() + "; ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

}
