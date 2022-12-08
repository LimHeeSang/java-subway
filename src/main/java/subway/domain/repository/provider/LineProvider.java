package subway.domain.repository.provider;

import java.util.List;

public class LineProvider {

    private LineProvider() {
    }

    public static List<String> provide() {
        return List.of("2호선", "3호선", "신분당선");
    }
}
