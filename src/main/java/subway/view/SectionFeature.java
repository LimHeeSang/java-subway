package subway.view;

import java.util.Arrays;

import static subway.view.MainFeature.ERROR_INVALID_FEATURE_NUMBER;

public enum SectionFeature {

    SECTION_CREATE("1", "구간 등록"),
    SECTION_DELETE("2", "구간 삭제"),
    QUIT("B", "돌아가기");

    private final String number;
    private final String name;

    SectionFeature(String number, String name) {
        this.number = number;
        this.name = name;
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
}
