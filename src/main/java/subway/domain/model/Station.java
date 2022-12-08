package subway.domain.model;

import java.util.Objects;

public class Station {

    private static final String ERROR_INVALID_STATION_NAME = "[ERROR] 역이름은 2글자 이상이어야 합니다.";
    private static final int LIMIT_MINIMUM_STATION_NAME_SIZE = 2;

    private String name;

    public Station(String name) {
        validateLength(name);
        this.name = name;
    }

    private static void validateLength(String name) {
        if (name.length() <= LIMIT_MINIMUM_STATION_NAME_SIZE) {
            throw new IllegalArgumentException(ERROR_INVALID_STATION_NAME);
        }
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
}
