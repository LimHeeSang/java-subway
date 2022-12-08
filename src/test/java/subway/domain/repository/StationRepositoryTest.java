package subway.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.model.Station;

import java.util.List;

class StationRepositoryTest {

    @ValueSource(strings = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"})
    @ParameterizedTest
    void 역_정보_등록_확인(String name) {
        StationRepository stationRepository = new StationRepository(StationGenerator.generate());
        List<Station> stations = stationRepository.findAll();
        Assertions.assertThat(stations).contains(new Station(name));
    }
}