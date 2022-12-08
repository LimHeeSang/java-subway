package subway.domain.repository;

import subway.domain.model.Station;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StationRepository {

    private final List<Station> stations;

    public StationRepository(List<String> stations) {
        this.stations = stations.stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }
}
