package subway.domain.model.validator;

public class StationValidator {

    private static final String ERROR_INVALID_STATION_NAME = "[ERROR] 역이름은 2글자 이상이어야 합니다.";
    private static final int LIMIT_MINIMUM_STATION_NAME_SIZE = 2;
    private static final String ERROR_INVALID_STATION_NAME_SUFFIX = "[ERROR] 역 이름은 역으로 끝나야 합니다.";
    private static final String STATION_NAME_SUFFIX = "역";
    private static final int STATION_NAME_SUFFIX_SIZE = 1;

    private StationValidator() {
    }

    public static void validate(String name) {
        validateSuffix(name);
        validateLength(name);
    }

    private static void validateSuffix(String name) {
        String last = name.substring(name.length() - STATION_NAME_SUFFIX_SIZE);
        if (!last.equals(STATION_NAME_SUFFIX)) {
            throw new IllegalArgumentException(ERROR_INVALID_STATION_NAME_SUFFIX);
        }
    }

    private static void validateLength(String name) {
        if (name.length() <= LIMIT_MINIMUM_STATION_NAME_SIZE) {
            throw new IllegalArgumentException(ERROR_INVALID_STATION_NAME);
        }
    }
}
