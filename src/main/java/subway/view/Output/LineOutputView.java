package subway.view.Output;

import subway.domain.controller.feature.LineFeature;

import java.util.List;

public class LineOutputView {

    private static final String INFO_CREATE_LINE_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.";
    private static final String INFO_DELETE_LINE_MESSAGE = "[INFO] 지하철 노선이 삭제되었습니다.";
    public static final String INFO_LINES = "[INFO] %s%n";

    private LineOutputView() {
    }

    public static void printLineFeature() {
        System.out.println(MainOutputView.MAIN_FEATURE_MESSAGE);
        for (LineFeature lineFeature : LineFeature.values()) {
            System.out.println(lineFeature.toString());
        }
        MainOutputView.printBlank();
    }

    public static void printCreateLine() {
        System.out.println(INFO_CREATE_LINE_MESSAGE);
        MainOutputView.printBlank();
    }

    public static void printDeleteLine() {
        System.out.println(INFO_DELETE_LINE_MESSAGE);
        MainOutputView.printBlank();
    }

    public static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.printf(INFO_LINES, line);
        }
    }
}
