package subway.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.domain.model.dto.LineDto;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class LineTest {

    @Test
    void 노선에_구간_추가() {
        Line line = new Line("2호선", newArrayList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역")
        ));
        line.addStation(2, new Station("잠실역"));
        LineDto lineDto = line.toDto();

        assertThat(lineDto.getStations()).containsExactly("교대역", "강남역", "잠실역", "역삼역");
    }
}