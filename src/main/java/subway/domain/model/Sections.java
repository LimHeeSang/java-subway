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
        List<String> stations = new ArrayList<>();
        for (int i = 0; i < sections.size(); i++) {
            stations.add(sections.get(i).toLeftDto());
        }
        stations.add(sections.get(sections.size() - 1).toRightDto());
        return stations;
    }

    public void addSection(int position, Station station) {
        Section section = getSection(position);
        sections.remove(section);
        List<Section> expandSections = section.expand(position, station);
        sections.addAll(expandSections);
    }

    private Section getSection(int position) {
        return sections.stream()
                .filter(section -> section.isEqual(position))
                .findFirst()
                .orElseThrow();
    }
}
