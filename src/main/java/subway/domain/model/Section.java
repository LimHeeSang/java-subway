package subway.domain.model;

import java.util.Objects;

public class Section {

    private final Station left;
    private final Station right;

    public Section(Station left, Station right) {
        this.left = left;
        this.right = right;
    }

    public String toLeftDto() {
        return left.getName();
    }

    public String toRightDto() {
        return right.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(left, section.left) && Objects.equals(right, section.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
