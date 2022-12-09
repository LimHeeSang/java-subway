package subway.view;

import subway.domain.model.dto.LineDto;

import java.util.List;

public class OutputView {

    private static final String MAIN_FEATURE_MESSAGE = "## 메인 화면";
    private static final String STATION_FEATURE_MESSAGE = "## 역 관리 화면";
    private static final String INFO_CREATE_STATION_MESSAGE = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String INFO_DELETE_STATION_MESSAGE = "[INFO] 지하철 역이 삭제되었습니다.";
    private static final String INFO_CREATE_LINE_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.";
    private static final String INFO_DELETE_LINE_MESSAGE = "[INFO] 지하철 노선이 삭제되었습니다.";
    private static final String INFO_CREATE_SECTION_MESSAGE = "[INFO] 구간이 등록되었습니다.";
    private static final String INFO_DELETE_SECTION_MESSAGE = "[INFO] 구간이 삭제되었습니다.";
    private static final String INFO_STATIONS = "[INFO] %s%n";
    private static final String INFO_LINES = "[INFO] %s%n";
    private static final String INFO_SEPARATOR = "[INFO] ---";

    private OutputView() {
    }

    public static void printMainFeature() {
        System.out.println(MAIN_FEATURE_MESSAGE);
        for (MainFeature mainFeature : MainFeature.values()) {
            System.out.println(mainFeature.toString());
        }
        printBlank();
    }

    private static void printBlank() {
        System.out.println();
    }

    public static void printStationFeature() {
        System.out.println(STATION_FEATURE_MESSAGE);
        for (StationFeature stationFeature : StationFeature.values()) {
            System.out.println(stationFeature.toString());
        }
        printBlank();
    }

    public static void printCreateStation() {
        System.out.println(INFO_CREATE_STATION_MESSAGE);
        printBlank();
    }

    public static void printDeleteStation() {
        System.out.println(INFO_DELETE_STATION_MESSAGE);
        printBlank();
    }

    public static void printStations(List<String> stations) {
        for (String station : stations) {
            System.out.printf(INFO_STATIONS, station);
        }
    }

    public static void printLineFeature() {
        System.out.println(MAIN_FEATURE_MESSAGE);
        for (LineFeature lineFeature : LineFeature.values()) {
            System.out.println(lineFeature.toString());
        }
        printBlank();
    }

    public static void printCreateLine() {
        System.out.println(INFO_CREATE_LINE_MESSAGE);
        printBlank();
    }

    public static void printDeleteLine() {
        System.out.println(INFO_DELETE_LINE_MESSAGE);
        printBlank();
    }

    public static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.printf(INFO_LINES, line);
        }
    }

    public static void printSectionFeature() {
        System.out.println(MAIN_FEATURE_MESSAGE);
        for (SectionFeature sectionFeature : SectionFeature.values()) {
            System.out.println(sectionFeature.toString());
        }
        printBlank();
    }

    public static void printCreateSection() {
        System.out.println(INFO_CREATE_SECTION_MESSAGE);
    }

    public static void printDeleteSection() {
        System.out.println(INFO_DELETE_SECTION_MESSAGE);
    }

    public static void printLinesAndStations(List<LineDto> lineDtos) {
        for (LineDto lineDto : lineDtos) {
            String lineName = lineDto.getLineName();

            System.out.printf(INFO_LINES, lineName);
            printStations(lineDto);
        }
    }

    private static void printStations(LineDto lineDto) {
        System.out.println(INFO_SEPARATOR);
        List<String> stations = lineDto.getStations();
        for (String station : stations) {
            System.out.printf(INFO_STATIONS, station);
        }
        printBlank();
    }
}
