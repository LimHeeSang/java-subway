package subway.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_CREATE_STATION_NAME_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_CREATE_LINE_NAME_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_CREATE_LINE_UP_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_CREATE_LINE_DOWN_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_DELETE_LINE_NAME_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String INPUT_CREATE_SECTION_LINE_NAME_MESSAGE = "## 노선을 입력하세요.";
    private static final String INPUT_CREATE_SECTION_STATION_NAME = "## 역이름을 입력하세요.";
    private static final String INPUT_CREATE_SECTION_POSITION = "## 순서를 입력하세요.";
    private static final String INPUT_DELETE_SECTION_LINE_NAME_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_DELETE_SECTION_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
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

    public static String inputCreateLineName() {
        System.out.println(INPUT_CREATE_LINE_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputCreateUpStationName() {
        System.out.println(INPUT_CREATE_LINE_UP_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputCreateDownStationName() {
        System.out.println(INPUT_CREATE_LINE_DOWN_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputDeleteLineName() {
        System.out.println(INPUT_DELETE_LINE_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static SectionFeature inputSectionFeature() {
        printInputFeatureMessage();
        return SectionFeature.from(scanner.nextLine());
    }

    public static String inputCreateSectionLineName() {
        System.out.println(INPUT_CREATE_SECTION_LINE_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputCreateSectionStationName() {
        System.out.println(INPUT_CREATE_SECTION_STATION_NAME);
        return scanner.nextLine();
    }

    public static int inputCreateSectionPosition() {
        System.out.println(INPUT_CREATE_SECTION_POSITION);
        String position = scanner.nextLine();
        return Integer.parseInt(position);
    }

    public static String inputDeleteSectionLineName() {
        System.out.println(INPUT_DELETE_SECTION_LINE_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputDeleteSectionStationName() {
        System.out.println(INPUT_DELETE_SECTION_STATION_NAME);
        return scanner.nextLine();
    }
}
