package subway.domain.model.dto;

import java.util.List;

public class LineDto {

    private final String name;
    private final List<String> stations;

    public LineDto(String name, List<String> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return stations;
    }
}
