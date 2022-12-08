package subway.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sections {

    private static final String ERROR_NOT_EXIST_SECTION = "[ERROR] 해당 번호는 없는 구간입니다.";
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
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_EXIST_SECTION));
    }

    public void deleteStation(String station) {
        List<Section> filterSection = filterSectionHas(station);

        Section section = filterSection.get(0);
        Section otherSection = filterSection.get(1);
        sections.remove(section);
        sections.remove(otherSection);

        Section combineSection = section.combine(otherSection);
        sections.add(combineSection);
    }

    private List<Section> filterSectionHas(String station) {
        return sections.stream()
                .filter(section -> section.hasStation(station))
                .collect(Collectors.toList());
    }
}
