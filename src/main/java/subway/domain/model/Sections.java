package subway.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sections {

    private static final String ERROR_NOT_EXIST_SECTION = "[ERROR] 해당 번호는 없는 구간입니다.";
    private static final int CRITERION_START_OR_END_SIZE = 1;
    private static final int CRITERION_MID_SIZE = 2;
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
        List<Section> filterSections = filterSectionHasStation(station);
        if (isStartOrEnd(filterSections)) {
            deleteStartOrEndStation(filterSections);
        }
        if (isMid(filterSections)) {
            deleteMidStation(filterSections);
        }
    }

    private boolean isStartOrEnd(List<Section> filterSection) {
        return filterSection.size() == CRITERION_START_OR_END_SIZE;
    }

    private boolean isMid(List<Section> filterSection) {
        return filterSection.size() == CRITERION_MID_SIZE;
    }

    private void deleteStartOrEndStation(List<Section> filterSections) {
        Section section = filterSections.get(0);
        sections.remove(section);
        if (section.isStart()) {
            decreasePositions();
        }
    }

    private void decreasePositions() {
        for (Section section : sections) {
            section.decreasePosition();
        }
    }

    private void deleteMidStation(List<Section> filterSections) {
        Section section = filterSections.get(0);
        Section otherSection = filterSections.get(1);

        sections.remove(section);
        sections.remove(otherSection);

        Section combineSection = section.combine(otherSection);
        sections.add(combineSection);
    }

    private List<Section> filterSectionHasStation(String station) {
        return sections.stream()
                .filter(section -> section.hasStation(station))
                .collect(Collectors.toList());
    }
}
