package subway.view.Output;

import subway.domain.controller.feature.StationFeature;

import java.util.List;

public class StationOutputView {

    private static final String STATION_FEATURE_MESSAGE = "## 역 관리 화면";
    private static final String INFO_CREATE_STATION_MESSAGE = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String INFO_DELETE_STATION_MESSAGE = "[INFO] 지하철 역이 삭제되었습니다.";
    public static final String INFO_STATIONS = "[INFO] %s%n";

    private StationOutputView() {
    }

    public static void printStationFeature() {
        System.out.println(STATION_FEATURE_MESSAGE);
        for (StationFeature stationFeature : StationFeature.values()) {
            System.out.println(stationFeature.toString());
        }
        MainOutputView.printBlank();
    }

    public static void printCreateStation() {
        System.out.println(INFO_CREATE_STATION_MESSAGE);
        MainOutputView.printBlank();
    }

    public static void printDeleteStation() {
        System.out.println(INFO_DELETE_STATION_MESSAGE);
        MainOutputView.printBlank();
    }

    public static void printStations(List<String> stations) {
        for (String station : stations) {
            System.out.printf(INFO_STATIONS, station);
        }
    }
}
