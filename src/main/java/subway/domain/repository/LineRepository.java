package subway.domain.repository;

import subway.domain.model.Line;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LineRepository {

    private final List<Line> lines;

    public LineRepository(List<String> lines) {
        this.lines = lines.stream()
                .map(Line::new)
                .collect(Collectors.toList());
    }

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public void add(Line line) {
        lines.add(line);
    }

    public Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.isEqual(name))
                .findFirst()
                .orElseThrow();
    }
}
