package registration;

import java.util.List;

public class Tree {

    public static void main(String[] args) {

        Course cs301 = new Course(
                "CS301", "Object Oriented Design", 3);

        Requirement rule = new Requirement.AllOf(List.of(
                new Requirement.CourseRequirement("CS201"),
                new Requirement.AnyOf(List.of(
                        new Requirement.CourseRequirement("MATH150"),
                        new Requirement.CourseRequirement("MATH160")
                ))
        ));

        LegacySisClient sis = LegacySisClient.getInstance();

        sis.seed("S007", "CS201", "B", "2025FA");
        sis.seed("S007", "MATH160", "A", "2025FA");

        sis.seed("S008", "MATH150", "A", "2025FA");
        sis.seed("S008", "MATH160", "B", "2025FA");

        System.out.println(cs301.getCode() + " prerequisite: "
                + Requirements.describe(rule));

        System.out.println("S007 passed CS201 and MATH160: "
                + Requirements.satisfiedBy(
                        rule, sis.fetchGradeRows("S007")));

        System.out.println("S008 passed MATH150 and MATH160 (no CS201): "
                + Requirements.satisfiedBy(
                        rule, sis.fetchGradeRows("S008")));
    }
}