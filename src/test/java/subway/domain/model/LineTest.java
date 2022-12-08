package subway.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.model.dto.LineDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class LineTest {

    private Line twoLine;
    private Line threeLine;

    @BeforeEach
    void setUp() {
        twoLine = new Line("2호선", newArrayList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역")
        ));

        threeLine = new Line("3호선", newArrayList(
                new Station("교대역"), new Station("남부터미널역"),
                new Station("양재역"), new Station("매봉역")));
    }

    @Test
    void 노선에_구간_추가() {
        twoLine.addStation(2, new Station("잠실역"));
        LineDto lineDto = twoLine.toDto();

        assertThat(lineDto.getName()).isEqualTo("2호선");
        assertThat(lineDto.getStations()).containsExactly("교대역", "강남역", "잠실역", "역삼역");
    }

    @Test
    void 하나의_역은_여러개의_노선에_추가가능() {
        Station station = new Station("잠실역");
        twoLine.addStation(2, station);
        threeLine.addStation(1, station);

        LineDto lineDto = threeLine.toDto();
        assertThat(lineDto.getStations()).containsExactly("교대역", "잠실역", "남부터미널역", "양재역", "매봉역");
    }

    @Test
    void 구간_삭제_기능() {
        threeLine.deleteStation(new Station("남부터미널역"));
        LineDto lineDto = threeLine.toDto();

        assertThat(lineDto.getStations()).containsExactly("교대역", "양재역", "매봉역");
    }

    @Test
    void 시작점을_제거할경우_다음역이_시작점() {
        threeLine.deleteStation(new Station("교대역"));
        LineDto lineDto = threeLine.toDto();

        assertThat(lineDto.getStations()).containsExactly("남부터미널역", "양재역", "매봉역");
    }

    @Test
    void 종착점을_제거할경우_다음역이_종착점() {
        threeLine.deleteStation(new Station("매봉역"));
        LineDto lineDto = threeLine.toDto();

        assertThat(lineDto.getStations()).containsExactly("교대역", "남부터미널역", "양재역");
    }

    @Test
    void 노선에_포함된역이_두개이하일때_제거하면_예외발생() {
        Line line = new Line("2호선", newArrayList(new Station("강남역"), new Station("역삼역")));
        assertThatThrownBy(() -> line.deleteStation(new Station("강남역")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 역이 2개밖에 없어서 삭제가 불가능합니다.");
    }

    @Test
    void 마지막_구간번호보다_클_경우_예외발생() {
        assertThatThrownBy(() -> threeLine.addStation(4, new Station("잠실역")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 없는 구간번호 입니다.");
    }

    @Test
    void 구간번호가_0일경우_예외발생() {
        assertThatThrownBy(() -> threeLine.addStation(0, new Station("잠실역")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 없는 구간번호 입니다.");
    }

    @Test
    void 해당노선에_없는역_삭제시도시_예외발생() {
        assertThatThrownBy(() -> threeLine.deleteStation(new Station("강남역")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 노선에서 해당 역은 없습니다.");
    }
}