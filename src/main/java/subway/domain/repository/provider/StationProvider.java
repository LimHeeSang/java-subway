package subway.domain.repository.provider;

import java.util.List;

public class StationProvider {

    private StationProvider() {
    }

    public static List<String> provide() {
        return List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    }
}
