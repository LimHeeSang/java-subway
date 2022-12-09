package subway.domain.controller;

import subway.domain.controller.feature.StationFeature;
import subway.domain.service.StationService;
import subway.view.Input.StationInputView;
import subway.view.OutputView;

import java.util.List;

public class StationController implements Controller{

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void run() {
        OutputView.printStationFeature();
        StationFeature stationFeature = StationInputView.inputStationFeature();
        stationFeature.process(this);
    }

    public void createStation() {
        String stationName = StationInputView.inputCreateStationName();
        stationService.createStation(stationName);
        OutputView.printCreateStation();
    }

    public void deleteStation() {
        String stationName = StationInputView.inputDeleteStationName();
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
