package subway.domain.controller.feature;

import subway.domain.controller.StationController;

import java.util.Arrays;
import java.util.function.Consumer;

import static subway.domain.controller.feature.MainFeature.ERROR_INVALID_FEATURE_NUMBER;

public enum StationFeature {

    STATION_CREATE("1", "역 등록", StationController::createStation),
    STATION_DELETE("2", "역 삭제", StationController::deleteStation),
    STATION_GET("3", "역 조회", StationController::getStations),
    BACK("B", "돌아가기", StationController::back);

    private final String number;
    private final String name;
    private final Consumer<StationController> consumer;

    StationFeature(String number, String name, Consumer<StationController> consumer) {
        this.number = number;
        this.name = name;
        this.consumer = consumer;
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

    public void process(StationController stationController) {
        consumer.accept(stationController);
    }

    public boolean isBack() {
        return this == BACK;
    }

    @Override
    public String toString() {
        return String.format("%s. %s", number, name);
    }
}
