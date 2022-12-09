package subway.view;

import java.util.Arrays;

import static subway.view.MainFeature.ERROR_INVALID_FEATURE_NUMBER;

public enum LineFeature {

    STATION_CREATE("1", "노선 등록"),
    STATION_DELETE("2", "노선 삭제"),
    STATION_GET("3", "노선 조회"),
    QUIT("B", "돌아가기");

    private final String number;
    private final String name;

    LineFeature(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static LineFeature from(String number) {
        return Arrays.stream(LineFeature.values())
                .filter(lineFeature -> lineFeature.isEqual(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_FEATURE_NUMBER));
    }

    private boolean isEqual(String number) {
        return this.number.equals(number);
    }
}
