package subway.view.Output;

import subway.domain.controller.feature.MainFeature;

public class MainOutputView {

    public static final String MAIN_FEATURE_MESSAGE = "## 메인 화면";

    private MainOutputView() {
    }

    public static void printMainFeature() {
        System.out.println(MAIN_FEATURE_MESSAGE);
        for (MainFeature mainFeature : MainFeature.values()) {
            System.out.println(mainFeature.toString());
        }
        printBlank();
    }

    public static void printBlank() {
        System.out.println();
    }
}
