package subway.domain.model;

import subway.domain.model.dto.LineDto;
import subway.domain.model.validator.LineValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final String name;
    private final List<Station> stations;

    public Line(String name) {
        this(name, new LinkedList<>());
    }

    public Line(String name, List<Station> stations) {
        LineValidator.validate(name);
        this.name = name;
        this.stations = stations;
    }

    public boolean isEqual(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addStation(int sectionNumber, Station station) {
        stations.add(sectionNumber, station);
    }

    public LineDto toDto() {
        return new LineDto(name, mapToName());
    }

    private List<String> mapToName() {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
