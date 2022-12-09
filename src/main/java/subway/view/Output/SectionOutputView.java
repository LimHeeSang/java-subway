package subway.view.Output;

import subway.domain.controller.feature.SectionFeature;

public class SectionOutputView {

    private static final String INFO_CREATE_SECTION_MESSAGE = "[INFO] 구간이 등록되었습니다.";
    private static final String INFO_DELETE_SECTION_MESSAGE = "[INFO] 구간이 삭제되었습니다.";

    private SectionOutputView() {
    }

    public static void printSectionFeature() {
        System.out.println(MainOutputView.MAIN_FEATURE_MESSAGE);
        for (SectionFeature sectionFeature : SectionFeature.values()) {
            System.out.println(sectionFeature.toString());
        }
        MainOutputView.printBlank();
    }

    public static void printCreateSection() {
        System.out.println(INFO_CREATE_SECTION_MESSAGE);
    }

    public static void printDeleteSection() {
        System.out.println(INFO_DELETE_SECTION_MESSAGE);
    }
}
