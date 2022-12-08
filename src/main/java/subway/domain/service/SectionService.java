package subway.domain.service;

import subway.domain.model.Line;
import subway.domain.model.Station;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;

public class SectionService {

    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public SectionService(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public void createSection(String lineName, String stationName, int position) {
        Line line = lineRepository.findByName(lineName);
        Station station = stationRepository.findByName(stationName);
        line.addStation(position, station);
    }
}
