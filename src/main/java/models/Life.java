package models;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Life {
    private String country;
    private List<Animal> animals;
    private List<Plant> plants;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Life)) {
            return false;
        }

        Life c = (Life) o;
        return this.toString().equals(c.toString());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
