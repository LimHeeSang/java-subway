package subway.domain.service;

import subway.domain.model.Line;
import subway.domain.model.Station;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    private static final String ERROR_INVALID_LINE_HAS_STATION = "[ERROR] 노선에 등록되어 있는 역은 삭제할 수 없습니다.";

    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public StationService(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public void createStation(String name) {
        Station station = new Station(name);
        stationRepository.save(station);
    }

    public List<String> getStations() {
        List<Station> stations = stationRepository.findAll();
        return mapToName(stations);
    }

    private static List<String> mapToName(List<Station> stations) {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    public void deleteStation(String name) {
        List<Line> lines = lineRepository.findAll();
        for (Line line : lines) {
            validateLineHasStation(line, name);
        }
        stationRepository.deleteByName(name);
    }

    private static void validateLineHasStation(Line line, String name) {
        if (line.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_INVALID_LINE_HAS_STATION);
        }
    }
}
