package subway.domain.model;

import subway.domain.model.dto.LineDto;
import subway.domain.model.validator.LineValidator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private static final String ERROR_INVALID_STATIONS_SIZE = "[ERROR] 역이 2개밖에 없어서 삭제가 불가능합니다.";
    private static final int MINIMUM_STATION_SIZE = 2;
    private static final String ERROR_NOT_EXIST_SECTION_NUMBER = "[ERROR] 없는 구간번호 입니다.";
    private static final int MINIMUM_SECTION_NUMBER = 1;

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

    public void addStation(int sectionNumber, Station station) {
        validateSectionNumber(sectionNumber);
        stations.add(sectionNumber, station);
    }

    private void validateSectionNumber(int sectionNumber) {
        if (sectionNumber >= stations.size() || sectionNumber < MINIMUM_SECTION_NUMBER) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_SECTION_NUMBER);
        }
    }

    public LineDto toDto() {
        return new LineDto(name, mapToName());
    }

    private List<String> mapToName() {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    public void deleteStation(Station station) {
        validateSize();
        getStation(station);
        stations.remove(station);
    }

    private void validateSize() {
        if (stations.size() <= MINIMUM_STATION_SIZE) {
            throw new IllegalStateException(ERROR_INVALID_STATIONS_SIZE);
        }
    }

    private void getStation(Station station) {
        stations.stream()
                .filter(s -> s.equals(station))
                .findFirst()
                .orElseThrow();
    }

    public boolean hasStation(String name) {
        return stations.stream()
                .anyMatch(station -> station.isEqual(name));
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
}
