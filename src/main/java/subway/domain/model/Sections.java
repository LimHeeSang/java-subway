package subway.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Sections {

    private final List<Section> sections;

    public Sections() {
        this.sections = new ArrayList<>();
    }

    public void add(Section section) {
        sections.add(section);
    }

    public List<String> toDto() {
        System.out.println(sections.size());

        List<String> stations = new ArrayList<>();
        for (int i = 0; i < sections.size(); i++) {
            stations.add(sections.get(i).toLeftDto());
        }
        stations.add(sections.get(sections.size() - 1).toRightDto());
        return stations;
    }
}
