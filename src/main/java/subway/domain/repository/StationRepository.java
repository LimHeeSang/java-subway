package subway.domain.repository;

import subway.domain.model.Station;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StationRepository {

    private static final String ERROR_NOT_EXIST_STATION = "[ERROR] 해당 역을 찾을 수 없습니다.";
    private final List<Station> stations;

    public StationRepository(List<String> stations) {
        this.stations = stations.stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public Station getByName(String name) {
        return stations.stream()
                .filter(station -> station.isEqual(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_EXIST_STATION));
    }

    public void add(Station station) {
        stations.add(station);
    }

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public void deleteByName(String name) {
        stations.removeIf(station -> station.isEqual(name));
    }
}
