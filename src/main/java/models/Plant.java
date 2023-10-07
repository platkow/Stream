package models;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Plant {
    private String species;
    private double standardHigh;
    private String fruitName;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Plant plant)) return false;

        return this.toString().equals(plant.toString());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
