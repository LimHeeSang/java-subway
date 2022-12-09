package subway.view.Input;

import subway.domain.controller.feature.LineFeature;

public class LineInputView {

    private static final String INPUT_CREATE_LINE_NAME_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_CREATE_LINE_UP_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_CREATE_LINE_DOWN_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_DELETE_LINE_NAME_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";

    private LineInputView() {
    }

    public static LineFeature inputLineFeature() {
        MainInputView.printInputFeatureMessage();
        return LineFeature.from(MainInputView.readLine());
    }

    public static String inputCreateLineName() {
        System.out.println(INPUT_CREATE_LINE_NAME_MESSAGE);
        return MainInputView.readLine();
    }

    public static String inputCreateUpStationName() {
        System.out.println(INPUT_CREATE_LINE_UP_STATION_MESSAGE);
        return MainInputView.readLine();
    }

    public static String inputCreateDownStationName() {
        System.out.println(INPUT_CREATE_LINE_DOWN_STATION_MESSAGE);
        return MainInputView.readLine();
    }

    public static String inputDeleteLineName() {
        System.out.println(INPUT_DELETE_LINE_NAME_MESSAGE);
        return MainInputView.readLine();
    }
}
