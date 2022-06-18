package java8.stream;

import java.util.Objects;

public class Pokemon {
    private String name;
    private String type;
    private Integer cp; // combat power

    public Pokemon() {}

    public Pokemon(String name, String type, Integer cp) {
        this.name = name;
        this.type = type;
        this.cp = cp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(name, pokemon.name) && Objects.equals(type, pokemon.type) && Objects.equals(cp, pokemon.cp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, cp);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cp=" + cp +
                '}';
    }

}
