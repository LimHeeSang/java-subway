package subway.view;

import java.util.Arrays;

import static subway.view.MainFeature.ERROR_INVALID_FEATURE_NUMBER;

public enum StationFeature {

    STATION_CREATE("1", "역 등록"),
    STATION_DELETE("2", "역 삭제"),
    STATION_GET("3", "역 조회"),
    QUIT("B", "돌아가기");

    private final String number;
    private final String name;

    StationFeature(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static StationFeature from(String number) {
        return Arrays.stream(StationFeature.values())
                .filter(stationFeature -> stationFeature.isEqual(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_FEATURE_NUMBER));
    }

    private boolean isEqual(String number) {
        return this.number.equals(number);
    }

    @Override
    public String toString() {
        return String.format("%s. %s", number, name);
    }
}
