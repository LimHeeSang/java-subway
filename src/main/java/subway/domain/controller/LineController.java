package subway.domain.controller;

import subway.domain.controller.feature.LineFeature;
import subway.domain.service.LineService;
import subway.view.Input.LineInputView;
import subway.view.Output.LineOutputView;
import subway.view.Output.MainOutputView;

import java.util.List;

public class LineController implements Controller{

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @Override
    public void run() {
        LineOutputView.printLineFeature();
        LineFeature lineFeature = LineInputView.inputLineFeature();
        lineFeature.process(this);
    }

    public void createLine() {
        String lineName = LineInputView.inputCreateLineName();
        String upStationName = LineInputView.inputCreateUpStationName();
        String downStationName = LineInputView.inputCreateDownStationName();

        lineService.createLine(lineName, upStationName, downStationName);
        LineOutputView.printCreateLine();
    }

    public void deleteLine() {
        String deleteLineName = LineInputView.inputDeleteLineName();
        lineService.deleteLine(deleteLineName);
        LineOutputView.printDeleteLine();
    }

    public void getLines() {
        List<String> lines = lineService.getLines();
        LineOutputView.printLines(lines);
    }

    public void back() {
    }
}
