package subway.view.Input;

import subway.domain.controller.feature.SectionFeature;

public class SectionInputView {

    private static final String INPUT_CREATE_SECTION_LINE_NAME_MESSAGE = "## 노선을 입력하세요.";
    private static final String INPUT_CREATE_SECTION_STATION_NAME = "## 역이름을 입력하세요.";
    private static final String INPUT_CREATE_SECTION_POSITION = "## 순서를 입력하세요.";
    private static final String INPUT_DELETE_SECTION_LINE_NAME_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_DELETE_SECTION_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";

    private SectionInputView() {
    }

    public static SectionFeature inputSectionFeature() {
        MainInputView.printInputFeatureMessage();
        return SectionFeature.from(MainInputView.readLine());
    }

    public static String inputCreateSectionLineName() {
        System.out.println(INPUT_CREATE_SECTION_LINE_NAME_MESSAGE);
        return MainInputView.readLine();
    }

    public static String inputCreateSectionStationName() {
        System.out.println(INPUT_CREATE_SECTION_STATION_NAME);
        return MainInputView.readLine();
    }

    public static int inputCreateSectionPosition() {
        System.out.println(INPUT_CREATE_SECTION_POSITION);
        String position = MainInputView.readLine();
        return Integer.parseInt(position);
    }

    public static String inputDeleteSectionLineName() {
        System.out.println(INPUT_DELETE_SECTION_LINE_NAME_MESSAGE);
        return MainInputView.readLine();
    }

    public static String inputDeleteSectionStationName() {
        System.out.println(INPUT_DELETE_SECTION_STATION_NAME);
        return MainInputView.readLine();
    }
}
