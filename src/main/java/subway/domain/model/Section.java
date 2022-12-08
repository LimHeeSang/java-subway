package subway.domain.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Section {

    private static final int EXPAND_POSITION_VALUE = 1;

    private final int position;
    private final Station left;
    private final Station right;

    public Section(int position, Station left, Station right) {
        this.position = position;
        this.left = left;
        this.right = right;
    }

    public String toLeftDto() {
        return left.getName();
    }

    public String toRightDto() {
        return right.getName();
    }

    public boolean isEqual(int position) {
        return this.position == position;
    }

    public List<Section> expand(int position, Station station) {
        List<Section> expandSections = new ArrayList<>();
        expandSections.add(new Section(position, this.left, station));
        expandSections.add(new Section(position + EXPAND_POSITION_VALUE, station, this.right));
        return expandSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return position == section.position && Objects.equals(left, section.left) && Objects.equals(right, section.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, left, right);
    }
}
