package subway;

import subway.domain.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        SubwayController subwayController = AppConfig.subwayController();
        subwayController.run();
    }
}
