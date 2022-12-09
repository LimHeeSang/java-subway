package subway.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static MainFeature inputMainFeature() {
        return MainFeature.from(scanner.nextLine());
    }
}
