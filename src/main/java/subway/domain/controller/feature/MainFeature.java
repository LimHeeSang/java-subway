package subway.domain.controller.feature;

import java.util.Arrays;

public enum MainFeature {

    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    LINE_PRINT("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    public static final String ERROR_INVALID_FEATURE_NUMBER = "[ERROR] 올바른 입력 값이 아닙니다.";
    private final String number;
    private final String name;

    MainFeature(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static MainFeature from(String number) {
        return Arrays.stream(MainFeature.values())
                .filter(mainFeature -> mainFeature.isEqual(number))
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

    public boolean isQuit() {
        return this == QUIT;
    }
}
