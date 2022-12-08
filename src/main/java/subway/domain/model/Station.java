package subway.domain.model;

import subway.domain.model.validator.StationValidator;

import java.util.Objects;

public class Station {

    private String name;

    public Station(String name) {
        StationValidator.validate(name);
        this.name = name;
    }

    public boolean isEqual(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
