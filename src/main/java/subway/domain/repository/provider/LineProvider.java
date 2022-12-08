package subway.domain.repository.provider;

import subway.domain.model.Line;
import subway.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

public class LineProvider {

    private LineProvider() {
    }

    public static List<Line> provide() {
        return new ArrayList<>(List.of(
                new Line("2호선", createTwoLineStations()),
                new Line("3호선", createThreeLineStations()),
                new Line("신분당선", createSinbundangStations())));
    }

    private static List<Station> createTwoLineStations() {
        return List.of(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역")
        );
    }

    private static List<Station> createThreeLineStations() {
        return List.of(
                new Station("교대역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역")
        );
    }

    private static List<Station> createSinbundangStations() {
        return List.of(
                new Station("강남역"),
                new Station("양재역"),
                new Station("양재시민의숲역")
        );
    }
}
