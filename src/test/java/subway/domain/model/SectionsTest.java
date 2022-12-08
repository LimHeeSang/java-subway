package subway.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SectionsTest {

    @Test
    void toDto() {
        Sections sections = new Sections();
        sections.add(new Section(new Station("교대역"), new Station("강남역")));
        sections.add(new Section(new Station("강남역"), new Station("역삼역")));
        sections.add(new Section(new Station("역삼역"), new Station("잠실역")));

        List<String> dtos = sections.toDto();
        assertThat(dtos).containsExactly("교대역", "강남역", "역삼역", "잠실역");
    }
}