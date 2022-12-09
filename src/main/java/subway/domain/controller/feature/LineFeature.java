package subway.domain.controller.feature;

import subway.domain.controller.LineController;

import java.util.Arrays;
import java.util.function.Consumer;

import static subway.domain.controller.feature.MainFeature.ERROR_INVALID_FEATURE_NUMBER;

public enum LineFeature {

    LINE_CREATE("1", "노선 등록", LineController::createLine),
    LINE_DELETE("2", "노선 삭제", LineController::deleteLine),
    LINE_GET("3", "노선 조회", LineController::getLines),
    BACK("B", "돌아가기", LineController::back);

    private final String number;
    private final String name;
    private final Consumer<LineController> consumer;

    LineFeature(String number, String name, Consumer<LineController> consumer) {
        this.number = number;
        this.name = name;
        this.consumer = consumer;
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

    public void process(LineController lineController) {
        consumer.accept(lineController);
    }

    @Override
    public String toString() {
        return String.format("%s. %s", number, name);
    }
}
