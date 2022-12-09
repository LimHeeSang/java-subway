package subway.domain.controller;

import subway.domain.controller.feature.StationFeature;
import subway.domain.service.StationService;
import subway.view.Input.StationInputView;
import subway.view.Output.MainOutputView;
import subway.view.Output.StationOutputView;

import java.util.List;

public class StationController implements Controller{

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void run() {
        StationOutputView.printStationFeature();
        StationFeature stationFeature = StationInputView.inputStationFeature();
        stationFeature.process(this);
    }

    public void createStation() {
        String stationName = StationInputView.inputCreateStationName();
        stationService.createStation(stationName);
        StationOutputView.printCreateStation();
    }

    public void deleteStation() {
        String stationName = StationInputView.inputDeleteStationName();
        stationService.deleteStation(stationName);
        StationOutputView.printDeleteStation();
    }

    public void getStations() {
        List<String> stations = stationService.getStations();
        StationOutputView.printStations(stations);
    }

    public void back() {
    }
}
