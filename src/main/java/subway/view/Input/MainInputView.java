package subway.view.Input;

import subway.domain.controller.feature.MainFeature;

import java.util.Scanner;

public class MainInputView {

    private static final String INPUT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private MainInputView() {
    }

    public static MainFeature inputMainFeature() {
        printInputFeatureMessage();
        return MainFeature.from(readLine());
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static void printInputFeatureMessage() {
        System.out.println(INPUT_FEATURE_MESSAGE);
    }
}
