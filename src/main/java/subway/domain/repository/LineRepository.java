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
}
