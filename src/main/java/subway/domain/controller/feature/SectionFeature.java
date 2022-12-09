package subway.domain.controller.feature;

import subway.domain.controller.SectionController;

import java.util.Arrays;
import java.util.function.Consumer;

import static subway.domain.controller.feature.MainFeature.ERROR_INVALID_FEATURE_NUMBER;

public enum SectionFeature {

    SECTION_CREATE("1", "구간 등록", SectionController::createSection),
    SECTION_DELETE("2", "구간 삭제", SectionController::deleteSection),
    QUIT("B", "돌아가기", SectionController::back);

    private final String number;
    private final String name;
    private final Consumer<SectionController> consumer;

    SectionFeature(String number, String name, Consumer<SectionController> consumer) {
        this.number = number;
        this.name = name;
        this.consumer = consumer;
    }

    public static SectionFeature from(String number) {
        return Arrays.stream(SectionFeature.values())
                .filter(sectionFeature -> sectionFeature.isEqual(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_FEATURE_NUMBER));
    }

    private boolean isEqual(String number) {
        return this.number.equals(number);
    }

    public void process(SectionController sectionController) {
        consumer.accept(sectionController);
    }

    @Override
    public String toString() {
        return String.format("%s. %s", number, name);
    }
}
