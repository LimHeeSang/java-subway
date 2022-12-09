package subway.domain.controller;

import subway.domain.service.SectionService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.domain.controller.feature.SectionFeature;

public class SectionController implements Controller{

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public void run() {
        OutputView.printSectionFeature();
        SectionFeature sectionFeature = InputView.inputSectionFeature();
        sectionFeature.process(this);
    }

    public void createSection() {
        String lineName = InputView.inputCreateSectionLineName();
        String stationName = InputView.inputCreateSectionStationName();
        int position = InputView.inputCreateSectionPosition();

        sectionService.createSection(lineName, stationName, position);
        OutputView.printCreateSection();
    }

    public void deleteSection() {
        String lineName = InputView.inputDeleteSectionLineName();
        String stationName = InputView.inputDeleteSectionStationName();

        sectionService.deleteSection(lineName, stationName);
        OutputView.printDeleteSection();
    }

    public void back() {
    }
}
