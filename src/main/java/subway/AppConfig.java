package subway;

import subway.domain.controller.LineController;
import subway.domain.controller.LinePrintController;
import subway.domain.controller.SectionController;
import subway.domain.controller.StationController;
import subway.domain.controller.SubwayController;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.domain.repository.provider.LineProvider;
import subway.domain.repository.provider.StationProvider;
import subway.domain.service.LineService;
import subway.domain.service.SectionService;
import subway.domain.service.StationService;

public class AppConfig {

    private AppConfig() {
    }

    public static SubwayController subwayController() {
        return new SubwayController(stationController(), lineController(), sectionController(), linePrintController());
    }

    private static StationController stationController() {
        return new StationController(stationService());
    }

    private static StationService stationService() {
        return new StationService(stationRepository(), lineRepository());
    }

    private static StationRepository stationRepository() {
        return new StationRepository(StationProvider.provide());
    }

    private static LineRepository lineRepository() {
        return new LineRepository(LineProvider.provide());
    }

    private static LineController lineController() {
        return new LineController(lineService());
    }

    private static LineService lineService() {
        return new LineService(stationRepository(), lineRepository());
    }

    private static SectionController sectionController() {
        return new SectionController(sectionService());
    }

    private static SectionService sectionService() {
        return new SectionService(stationRepository(), lineRepository());
    }

    private static LinePrintController linePrintController() {
        return new LinePrintController(lineService());
    }
}
