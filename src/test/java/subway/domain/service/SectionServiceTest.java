package subway.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.model.Line;
import subway.domain.model.Station;
import subway.domain.model.dto.LineDto;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.domain.repository.provider.LineProvider;
import subway.domain.repository.provider.StationProvider;

import static org.assertj.core.api.Assertions.*;

class SectionServiceTest {

    private SectionService sectionService;
    private StationRepository stationRepository;
    private LineRepository lineRepository;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository(StationProvider.provide());
        lineRepository = new LineRepository(LineProvider.provide());

        sectionService = new SectionService(stationRepository, lineRepository);
    }

    @Test
    void 구간_등록() {
        stationRepository.save(new Station("잠실역"));

        sectionService.createSection("2호선", "잠실역", 2);
        Line line = lineRepository.findByName("2호선");
        LineDto lineDto = line.toDto();

        assertThat(lineDto.getName()).isEqualTo("2호선");
        assertThat(lineDto.getStations()).containsExactly("교대역", "강남역", "잠실역", "역삼역");
    }

    @Test
    void 구간_삭제() {
        sectionService.deleteSection("2호선", "강남역");

        Line line = lineRepository.findByName("2호선");
        LineDto lineDto = line.toDto();

        assertThat(lineDto.getName()).isEqualTo("2호선");
        assertThat(lineDto.getStations()).containsExactly("교대역", "역삼역");
    }
}