package subway;

import org.junit.jupiter.api.Test;
import subway.view.Output.MainOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LearningTest {

    @Test
    void list_test() {
        List<String> stations = new ArrayList<>();

        stations.addAll(Arrays.asList("교대역", "강남역", "역삼역"));
        stations.add(1, "잠실역");
        assertThat(stations).containsExactly("교대역", "잠실역", "강남역", "역삼역");
    }

    @Test
    void printMainFeature() {
        MainOutputView.printMainFeature();
    }
}
