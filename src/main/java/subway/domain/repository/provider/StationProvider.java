package subway.domain.repository.provider;

import subway.domain.model.Station;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StationProvider {

    private StationProvider() {
    }

    public static List<Station> provide() {
        return new LinkedList<>(Arrays.asList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("양재시민의숲역"),
                new Station("매봉역")));
    }
}
