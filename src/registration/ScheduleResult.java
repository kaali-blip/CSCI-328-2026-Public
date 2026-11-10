package registration;

import java.util.List;

/** Read-only view of all problems and distinct meeting slots. */
public record ScheduleResult(List<ScheduleProblem> problems,
                             List<MeetingTime> weeklyMeetings) {
    public ScheduleResult {
        problems = List.copyOf(problems);
        weeklyMeetings = List.copyOf(weeklyMeetings);
    }

    public boolean eligible() {
        return problems.isEmpty();
    }
}
