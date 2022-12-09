package subway.view.Input;

import subway.domain.controller.feature.StationFeature;

public class StationInputView {

    private static final String INPUT_CREATE_STATION_NAME_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME_MESSAGE = "## 삭제할 역 이름을 입력하세요.";

    private StationInputView() {
    }

    public static StationFeature inputStationFeature() {
        MainInputView.printInputFeatureMessage();
        return StationFeature.from(MainInputView.readLine());
    }

    public static String inputCreateStationName() {
        System.out.println(INPUT_CREATE_STATION_NAME_MESSAGE);
        return MainInputView.readLine();
    }

    public static String inputDeleteStationName() {
        System.out.println(INPUT_DELETE_STATION_NAME_MESSAGE);
        return MainInputView.readLine();
    }
}
