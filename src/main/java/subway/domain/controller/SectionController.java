package subway.domain.controller;

import subway.domain.controller.feature.SectionFeature;
import subway.domain.service.SectionService;
import subway.view.Input.SectionInputView;
import subway.view.OutputView;

public class SectionController implements Controller{

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public void run() {
        OutputView.printSectionFeature();
        SectionFeature sectionFeature = SectionInputView.inputSectionFeature();
        sectionFeature.process(this);
    }

    public void createSection() {
        String lineName = SectionInputView.inputCreateSectionLineName();
        String stationName = SectionInputView.inputCreateSectionStationName();
        int position = SectionInputView.inputCreateSectionPosition();

        sectionService.createSection(lineName, stationName, position);
        OutputView.printCreateSection();
    }

    public void deleteSection() {
        String lineName = SectionInputView.inputDeleteSectionLineName();
        String stationName = SectionInputView.inputDeleteSectionStationName();

        sectionService.deleteSection(lineName, stationName);
        OutputView.printDeleteSection();
    }

    public void back() {
    }
}
