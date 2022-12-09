package subway.view.Output;

import subway.domain.model.dto.LineDto;

import java.util.List;

public class LinePrintOutputView {

    private static final String INFO_SEPARATOR = "[INFO] ---";

    private LinePrintOutputView() {
    }

    public static void printLinesAndStations(List<LineDto> lineDtos) {
        for (LineDto lineDto : lineDtos) {
            String lineName = lineDto.getLineName();

            System.out.printf(LineOutputView.INFO_LINES, lineName);
            printStations(lineDto);
        }
    }

    private static void printStations(LineDto lineDto) {
        System.out.println(INFO_SEPARATOR);
        List<String> stations = lineDto.getStations();
        for (String station : stations) {
            System.out.printf(StationOutputView.INFO_STATIONS, station);
        }
        MainOutputView.printBlank();
    }
}
