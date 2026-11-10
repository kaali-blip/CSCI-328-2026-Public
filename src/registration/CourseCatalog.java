package registration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Catalog-owned identities: a course can have several visible codes. */
public class CourseCatalog {
    public record CourseId(int number) { }

    private final Map<String, CourseId> identities = new HashMap<>();
    private int nextId = 1;

    public CourseId identityOf(String code) {
        Objects.requireNonNull(code);
        CourseId id = identities.get(code);
        if (id == null) {
            id = new CourseId(nextId++);
            identities.put(code, id);
        }
        return id;
    }

    public boolean sameCourse(String firstCode, String secondCode) {
        return identityOf(firstCode).equals(identityOf(secondCode));
    }

    /** Add or extend a cross-listing, including a third catalog code later. */
    public void crossList(String... codes) {
        if (codes == null || codes.length < 2) {
            throw new IllegalArgumentException("Cross-listing needs at least two codes");
        }
        CourseId shared = null;
        for (String code : codes) {
            Objects.requireNonNull(code);
            if (identities.containsKey(code) && shared == null) {
                shared = identities.get(code);
            }
        }
        if (shared == null) {
            shared = new CourseId(nextId++);
        }
        for (String code : codes) {
            CourseId old = identities.get(code);
            if (old != null && !old.equals(shared)) {
                for (Map.Entry<String, CourseId> entry : identities.entrySet()) {
                    if (entry.getValue().equals(old)) {
                        entry.setValue(shared);
                    }
                }
            }
            identities.put(code, shared);
        }
    }

    /** Both catalog listings refer to one physical section and one seat count. */
    public CourseOffering crossListedOffering(CourseOffering section, Course alias) {
        Objects.requireNonNull(section);
        Objects.requireNonNull(alias);
        if (!sameCourse(section.getCourse().getCode(), alias.getCode())) {
            throw new IllegalArgumentException("Courses are not cross-listed in the catalog");
        }
        return new CourseOffering(section, alias);
    }
}
