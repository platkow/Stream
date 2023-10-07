package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Animal {

    private String species;
    private int numberOfLegs;
    private boolean venomous;

    @Override
    public String toString() {
        return "Animal " +
                "species='" + species + '\'' +
                ", numberOfLegs=" + numberOfLegs +
                ", venomous=" + venomous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Animal animal)) return false;

        return this.toString().equals(animal.toString());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
