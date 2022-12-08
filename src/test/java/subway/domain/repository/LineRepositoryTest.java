package subway.domain.repository;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.model.Line;
import subway.domain.repository.provider.LineProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineRepositoryTest {

    @ValueSource(strings = {"2호선", "3호선", "신분당선"})
    @ParameterizedTest
    void 라인_정보_등록_확인(String name) {
        LineRepository stationRepository = new LineRepository(LineProvider.provide());
        List<Line> lines = stationRepository.findAll();
        assertThat(lines).contains(new Line(name));
    }
}