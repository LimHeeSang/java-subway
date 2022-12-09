package subway.domain.controller;

import subway.domain.model.dto.LineDto;
import subway.domain.service.LineService;
import subway.view.Output.LinePrintOutputView;
import subway.view.Output.MainOutputView;

import java.util.List;

public class LinePrintController implements Controller{

    private final LineService lineService;

    public LinePrintController(LineService lineService) {
        this.lineService = lineService;
    }

    @Override
    public void run() {
        List<LineDto> lineDtos = lineService.getLinesAndStations();
        LinePrintOutputView.printLinesAndStations(lineDtos);
    }
}
