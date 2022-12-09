package subway.view;

public class OutputView {

    private static final String MAIN_FEATURE_MESSAGE = "## 메인 화면";

    private OutputView() {
    }

    public static void printMainFeature() {
        System.out.println(MAIN_FEATURE_MESSAGE);
        for (MainFeature mainFeature : MainFeature.values()) {
            System.out.println(mainFeature.toDto());
        }
        printBlank();
    }

    private static void printBlank() {
        System.out.println();
    }
}
