package subway.domain.repository;

import java.util.List;

public class StationGenerator {

    private StationGenerator() {
    }

    public static List<String> generate() {
        return List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    }
}
