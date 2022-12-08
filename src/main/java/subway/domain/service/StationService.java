package subway.domain.service;

import subway.domain.model.Station;
import subway.domain.repository.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
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
        stationRepository.deleteByName(name);
    }
}
