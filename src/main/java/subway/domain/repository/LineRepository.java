package subway.domain.repository;

import subway.domain.model.Line;

import java.util.Collections;
import java.util.List;

public class LineRepository {

    private static final String ERROR_NOT_EXIST_LINE = "[ERROR] 해당 노선을 찾을 수 없습니다.";
    private static final String ERROR_ALREADY_EXIST_LINE = "[ERROR] 이미 등록되어있는 노선 입니다.";
    private final List<Line> lines;

    public LineRepository(List<Line> lines) {
        this.lines = lines;
    }

    public Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.isEqual(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_EXIST_LINE));
    }

    public void save(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(ERROR_ALREADY_EXIST_LINE);
        }
        lines.add(line);
    }

    public void deleteByName(String name) {
        Line findLine = findByName(name);
        lines.remove(findLine);
    }

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }
}
