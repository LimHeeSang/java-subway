package subway.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.model.Line;
import subway.domain.repository.provider.LineProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineRepositoryTest {

    private LineRepository lineRepository;

    @BeforeEach
    void setUp() {
        lineRepository = new LineRepository(LineProvider.provide());
    }

    @ValueSource(strings = {"2호선", "3호선", "신분당선"})
    @ParameterizedTest
    void 노선_초기화_정보_등록_확인(String name) {
        List<Line> lines = lineRepository.findAll();
        assertThat(lines).contains(new Line(name));
    }

    @Test
    void 노선_등록() {
        lineRepository.add(new Line("1호선"));
        Line findLine = lineRepository.findByName("1호선");
        assertThat(findLine).isEqualTo(new Line("1호선"));
    }

    @Test
    void 노선_삭제() {
        lineRepository.deleteByName("2호선");
        assertThatThrownBy(() -> lineRepository.findByName("2호선"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 노선을 찾을 수 없습니다.");
    }
}