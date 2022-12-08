package subway.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.domain.repository.provider.LineProvider;
import subway.domain.repository.provider.StationProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationServiceTest {

    private StationService stationService;

    @BeforeEach
    void setUp() {
        stationService = new StationService(
                new StationRepository(StationProvider.provide()),
                new LineRepository(LineProvider.provide()));
    }

    @Test
    void 역_등록() {
        stationService.createStation("잠실역");
        List<String> stations = stationService.getStations();
        assertThat(stations).containsExactly("교대역", "강남역", "역삼역", "남부터미널역", "양재역",
                "양재시민의숲역", "매봉역", "잠실역");
    }

    @Test
    void 역_삭제() {
        stationService.createStation("삼성역");
        stationService.deleteStation("삼성역");
        List<String> stations = stationService.getStations();
        assertThat(stations).containsExactly("교대역", "강남역", "역삼역", "남부터미널역", "양재역",
                "양재시민의숲역", "매봉역");
    }

    @Test
    void 노선에_등록되어있는_역삭제시_예외발생() {
        assertThatThrownBy(() -> stationService.deleteStation("교대역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 노선에 등록되어 있는 역은 삭제할 수 없습니다.");
    }
}