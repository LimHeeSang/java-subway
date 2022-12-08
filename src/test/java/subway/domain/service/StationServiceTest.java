package subway.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.repository.StationRepository;
import subway.domain.repository.provider.StationProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {

    private StationService stationService;

    @BeforeEach
    void setUp() {
        stationService = new StationService(new StationRepository(StationProvider.provide()));
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
}