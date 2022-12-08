package subway.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.model.Station;
import subway.domain.repository.provider.StationProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationRepositoryTest {

    private StationRepository stationRepository;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository(StationProvider.provide());
    }

    @ValueSource(strings = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"})
    @ParameterizedTest
    void 역_초기화_정보_등록_확인(String name) {
        List<Station> stations = stationRepository.findAll();
        assertThat(stations).contains(new Station(name));
    }

    @Test
    void 역_등록() {
        stationRepository.add(new Station("서울역"));
        Station findStation = stationRepository.getByName("서울역");
        assertThat(findStation).isEqualTo(new Station("서울역"));
    }

    @Test
    void 역_삭제() {
        stationRepository.deleteByName("역삼역");
        assertThatThrownBy(() -> stationRepository.getByName("역삼역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 역을 찾을 수 없습니다.");
    }
}