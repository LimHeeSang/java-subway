package subway.domain.controller;

import subway.domain.controller.feature.LineFeature;
import subway.domain.service.LineService;
import subway.view.Input.LineInputView;
import subway.view.OutputView;

import java.util.List;

public class LineController implements Controller{

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @Override
    public void run() {
        OutputView.printLineFeature();
        LineFeature lineFeature = LineInputView.inputLineFeature();
        lineFeature.process(this);
    }

    public void createLine() {
        String lineName = LineInputView.inputCreateLineName();
        String upStationName = LineInputView.inputCreateUpStationName();
        String downStationName = LineInputView.inputCreateDownStationName();

        lineService.createLine(lineName, upStationName, downStationName);
        OutputView.printCreateLine();
    }

    public void deleteLine() {
        String deleteLineName = LineInputView.inputDeleteLineName();
        lineService.deleteLine(deleteLineName);
        OutputView.printDeleteLine();
    }

    public void getLines() {
        List<String> lines = lineService.getLines();
        OutputView.printLines(lines);
    }

    public void back() {
    }
}
