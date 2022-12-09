package subway.domain.controller;

import subway.domain.service.LineService;
import subway.view.InputView;
import subway.view.LineFeature;
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
        LineFeature lineFeature = InputView.inputLineFeature();
        lineFeature.process(this);
    }

    public void createLine() {
        String lineName = InputView.inputCreateLineName();
        String upStationName = InputView.inputCreateUpStationName();
        String downStationName = InputView.inputCreateDownStationName();

        lineService.createLine(lineName, upStationName, downStationName);
        OutputView.printCreateLine();
    }

    public void deleteLine() {
        String deleteLineName = InputView.inputDeleteLineName();
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
