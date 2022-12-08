package subway.domain.repository;

import subway.domain.model.Line;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LineRepository {

    private static final String ERROR_NOT_EXIST_LINE = "[ERROR] 해당 노선을 찾을 수 없습니다.";
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
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_EXIST_LINE));
    }

    public void deleteByName(String name) {
        lines.removeIf(line -> line.isEqual(name));
    }
}
