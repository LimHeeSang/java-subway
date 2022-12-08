package subway.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.model.dto.LineDto;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.domain.repository.provider.LineProvider;
import subway.domain.repository.provider.StationProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineServiceTest {

    private LineService lineService;

    @BeforeEach
    void setUp() {
        lineService = new LineService(
                new StationRepository(StationProvider.provide()),
                new LineRepository(LineProvider.provide())
        );
    }

    @Test
    void 노선_등록() {
        lineService.createLine("1호선", "신창역", "서울역");
        List<LineDto> lines = lineService.getLines();
        assertThat(lines.get(3).getName()).isEqualTo("1호선");
        assertThat(lines.get(3).getStations()).containsExactly("신창역", "서울역");
    }

    @Test
    void 이미있는_노선이름일시_예외발생() {
        assertThatThrownBy(() -> lineService.createLine("2호선", "신창역", "서울역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 노선_삭제() {
        lineService.deleteLine("2호선");
        List<LineDto> lines = lineService.getLines();
        assertThat(lines.size()).isEqualTo(2);
    }
}
