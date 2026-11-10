package registration;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Requirements {

    public static boolean satisfiedBy(
            Requirement requirement, String[][] rows) {

        return switch (requirement) {
            case Requirement.CourseRequirement course ->
                Arrays.stream(rows)
                    .anyMatch(row ->
                        row[0].equals(course.code())
                        && Grade.valueOf(row[1]).isPassing());

            case Requirement.AllOf all ->
                all.requirements().stream()
                    .allMatch(r -> satisfiedBy(r, rows));

            case Requirement.AnyOf any ->
                any.requirements().stream()
                    .anyMatch(r -> satisfiedBy(r, rows));
        };
    }

    public static String describe(Requirement requirement) {

        return switch (requirement) {
            case Requirement.CourseRequirement course ->
                course.code();

            case Requirement.AllOf all ->
                "(" + all.requirements().stream()
                    .map(Requirements::describe)
                    .collect(Collectors.joining(" and ")) + ")";

            case Requirement.AnyOf any ->
                "(" + any.requirements().stream()
                    .map(Requirements::describe)
                    .collect(Collectors.joining(" or ")) + ")";
        };
    }
}