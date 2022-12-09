package subway.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_CREATE_STATION_NAME_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static MainFeature inputMainFeature() {
        printInputFeatureMessage();
        return MainFeature.from(scanner.nextLine());
    }

    private static void printInputFeatureMessage() {
        System.out.println(INPUT_FEATURE_MESSAGE);
    }

    public static StationFeature inputStationFeature() {
        printInputFeatureMessage();
        return StationFeature.from(scanner.nextLine());
    }

    public static String inputCreateStationName() {
        System.out.println(INPUT_CREATE_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputDeleteStationName() {
        System.out.println(INPUT_DELETE_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static LineFeature inputLineFeature() {
        printInputFeatureMessage();
        return LineFeature.from(scanner.nextLine());
    }
}