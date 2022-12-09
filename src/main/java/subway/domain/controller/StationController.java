package subway.domain.controller;

import subway.domain.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.domain.controller.feature.StationFeature;

import java.util.List;

public class StationController implements Controller{

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void run() {
        OutputView.printStationFeature();
        StationFeature stationFeature = InputView.inputStationFeature();
        stationFeature.process(this);
    }

    public void createStation() {
        String stationName = InputView.inputCreateStationName();
        stationService.createStation(stationName);
        OutputView.printCreateStation();
    }

    public void deleteStation() {
        String stationName = InputView.inputDeleteStationName();
        stationService.deleteStation(stationName);
        OutputView.printDeleteStation();
    }

    public void getStations() {
        List<String> stations = stationService.getStations();
        OutputView.printStations(stations);
    }

    public void back() {
    }
}
