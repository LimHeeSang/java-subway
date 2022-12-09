package subway;

import subway.domain.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = AppConfig.subwayController();
        mainController.run();
    }
}
