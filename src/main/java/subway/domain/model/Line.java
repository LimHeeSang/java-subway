package subway.domain.model;

import subway.domain.model.dto.LineDto;
import subway.domain.model.validator.LineValidator;

import java.util.List;
import java.util.Objects;

public class Line {

    private final String name;
    private final Sections sections;

    public Line(String name) {
        LineValidator.validate(name);
        this.name = name;
        this.sections = new Sections();
    }

    public boolean isEqual(String name) {
        return this.name.equals(name);
    }

    public void createSections(List<Station> stations) {
        for (int i = 0; i < stations.size() - 1; i++) {
            sections.add(new Section(i + 1, stations.get(i), stations.get(i + 1)));
        }
    }

    public void addSection(int position, Station station) {
        sections.addSection(position, station);
    }

    public void deleteStation(String station) {
        sections.deleteStation(station);
    }

    public LineDto toDto() {
        return new LineDto(name, sections.toDto());
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
